/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.swing.JButton;
import View.*;
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

    ArrayList<JButton> myButton = new ArrayList<>();
    View myView = new View();

    public Controller()
    {

    }

    public void addAllButtons()
    {
        myView.setVisibleMainpage();
        myButton.add(myView.getMainPage().getButtonSearch());
        myButton.add(myView.getMainPage().getButtonAddProduct());

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
            if (e.getSource() == myButton.get(0)) //Bouton search
            {
                    ProductDAO productDAOSearched = new ProductDAO();
                    ArrayList<Integer> listResults = new ArrayList<>();

                    myView.getMainPage().emptyPanel2();
                    
                    listResults = productDAOSearched.searchElement(myView.getMainPage().getSearchBar());

                    if(!listResults.isEmpty())
                    {
                        for (Integer i : listResults)
                            myView.getMainPage().addInPanel2(new ProduitEnListe(i));
                    }
                    else{
                        myView.getMainPage().noResult();
                    }
                    myView.getMainPage().addPanelInFrame(myView.getMainPage().getPanel2());
                    myView.getMainPage().revalidate();
                    myView.getMainPage().repaint();
            }
            else if (e.getSource() == myButton.get(1)) //Bouton add
            {
                myView.getMainPage().emptyPanel2();
                myView.getMainPage().addInPanel2(new AddProductPage());
                myView.getMainPage().addPanelInFrame(myView.getMainPage().getPanel2());
                myView.getMainPage().revalidate();
                myView.getMainPage().repaint();
            }
        }
    }
    
    
}