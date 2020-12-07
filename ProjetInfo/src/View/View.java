/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.*;

public class View
{
    Frame frame = new Frame(); // Frame to display things
    String email; // Current email of the user
    boolean isEmployee; // Boolean to know if he is employee or customer
    
    // All buttons to click 
    ArrayList<JButton> menuButton;
    ArrayList<JButton> myButton;
    ArrayList<JButton> suppButton;
    JButton commander;
    JButton valider;
    JButton modifierProfil;
    ArrayList<JButton> managerButton;
    ArrayList<JButton> peopleButton;

    // add buttons to arrayList
    public View()
    {
        menuButton = new ArrayList<>();
        myButton = new ArrayList<>();
        suppButton = new ArrayList<>();
        commander = new JButton();
        modifierProfil = new JButton();
        valider = new JButton();
        managerButton = new ArrayList<>();
        peopleButton = new ArrayList<>();

        menuButton.add(frame.getMainPage().getButtonSearch());
        menuButton.add(frame.getMainPage().getButtonManageProduct());
        menuButton.add(frame.getMainPage().getButtonShop());
        menuButton.add(frame.getMainPage().getPastOrderButton());
        menuButton.add(frame.getMainPage().getButtonCart());
        menuButton.add(frame.getMainPage().getTrendButton());
        menuButton.add(frame.getMainPage().getButtonSales());
        menuButton.add(frame.getMainPage().getButtonProfile());
        menuButton.add(frame.getMainPage().getButtonDisoconnect());

        peopleButton.add(frame.getFirstPage().getConnexion());
        peopleButton.add(frame.getFirstPage().getTransitionInscription());
        peopleButton.add(frame.getNewInscription().getInscription());
        
    }
    
    // Hide manageButton if the user is a customer, else show it
    public void hideManageButton()
    {
        frame.getMainPage().manageButton(isEmployee);
    }
    
    // Getters
    public String getEmail()
    {
        return email;
    }
        
    public Frame getFrame()
    {
        return frame;
    }
    
    public JButton getCommander()
    {
        return commander;
    }

    public boolean getIsEmployee()
    {
        return isEmployee;
    }
    
        public JButton getValider()
    {
        return valider;
    }

    public ArrayList<JButton> getMenuButton()
    {
        return menuButton;
    }

    public ArrayList<JButton> getMyButton()
    {
        return myButton;
    }

    public ArrayList<JButton> getPeopleButton()
    {
        return peopleButton;
    }

    public ArrayList<JButton> getSuppButton()
    {
        return suppButton;
    }

    public ArrayList<JButton> getManagerButton()
    {
        return managerButton;
    }
    
    public JButton getModifierProfil()
    {
        return modifierProfil;
    }

     // Setters
    public void setIsEmployee(String status)
    {
        isEmployee = status.equals("Employee");
    }
                
    public void setVisibleFrame()
    {
        frame.setVisible(true);
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    public void setCommander(JButton e)
    {
        commander = e;
    }

    public void setValider(JButton e)
    {
        valider = e;
    }

    public void setModifierProfil(JButton modifierProfil)
    {
        this.modifierProfil = modifierProfil;
    }

}
