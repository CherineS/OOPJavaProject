/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

// Frame to display pages
public class Frame extends javax.swing.JFrame
{

    MainPage myMainPage;
    FirstPage connexionPage;
    ProfilPage profilpage;
    AddProductPage myAddPage;
    NewInscription myInscription;
    UpdateProductPage updateProductPage;

    public Frame()
    {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setBackground(Color.white);

        connexionPage = new FirstPage();
        connexionPage.setPreferredSize(new Dimension(1600, 800));
        myMainPage = new MainPage();
        myMainPage.setPreferredSize(new Dimension(1600, 800));
        myInscription = new NewInscription();
        updateProductPage = new UpdateProductPage();
        switchToConnexionPage();    //display the connexion page first

    }

    // Switch to differents pages
    public void switchToConnexionPage()
    {
        getContentPane().removeAll();
        add(connexionPage);
        revalidate();
        repaint();
    }

    public void switchToMainPage()
    {
        getContentPane().removeAll();
        add(myMainPage);
        revalidate();
        repaint();
    }

    public void switchToNewInscription()
    {
        getContentPane().removeAll();
        add(myInscription);
        revalidate();
        repaint();
    }

    public void switchToProfilPage()
    {
        getContentPane().removeAll();
        add(profilpage);
        revalidate();
        repaint();
    }

    // Setter
    public void setVisibleMainpage()
    {
        myMainPage.setVisible(true);
    }

    public void setProfilPage(ProfilPage newProfilPage)
    {
        profilpage = newProfilPage;
    }
    
    public void setAddPage(AddProductPage newPage)
    {
        myAddPage = new AddProductPage();
        myAddPage = newPage;
    }
    
    public void setUpdateButton(int productNo)
    {
        updateProductPage = new UpdateProductPage(productNo);
    }

    // getter
    public MainPage getMainPage()
    {
        return myMainPage;
    }

    public FirstPage getFirstPage()
    {
        return connexionPage;
    }

    public NewInscription getNewInscription()
    {
        return myInscription;
    }

    public ProfilPage getProfilPage()
    {
        return profilpage;
    }

    public AddProductPage getAddPage()
    {
        return myAddPage;
    }

    public UpdateProductPage getUpdateButton()
    {
        return updateProductPage;
    }
    
    public void discardAddPage()
    {
        myAddPage.setVisible(false);
        myAddPage.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
