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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projetinfo.ProductDAO;
import projetinfo.TablesDAO;


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
        myView.setVisibleFrame();
        menuButton.add(myView.getFrame().getMainPage().getButtonSearch());
        menuButton.add(myView.getFrame().getMainPage().getButtonManageProduct());
        menuButton.add(myView.getFrame().getMainPage().getButtonShop());

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

                    myView.getFrame().getMainPage().emptyPanel2();
                    
                    listResults = productDAOSearched.searchElement(myView.getFrame().getMainPage().getSearchBar());

                    ProductListResults(listResults);
            }
            else if (e.getSource() == menuButton.get(1)) //Bouton manage
            {
                myView.getFrame().getMainPage().emptyPanel2();
                myView.getFrame().getMainPage().hideScroll();
                myView.getFrame().getMainPage().addInPanel2(new AddProductPage());
                myView.getFrame().getMainPage().addPanelInFrame();
                myView.getFrame().getMainPage().revalidate();
                myView.getFrame().getMainPage().repaint();
            }
            else if (e.getSource() == menuButton.get(2)) //Bouton shop
            {
                ProductDAO productDAO = new ProductDAO();

                myView.getFrame().getMainPage().emptyPanel2();

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
                myView.getFrame().getMainPage().addInPanel2(new ProduitEnListe(i));
                yPanel+=210;
            }

            myView.getFrame().getMainPage().showScroll();
        }
        else{
            myView.getFrame().getMainPage().noResult();
            myView.getFrame().getMainPage().hideScroll();
        }

        if(yPanel<700)
            myView.getFrame().getMainPage().hideScroll();

        myView.getFrame().getMainPage().getPanel2().setPreferredSize(new Dimension(1600, yPanel));
        myView.getFrame().getMainPage().addPanelInFrame();
        myView.getFrame().getMainPage().revalidate();
        myView.getFrame().getMainPage().repaint();
    }
    
}