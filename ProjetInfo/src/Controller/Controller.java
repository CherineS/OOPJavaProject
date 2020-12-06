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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.Orders;
import Model.ProductDAO;
import Model.PeopleDAO;
import Model.OrdersDAO;
import Model.Product;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Gaëtan
 */
public class Controller
{

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

                listResults = productDAO.searchElement(myView.getFrame().getMainPage().getSearchBar(), false);

                myView.getFrame().getMainPage().emptyPanel2();
                ProductListResults(listResults, 1);
            } else if (e.getSource() == myView.getMenuButton().get(1)) //Bouton manage
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getManagerButton().clear();

                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                myView.getManagerButton().add(myView.getFrame().getMainPage().getManagerPage().getManagerSearchButton());
                myView.getManagerButton().add(myView.getFrame().getMainPage().getManagerPage().getAddButton());

                for (int i = 0; i < myView.getManagerButton().size(); i++)
                    myView.getManagerButton().get(i).addActionListener(new ManagerButtonListener());

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
                            String orderProdNo = "" + myOrdersTest.get(j).getOrderNumber() + "-" + myOrdersTest.get(j).getProducts().getProductNo();
                            myProd.setQuantity(ordersDAO.findQuantity(orderProdNo));
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

                    OrdersPaymentAndPrice myOrders = new OrdersPaymentAndPrice(ordersDAO.getOrders());
                    myView.setCommander(myOrders.getCommander());
                    myView.getCommander().addActionListener(new RadioButtonListener());

                    myView.getFrame().getMainPage().addInPanel2(myOrders);

                    yPanel += 100;
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
            } else if (e.getSource() == myView.getCommander())
            {
                myView.getFrame().getMainPage().emptyPanel2();
                PaymentPage myPaymentPage = new PaymentPage();
                myView.getFrame().getMainPage().addInPanel2(myPaymentPage);
                myView.getFrame().getMainPage().showScroll();
                myView.getFrame().getMainPage().hideScroll();
                myView.getFrame().getMainPage().resetScroll();
                myView.setValider(myPaymentPage.getValidate());
                myView.getValider().addActionListener(new RadioButtonListener());
            } else if (e.getSource() == myView.getValider())
            {
                myView.getFrame().getMainPage().emptyPanel2();
                JOptionPane.showMessageDialog(null, "Votre commande a été validée !");
                ordersDAO.addOrders();
                myView.getMenuButton().get(2).doClick();
            } else if (e.getSource() == myView.getMenuButton().get(5)) // Button Trend
            {
                ArrayList<Integer> allProducts = new ArrayList<>();
                ArrayList<Integer> result = new ArrayList<>();
                ArrayList<Pair<Integer, Integer>> pairList = new ArrayList<>();

                for (int i = 0; i < productDAO.returnElements().size(); i++)
                    allProducts.add(0);

                allProducts = ordersDAO.getOnTrend(allProducts);

                for (int i = 0; i < productDAO.returnElements().size(); i++)
                {
                    Pair<Integer, Integer> pairElement = new Pair<>(i, allProducts.get(i));
                    pairList.add(pairElement);
                }

                for(int i = 0; i < pairList.size(); i++)
                    for(int j = 0; j < pairList.size() - 1; j++)
                        if (pairList.get(j).right < pairList.get(j + 1).right)
                        {
                            Pair<Integer, Integer> tempon = new Pair<>(pairList.get(j).left, pairList.get(j).right);
                            pairList.set(j, pairList.get(j + 1));
                            pairList.set(j + 1, tempon);
                        }

                myView.getFrame().getMainPage().emptyPanel2();
                
                if (pairList.size() > 1)
                    result.add(pairList.get(0).left);

                if (pairList.size() > 2)
                    result.add(pairList.get(1).left);

                if (pairList.size() > 3)
                    result.add(pairList.get(2).left);

                ProductListResults(result, 1);

            } else
            {
                for (int i = 0; i < myView.getMyButton().size(); i++)
                    if (e.getSource() == myView.getMyButton().get(i))
                        if (Integer.parseInt(productDAO.getQuantityToBuy().get(0).getText()) == -2)
                        {
                            myView.setUpdateButton(productDAO.getKeyList().get(i));

                            myView.getFrame().getMainPage().emptyPanel2();
                            myView.getFrame().getMainPage().hideScroll();

                            myView.getFrame().getMainPage().addInPanel2(myView.getUpdateButton());
                            productDAO.getQuantityToBuy().clear();
                            myView.getMyButton().clear();

                            productDAO.getQuantityToBuy().add(new JTextField("-21"));
                            myView.getMyButton().add(myView.getUpdateButton().getValidateButton());
                            myView.getMyButton().add(myView.getUpdateButton().getDeleteButton());
                            myView.getMyButton().get(0).addActionListener(new RadioButtonListener());
                            myView.getMyButton().get(1).addActionListener(new RadioButtonListener());

                            myView.getFrame().getMainPage().addPanelInFrame();
                            myView.getFrame().getMainPage().revalidate();
                            myView.getFrame().getMainPage().repaint();
                        } else if (Integer.parseInt(productDAO.getQuantityToBuy().get(0).getText()) == -21)
                        {
                            if (e.getSource() == myView.getMyButton().get(0))
                            {
                                productDAO.changeElement("name", myView.getUpdateButton().getTheName(), myView.getUpdateButton().getProductNo());
                                productDAO.changeElement("price", myView.getUpdateButton().getPrice(), myView.getUpdateButton().getProductNo());
                                productDAO.changeElement("quantity", myView.getUpdateButton().getQuantity(), myView.getUpdateButton().getProductNo());
                                productDAO.changeElement("lienURL", myView.getUpdateButton().getImageURL(), myView.getUpdateButton().getProductNo());
                                productDAO.changeElement("description", myView.getUpdateButton().getDescription(), myView.getUpdateButton().getProductNo());

                                if (Double.parseDouble(myView.getUpdateButton().getValuePromotion().getText()) == 0 || Double.parseDouble(myView.getUpdateButton().getMinPromotion().getText()) == 0)
                                {
                                    myView.getUpdateButton().deleteMinPromotion();
                                    myView.getUpdateButton().deleteValuePromotion();
                                }
                                productDAO.changeElement("minimumPromotion", myView.getUpdateButton().getMinPromotion(), myView.getUpdateButton().getProductNo());
                                productDAO.changeElement("valuePromotion", myView.getUpdateButton().getValuePromotion(), myView.getUpdateButton().getProductNo());

                                JOptionPane.showMessageDialog(null, "Produit mis à jour");
                            } else if (e.getSource() == myView.getMyButton().get(1))
                            {
                                myView.getUpdateButton().deleteQuantity();
                                productDAO.deleteElement(myView.getUpdateButton().getProductNo());

                                JOptionPane.showMessageDialog(null, "Produit supprimé");
                            }
                        } else
                        {
                            ordersDAO.AddShop(productDAO.getQuantityToBuy().get(i), myView.getEmail(), productDAO.getKeyList().get(i));
                            JOptionPane.showMessageDialog(null, "Produit ajouté !");
                        }
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
            if (event.getSource() == myView.getManagerButton().get(0)) //Search
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                ProductDAO productDAOSearched = new ProductDAO();
                ArrayList<Integer> listResults = new ArrayList<>();

                listResults = productDAOSearched.searchElement(myView.getFrame().getMainPage().getManagerPage().getManagerSearchBar(), true);

                ProductListResults(listResults, 2);
            } else if (event.getSource() == myView.getManagerButton().get(1)) //Add Product
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
                {
                    productDAO.addQuantityToBuy(new JTextField("-2"));

                    ManagerProduitEnListe newManagerProduitEnListe = new ManagerProduitEnListe(i);
                    myView.getFrame().getMainPage().addInPanel2(newManagerProduitEnListe);
                    myView.getMyButton().add(newManagerProduitEnListe.getUpdateButton());
                }
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
