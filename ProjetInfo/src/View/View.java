/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Utilisateur
 */
public class View
{
    Frame frame = new Frame();
    String email = "gaetan.bouchy@yahoo.fr";
    ArrayList<JButton> menuButton;
    ArrayList<JButton> myButton;
    ArrayList<JButton> managerButton;
    UpdateProductPage updateProductPage;
    
    public View()
    {
        menuButton = new ArrayList<>();
        myButton = new ArrayList<>();
        managerButton = new ArrayList<>();
        updateProductPage = new UpdateProductPage();
        
        menuButton.add(frame.getMainPage().getButtonSearch());
        menuButton.add(frame.getMainPage().getButtonManageProduct());
        menuButton.add(frame.getMainPage().getButtonShop());
        menuButton.add(frame.getMainPage().getPastOrderButton());
        menuButton.add(frame.getMainPage().getButtonCart());
    }
    
    public void setVisibleFrame()
    {
        frame.setVisible(true);
    }
    
    public Frame getFrame()
    {
       return frame; 
    }
    
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public ArrayList<JButton> getMenuButton()
    {
        return menuButton;
    }
    
    public ArrayList<JButton> getMyButton()
    {
        return myButton;
    }
    
    public ArrayList<JButton> getManagerButton()
    {
        return managerButton;
    }
    
    public void setUpdateButton(int productNo)
    {
        updateProductPage = new UpdateProductPage(productNo);
    }
    
    public UpdateProductPage getUpdateButton()
    {
        return updateProductPage;
    }
}
