/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import projetinfo.ProductDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.ScrollPaneConstants.*;

/**
 *
 * @author Utilisateur
 */
public class Frame extends javax.swing.JFrame
{

    MainPage myMainPage;
    FirstPage connexionPage;
    NewInscription myInscription;
    ProfilPage profilpage;
    FirstPage myfirstpage;
    /**
     * Creates new form testmain
     */
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
        myMainPage.setPreferredSize(new Dimension(1600,800));
        myInscription = new NewInscription();
        myInscription.setPreferredSize(new Dimension(1600,800));
        switchToNewInscription();
    }

    public void switchToConnexionPage()
    {
        getContentPane().removeAll();
        add(connexionPage);
    }

    public void switchToMainPage()
    {
        getContentPane().removeAll();
        add(myMainPage);
    }
    public void switchToNewInscription()
    {
        getContentPane().removeAll();
        add(myInscription);
    }
    public void switchToProfilPage()
    {
        getContentPane().removeAll();
        add(profilpage);
    }
    public void switchToFirstPage()
    {
        getContentPane().removeAll();
        add(myfirstpage);
    }
    
    public void setVisibleMainpage()
    {
        myMainPage.setVisible(true);
    }

    public MainPage getMainPage()
    {
        return myMainPage;
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
