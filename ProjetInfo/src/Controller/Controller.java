/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import View.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.*;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Gaëtan
 */
public class Controller
{
    // Attributes of Model and of View
    ProductDAO productDAO = new ProductDAO();
    PeopleDAO peopleDAO = new PeopleDAO();
    OrdersDAO ordersDAO = new OrdersDAO();
    View myView = new View();

    // addActionListener to our button
    public Controller()
    {
        ordersDAO.deleteElement();
        
        for (int i = 0; i < myView.getPeopleButton().size(); i++)
            myView.getPeopleButton().get(i).addActionListener(new PeopleButtonListener());
    }

    // addActionListener to our button
    public void addAllButtons()
    {
        myView.setVisibleFrame();

        for (int i = 0; i < myView.getMenuButton().size(); i++)
            myView.getMenuButton().get(i).addActionListener(new RadioButtonListener());
    }

    private class PeopleButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ee)
        {
            if (ee.getSource() == myView.getPeopleButton().get(0)) // Connection button
            {
                if (!peopleDAO.testEmail(myView.getFrame().getFirstPage().getEmail().getText()))
                    JOptionPane.showMessageDialog(null, "Mauvaise Email");

                if (!peopleDAO.Connection(myView.getFrame().getFirstPage().getEmail(), myView.getFrame().getFirstPage().getPassword()) && peopleDAO.testEmail(myView.getFrame().getFirstPage().getEmail().getText()))
                    JOptionPane.showMessageDialog(null, "Mauvais Password");
                if (peopleDAO.Connection(myView.getFrame().getFirstPage().getEmail(), myView.getFrame().getFirstPage().getPassword()) && peopleDAO.testEmail(myView.getFrame().getFirstPage().getEmail().getText()))
                {
                    myView.setEmail(myView.getFrame().getFirstPage().getEmail().getText());
                    myView.setIsEmployee(peopleDAO.statusPeople(myView.getEmail()));
                    myView.getFrame().switchToMainPage();
                    myView.hideManageButton();   
                }
            } else if (ee.getSource() == myView.getPeopleButton().get(1)) // newInscription button
                myView.getFrame().switchToNewInscription();
            else if (ee.getSource() == myView.getPeopleButton().get(2)) // Inscription button
            {
                boolean test = false;
                try
                {
                    if ("Employee".equals((String) myView.getFrame().getNewInscription().getStatus().getSelectedItem()))
                    {
                        String code = JOptionPane.showInputDialog(null, "Entrez le mot de passe des employés");
                        if (!"1234".equals(code))
                        {
                            JOptionPane.showMessageDialog(null, "Mauvais mot de passe");
                            test = true;
                        }
                    }
                    if (test == false)
                        if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Nouvelle inscription effectuée");
                            myView.getFrame().getNewInscription().setEmail();
                            myView.getFrame().getNewInscription().setFirstname();
                            myView.getFrame().getNewInscription().setName();
                            myView.getFrame().getNewInscription().setPassword();
                            myView.getFrame().getNewInscription().setPassword2();
                            myView.getFrame().getNewInscription().revalidate();
                            myView.getFrame().getNewInscription().repaint();
                            myView.getFrame().switchToConnexionPage();
                        } else
                        {
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 1)
                                JOptionPane.showMessageDialog(null, "L'email entré existe déjà");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 2)
                                JOptionPane.showMessageDialog(null, "L'email entré n'est pas disponible");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 3)
                                JOptionPane.showMessageDialog(null, "Vous n'avez pas mis de nom");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 4)
                                JOptionPane.showMessageDialog(null, "Vous n'avez pas mis de prénom");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 6)
                                JOptionPane.showMessageDialog(null, "Vos 2 mots de passe ne correspondent pas");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 5)
                                JOptionPane.showMessageDialog(null, "Votre mot de passe est trop court");
                            if (peopleDAO.newinscription(myView.getFrame().getNewInscription().getEmail(), myView.getFrame().getNewInscription().getPassword(), myView.getFrame().getNewInscription().getPassword2(), myView.getFrame().getNewInscription().getTheName(), myView.getFrame().getNewInscription().getFirstname(), myView.getFrame().getNewInscription().getStatus()) == 50)
                                JOptionPane.showMessageDialog(null, "Erreur");
                        }
                } catch (HeadlessException e)
                {
                    System.out.println("Erreur New Inscription");
                }
            }
        }

    }

    private class RadioButtonListener implements ActionListener
    {

        @Override
        @SuppressWarnings("empty-statement")
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == myView.getMenuButton().get(0)) // Button search
            {
                ArrayList<Integer> listResults = productDAO.searchElement(myView.getFrame().getMainPage().getSearchBar(), false);
                myView.getFrame().getMainPage().emptyPanel2();
                ProductListResults(listResults, 1);
            } else if (e.getSource() == myView.getMenuButton().get(1)) //Button manage products
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, 660));
                myView.getFrame().getMainPage().hideScroll();
                myView.getManagerButton().clear();

                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                myView.getManagerButton().add(myView.getFrame().getMainPage().getManagerPage().getManagerSearchButton());
                myView.getManagerButton().add(myView.getFrame().getMainPage().getManagerPage().getAddButton());
                myView.getManagerButton().add(new JButton());

                for (int i = 0; i < myView.getManagerButton().size(); i++)
                    myView.getManagerButton().get(i).addActionListener(new ManagerButtonListener());

                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } else if (e.getSource() == myView.getMenuButton().get(2)) // Button shop
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().resetScroll();
                ProductListResults(productDAO.returnAllElement(), 1);

            } else if (e.getSource() == myView.getMenuButton().get(3)) //Button pastOrders
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
                        ArrayList<Orders> myOrdersTest = ordersDAO.getPastOrders(orderNumber.get(i));
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

                int yPanel = 210 * myOrdersSearch.size() + 80 * pastOrders.size();

                if (yPanel < 700)
                    myView.getFrame().getMainPage().hideScroll();

                myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } else if (e.getSource() == myView.getMenuButton().get(4)) // Button cart
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

                for (Integer returnElement : productDAO.returnElements())
                    allProducts.add(0);

                allProducts = ordersDAO.getOnTrend(allProducts);

                for (int i = 0; i < productDAO.returnElements().size(); i++)
                {
                    Pair<Integer, Integer> pairElement = new Pair<>(i, allProducts.get(i));
                    pairList.add(pairElement);
                }

                for (Pair<Integer, Integer> pairList1 : pairList)
                    for (int j = 0; j < pairList.size() - 1; j++)
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

            } else if (e.getSource() == myView.getMenuButton().get(6)) // Button promotion
            {
                ArrayList<Integer> listResults = productDAO.searchPromotion();
                myView.getFrame().getMainPage().emptyPanel2();
                ProductListResults(listResults, 1);
            } else if (e.getSource() == myView.getMenuButton().get(7)) //Button profile
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().setProfilPage(new ProfilPage(myView.getEmail()));
                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getProfilPage());
                myView.getFrame().getMainPage().hideScroll();
                myView.getFrame().getMainPage().resetScroll();
                myView.setModifierProfil(myView.getFrame().getProfilPage().getProfileModif());
                myView.getModifierProfil().addActionListener(new RadioButtonListener());
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            } 
             else if (e.getSource() == myView.getMenuButton().get(8)) //Button disconnect
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().resetScroll();
                myView.getFrame().getMainPage().hideScroll();
                myView.getFrame().switchToConnexionPage();
                ordersDAO.getOrders().clear();
                myView.getFrame().getFirstPage().setInputEmail();
                myView.getFrame().getFirstPage().setInputPassword();
                myView.getFrame().getFirstPage().revalidate();
                myView.getFrame().getFirstPage().repaint();
            } 
            else if (e.getSource() == myView.getModifierProfil()) // Button change profile
            {         
             peopleDAO.changeElement(myView.getFrame().getProfilPage().getTheName(), myView.getFrame().getProfilPage().getPassword(), myView.getFrame().getProfilPage().getFirstname(), myView.getFrame().getProfilPage().getEmail());
             JOptionPane.showMessageDialog(null, "Profil mis à jour");
            }
            
            else
            {
                for (int i = 0; i < myView.getMyButton().size(); i++)
                    if (e.getSource() == myView.getMyButton().get(i))
                        switch (Integer.parseInt(productDAO.getQuantityToBuy().get(0).getText()))
                        {
                            case -2:
                                myView.getFrame().setUpdateButton(productDAO.getKeyList().get(i));
                                myView.getFrame().getMainPage().emptyPanel2();
                                myView.getFrame().getMainPage().resetScroll();
                                myView.getFrame().getMainPage().hideScroll();
                                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getUpdateButton());
                                productDAO.getQuantityToBuy().clear();
                                myView.getMyButton().clear();
                                productDAO.getQuantityToBuy().add(new JTextField("-21"));
                                myView.getMyButton().add(myView.getFrame().getUpdateButton().getValidateButton());
                                myView.getMyButton().add(myView.getFrame().getUpdateButton().getDeleteButton());
                                myView.getMyButton().get(0).addActionListener(new RadioButtonListener());
                                myView.getMyButton().get(1).addActionListener(new RadioButtonListener());
                                myView.getFrame().getMainPage().addPanelInFrame();
                                myView.getFrame().getMainPage().revalidate();
                                myView.getFrame().getMainPage().repaint();
                                break;
                            case -21:
                                if (e.getSource() == myView.getMyButton().get(0))
                                {
                                    if(isAGoodProduct(myView.getFrame().getUpdateButton().getQuantity(), myView.getFrame().getUpdateButton().getPrice(),myView.getFrame().getUpdateButton().getValuePromotion(), myView.getFrame().getUpdateButton().getMinPromotion(), myView.getFrame().getUpdateButton().getImageURL()))
                                    {
                                        productDAO.changeElement("name", myView.getFrame().getUpdateButton().getTheName(), myView.getFrame().getUpdateButton().getProductNo());
                                        productDAO.changeElement("price", myView.getFrame().getUpdateButton().getPrice(), myView.getFrame().getUpdateButton().getProductNo());
                                        productDAO.changeElement("quantity", myView.getFrame().getUpdateButton().getQuantity(), myView.getFrame().getUpdateButton().getProductNo());
                                        productDAO.changeElement("lienURL", myView.getFrame().getUpdateButton().getImageURL(), myView.getFrame().getUpdateButton().getProductNo());
                                        productDAO.changeElement("description", myView.getFrame().getUpdateButton().getDescription(), myView.getFrame().getUpdateButton().getProductNo());

                                        if (Double.parseDouble(myView.getFrame().getUpdateButton().getValuePromotion().getText()) == 0 || Integer.parseInt(myView.getFrame().getUpdateButton().getMinPromotion().getText()) == 0)
                                        {
                                            myView.getFrame().getUpdateButton().deleteMinPromotion();
                                            myView.getFrame().getUpdateButton().deleteValuePromotion();
                                        }
                                        productDAO.changeElement("minimumPromotion", myView.getFrame().getUpdateButton().getMinPromotion(), myView.getFrame().getUpdateButton().getProductNo());
                                        productDAO.changeElement("valuePromotion", myView.getFrame().getUpdateButton().getValuePromotion(), myView.getFrame().getUpdateButton().getProductNo());

                                        JOptionPane.showMessageDialog(null, "Produit mis à jour");

                                        productDAO.getQuantityToBuy().clear();
                                        productDAO.getKeyList().clear();
                                        productDAO.getQuantityToBuy().add(new JTextField("-2"));
                                        productDAO.getKeyList().add(myView.getFrame().getUpdateButton().getProductNo());
                                        myView.getMyButton().get(0).doClick();
                                    }
                                    
                                } else if (e.getSource() == myView.getMyButton().get(1))
                                {
                                    myView.getFrame().getUpdateButton().deleteQuantity();
                                    productDAO.deleteElement(myView.getFrame().getUpdateButton().getProductNo());

                                    JOptionPane.showMessageDialog(null, "Produit supprimé");
                                }
                                break;
                            default:
                                ordersDAO.AddShop(productDAO.getQuantityToBuy().get(i), myView.getEmail(), productDAO.getKeyList().get(i));
                                JOptionPane.showMessageDialog(null, "Produit ajouté !");
                                break;
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

    private class ManagerButtonListener implements ActionListener //Button for employee
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == myView.getManagerButton().get(0)) //Button Search
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().addInPanel2(myView.getFrame().getMainPage().getManagerPage());
                myView.getFrame().getMainPage().addPanelInFrame();

                ProductDAO productDAOSearched = new ProductDAO();
                ArrayList<Integer> listResults = productDAOSearched.searchElement(myView.getFrame().getMainPage().getManagerPage().getManagerSearchBar(), true);

                ProductListResults(listResults, 2);
            } else if (event.getSource() == myView.getManagerButton().get(1)) //Button Add Product
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().hideScroll();
                
                AddProductPage newAddProductPage = new AddProductPage();
                myView.getFrame().setAddPage(newAddProductPage);
                myView.getFrame().getMainPage().addInPanel2(newAddProductPage);
                myView.getManagerButton().set(2,newAddProductPage.getAddValidate());
                myView.getManagerButton().get(2).addActionListener(new ManagerButtonListener());
                
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            }
            else if (event.getSource() == myView.getManagerButton().get(2)) //Button Validate / add
            {
                if(isAGoodProduct(myView.getFrame().getAddPage().getQuantity(), myView.getFrame().getAddPage().getPrice(),myView.getFrame().getAddPage().getValuePromotion(), myView.getFrame().getAddPage().getMinPromotion(), myView.getFrame().getAddPage().getImageURL()))
                {
                    if (Double.parseDouble(myView.getFrame().getAddPage().getValuePromotion().getText()) == 0 || Integer.parseInt(myView.getFrame().getAddPage().getMinPromotion().getText()) == 0)
                    {
                        myView.getFrame().getAddPage().getMinPromotion().setText("0");
                        myView.getFrame().getAddPage().getValuePromotion().setText("0");
                    }
                    
                    productDAO.addElement(myView.getFrame().getAddPage().getTheName(), myView.getFrame().getAddPage().getPrice(),
                            myView.getFrame().getAddPage().getQuantity(), myView.getFrame().getAddPage().getMinPromotion(),
                            myView.getFrame().getAddPage().getValuePromotion(), myView.getFrame().getAddPage().getImageURL(),
                            myView.getFrame().getAddPage().getDescription());
                    JOptionPane.showMessageDialog(null, "Produit ajouté !");
                    
                    myView.getFrame().discardAddPage();
                    myView.getMenuButton().get(1).doClick();
                }
            }
        }
    }

    // Method to display a list of products
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

        if (indice == 2)
            yPanel += 100;

        if (yPanel < 660)
            myView.getFrame().getMainPage().hideScroll();
        else
            myView.getFrame().getMainPage().showScroll();

        myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
        myView.getFrame().getMainPage().addPanelInFrame();
        myView.getFrame().getMainPage().revalidate();
        myView.getFrame().getMainPage().repaint();
    }
    
    public boolean isAGoodProduct(JTextField quantity, JTextField price, JTextField valuePromotion, JTextField minPromotion, JTextField imageURL) // add new product conditions
    {
        try
        {
            if(Integer.parseInt(quantity.getText())<0)
            {
                JOptionPane.showMessageDialog(null, "Entrée erronée : Quantité négative");
                return false;
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Entrée erronée : Quantité n'est pas un entier");
            return false;
        }
        
        try
        {
            if(Double.parseDouble(price.getText())<0)
            {
                JOptionPane.showMessageDialog(null, "Entrée erronée : Prix est négatif");
                return false;
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Entrée erronée : Prix n'est pas un réel");
            return false;
        }
        
        try
        {
            if(Integer.parseInt(minPromotion.getText())<0)
            {
                JOptionPane.showMessageDialog(null, "Entrée erronée : Minimum Promotion négatif");
                return false;
            }
            
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Entrée erronée : Minimum Promotion n'est pas un entier");
            return false;
        }
        
        try
        {
            if(Integer.parseInt(minPromotion.getText())==0)
                valuePromotion.setText("0");
            
            if(Double.parseDouble(valuePromotion.getText())<0 || Double.parseDouble(valuePromotion.getText())>100)
            {
                JOptionPane.showMessageDialog(null, "Entrée erronée : Valeur de promotion n'est pas entre 0 et 100");
                return false;
            }
            
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Entrée erronée : Valeur de promotion n'est pas un réel");
            return false;
        }
        
        try {
            URL url = new URL(imageURL.getText());
            Image image = ImageIO.read(url);
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Lien d'image invalide");
            return false;
        }
        
        return true;
    }
}
