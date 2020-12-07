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
    String email;
    boolean isEmployee;
    ArrayList<JButton> menuButton;
    ArrayList<JButton> myButton;
    ArrayList<JButton> suppButton;
    JButton commander;
    JButton valider;
    JButton modifierProfil;
    ArrayList<JButton> managerButton;
    ArrayList<JButton> peopleButton;

    public View()
    {
        menuButton = new ArrayList<>();
        myButton = new ArrayList<>();
        suppButton = new ArrayList<>();
        commander = new JButton();
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
    

    public void hideManageButton()
    {
        frame.getMainPage().manageButton(isEmployee);
    }
                
    public void setVisibleFrame()
    {
        frame.setVisible(true);
    }

    public Frame getFrame()
    {
        return frame;
    }

    public boolean getIsEmployee()
    {
        return isEmployee;
    }

    public void setIsEmployee(String status)
    {
        isEmployee = status.equals("Employee");
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    public void setCommander(JButton e)
    {
        commander = e;
    }

    public JButton getCommander()
    {
        return commander;
    }

    public void setValider(JButton e)
    {
        valider = e;
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

    public void setModifierProfil(JButton modifierProfil)
    {
        this.modifierProfil = modifierProfil;
    }

}
