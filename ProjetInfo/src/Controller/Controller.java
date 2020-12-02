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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projetinfo.ProductDAO;


/**
 *
 * @author Gaëtan
 */
public class Controller
{
    ArrayList<JButton> menuButton = new ArrayList<>();
    ArrayList<JButton> myButton = new ArrayList<>();
    View myView = new View();

    public Controller()
    {

    }

    public void addAllButtons()
    {
        myView.setVisibleMainpage();
        menuButton.add(myView.getMainPage().getButtonSearch());
        menuButton.add(myView.getMainPage().getButtonManageProduct());
        menuButton.add(myView.getMainPage().getButtonShop());

        for (int i = 0; i < menuButton.size(); i++)
            menuButton.get(i).addActionListener(new RadioButtonListener());
        
        for (int i = 0; i < myButton.size(); i++)
        {
            myButton.get(i).addActionListener(new RadioButtonListener());
        }
    }

    private class RadioButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == menuButton.get(0)) //Bouton search
            {
                    ProductDAO productDAOSearched = new ProductDAO();
                    ArrayList<Integer> listResults = new ArrayList<>();

                    myView.getMainPage().emptyPanel2();
                    
                    listResults = productDAOSearched.searchElement(myView.getMainPage().getSearchBar());

                    ProductListResults(listResults);
            }
            else if (e.getSource() == menuButton.get(1)) //Bouton manage
            {
                myView.getMainPage().emptyPanel2();
                myView.getMainPage().hideScroll();
                myView.getMainPage().addInPanel2(new AddProductPage());
                myView.getMainPage().addPanelInFrame(myView.getMainPage().getPanel2());
                myView.getMainPage().revalidate();
                myView.getMainPage().repaint();
            }
            else if (e.getSource() == menuButton.get(2)) //Bouton shop
            {
                ProductDAO productDAO = new ProductDAO();

                myView.getMainPage().emptyPanel2();

                ProductListResults(productDAO.returnAllElement());
            }
        }
    }

    public void ProductListResults(ArrayList<Integer> listResults)
    {
        int yPanel=0;
        
        if(!listResults.isEmpty())
        {
            for (Integer i : listResults)
            {
                myView.getMainPage().addInPanel2(new ProduitEnListe(i));
                yPanel+=210;
            }

            myView.getMainPage().showScroll();
        }
        else{
            myView.getMainPage().noResult();
            myView.getMainPage().hideScroll();
        }

        if(yPanel<700)
            myView.getMainPage().hideScroll();

        myView.getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
        myView.getMainPage().addPanelInFrame(myView.getMainPage().getPanel2());
        myView.getMainPage().revalidate();
        myView.getMainPage().repaint();
    }
    
}