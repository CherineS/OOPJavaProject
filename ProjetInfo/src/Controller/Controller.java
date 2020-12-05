/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.swing.JButton;
import View.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextField;
import projetinfo.Orders;
import projetinfo.ProductDAO;
import projetinfo.PeopleDAO;
import projetinfo.OrdersDAO;
import projetinfo.Product;

/**
 *
 * @author Gaëtan
 */
public class Controller
{

    ArrayList<JButton> managerButton = new ArrayList<>();
    ArrayList<Integer> toDelete = new ArrayList<>();
    ProductDAO productDAO = new ProductDAO();
    PeopleDAO peopleDAO = new PeopleDAO();
    OrdersDAO ordersDAO = new OrdersDAO();
    View myView = new View();

    public Controller()
    {

    }

    public void addAllButtons()
    {
        myView.setVisibleFrame();

        for (int i = 0; i < myView.getMenuButton().size(); i++)
            myView.getMenuButton().get(i).addActionListener(new RadioButtonListener());
    }

    private class RadioButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == myView.getMenuButton().get(0)) //Bouton search
            {
                ArrayList<Integer> listResults = new ArrayList<>();

                listResults = productDAO.searchElement(myView.getFrame().getMainPage().getSearchBar());

                myView.getFrame().getMainPage().emptyPanel2();
                ProductListResults(listResults, 1);
            } else if (e.getSource() == myView.getMenuButton().get(1)) //Bouton manage
            {
                myView.getFrame().getMainPage().emptyPanel2();

                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                managerButton.add(myView.getFrame().getMainPage().getManagerPage().getManagerSearchButton());
                managerButton.add(myView.getFrame().getMainPage().getManagerPage().getAddButton());

                for (int i = 0; i < managerButton.size(); i++)
                    managerButton.get(i).addActionListener(new ManagerButtonListener());

                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } else if (e.getSource() == myView.getMenuButton().get(2)) //Bouton shop
            {
                myView.getFrame().getMainPage().emptyPanel2();
                ProductListResults(productDAO.returnAllElement(), 1);

            } else if (e.getSource() == myView.getMenuButton().get(3)) //Bouton past orders
            {
                myView.getFrame().getMainPage().emptyPanel2();
                ArrayList<Orders> myOrdersSearch = ordersDAO.searchOrder(myView.getEmail());
                ArrayList<AllOrders> pastOrders = new ArrayList<>();

                ArrayList<Integer> orderNumber = new ArrayList<>();
                for (int i = 0; i < myOrdersSearch.size(); i++)
                    orderNumber.add(myOrdersSearch.get(i).getOrderNumber());

                Set<Integer> set = new HashSet<>(orderNumber);
                orderNumber.clear();
                orderNumber.addAll(set);
                AllOrders order = new AllOrders();

                if (!myOrdersSearch.isEmpty())
                {
                    for (int i = 0; i < orderNumber.size(); i++)
                    {
                        ArrayList<Orders> myOrdersTest = new ArrayList<>();
                        myOrdersTest = ordersDAO.getPastOrders(orderNumber.get(i));
                        for (int j = 0; j < myOrdersTest.size(); j++)
                        {
                            Product myProd;
                            myProd = productDAO.createJavaProduct(myOrdersTest.get(j).getProducts().getProductNo());
                            myOrdersTest.get(j).setProducts(myProd);
                            order.addPanel(new CommandeEnListe(myOrdersTest.get(j)));
                        }

                        pastOrders.add(order);
                        myOrdersTest.clear();
                        order = new AllOrders();
                    }

                    for (int i = 0; i < pastOrders.size(); i++)
                    {
                        pastOrders.get(i).addOrderNo(i + 1);
                        myView.getFrame().getMainPage().addInPanel2(pastOrders.get(i));
                    }

                    myView.getFrame().getMainPage().showScroll();

                } else
                {
                    myView.getFrame().getMainPage().displayText("Aucun résultat");
                    myView.getFrame().getMainPage().hideScroll();
                }

                int yPanel = 210 * myOrdersSearch.size() + 80 * pastOrders.size();;
                if (yPanel < 700)
                    myView.getFrame().getMainPage().hideScroll();

                myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } else if (e.getSource() == myView.getMenuButton().get(4)) //Bouton panier
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getSuppButton().clear();
                
                int yPanel = 0;

                if (!ordersDAO.getOrders().isEmpty())
                {
                    for (int i = 0; i < ordersDAO.getOrders().size(); i++)
                    {
                        CurrentOrders currOrders = new CurrentOrders(ordersDAO.getOrders().get(i));
                        myView.getFrame().getMainPage().addInPanel2(currOrders);
                        myView.getSuppButton().add(currOrders.getSupprimer());
                        
                        yPanel += 210;
                    }

                    myView.getFrame().getMainPage().showScroll();
                } else
                {
                    myView.getFrame().getMainPage().displayText("Panier vide");
                    myView.getFrame().getMainPage().hideScroll();
                }

                for (int i = 0; i < myView.getSuppButton().size(); i++)
                    myView.getSuppButton().get(i).addActionListener(new RadioButtonListener());

                if (yPanel < 700)
                    myView.getFrame().getMainPage().hideScroll();

                myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } else
            {
                for (int i = 0; i < myView.getMyButton().size(); i++)
                    if (e.getSource() == myView.getMyButton().get(i))
                        ordersDAO.AddShop(productDAO.getQuantityToBuy().get(i), myView.getEmail(), productDAO.getKeyList().get(i));

                for (int i = 0; i < myView.getSuppButton().size(); i++) 
                    if (e.getSource() == myView.getSuppButton().get(i))
                    {
                        ordersDAO.deleteShop(ordersDAO.getOrders().get(i).getProducts().getProductNo());
                        myView.getMenuButton().get(4).doClick();
                    }            
            }
        }
    }

    private class ManagerButtonListener implements ActionListener //Bouton de l'employé
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == managerButton.get(0)) //Search
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                ProductDAO productDAOSearched = new ProductDAO();
                ArrayList<Integer> listResults = new ArrayList<>();

                listResults = productDAOSearched.searchElement(myView.getFrame().getMainPage().getManagerPage().getManagerSearchBar());

                ProductListResults(listResults, 2);
            } else if (event.getSource() == managerButton.get(1)) //Add Product
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().hideScroll();
                myView.getFrame().getMainPage().addInPanel2(new AddProductPage());
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            }
        }
    }

    //Méthode d'affichage d'une liste de produits
    public void ProductListResults(ArrayList<Integer> listResults, int indice)
    {
        int yPanel = 0;
        myView.getMyButton().clear();
        productDAO.getQuantityToBuy().clear();

        if (!listResults.isEmpty())
        {
            productDAO.setKeyList(listResults);

            for (Integer i : listResults)
            {
                if (indice == 1)
                {
                    ProduitEnListe newProduitEnListe = new ProduitEnListe(i);
                    myView.getFrame().getMainPage().addInPanel2(newProduitEnListe);
                    myView.getMyButton().add(newProduitEnListe.getAddToCartButton());
                    productDAO.addQuantityToBuy(newProduitEnListe.getQuantityToBuy());
                } else if (indice == 2)
                    myView.getFrame().getMainPage().addInPanel2(new ManagerProduitEnListe(i));
                yPanel += 210;
            }
        } else
            myView.getFrame().getMainPage().displayText("Aucun résultat");

        for (int i = 0; i < myView.getMyButton().size(); i++)
            myView.getMyButton().get(i).addActionListener(new RadioButtonListener());

        if (yPanel < 700)
            myView.getFrame().getMainPage().hideScroll();
        else
            myView.getFrame().getMainPage().showScroll();

        myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
        myView.getFrame().getMainPage().addPanelInFrame();
        myView.getFrame().getMainPage().revalidate();
        myView.getFrame().getMainPage().repaint();
    }
}
