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

/**
 *
 * @author Utilisateur
 */
public class MainPage extends javax.swing.JFrame
{   
    /**
     * Creates new form testmain
     */
    public MainPage()
    {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(1500,1000));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonAddProduct = new javax.swing.JButton();
        jButtonDeleteProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Shop name");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        searchBar.setText("Search...");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonAddProduct.setText("Add a product");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAddProductActionPerformed(evt);
            }
        });

        jButtonDeleteProduct.setText("Delete a product");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddProduct)
                .addGap(27, 27, 27)
                .addComponent(jButtonDeleteProduct)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonAddProduct)
                    .addComponent(jButtonDeleteProduct))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 652, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddProductActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddProductActionPerformed
    {//GEN-HEADEREND:event_jButtonAddProductActionPerformed
        
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSearchActionPerformed
    {//GEN-HEADEREND:event_jButtonSearchActionPerformed

    }//GEN-LAST:event_jButtonSearchActionPerformed

    public void addPanelInFrame(JPanel newPanel)
    {
        add(newPanel);
    }
    
    public void emptyPanel2()
    {
        jPanel2.removeAll();
    }
    
    public JPanel getPanel2()
    {
        return jPanel2;
    }
    
    public void addInPanel2(ProduitEnListe newProduct)
    {
        jPanel2.add(newProduct);
    }
    
    public void addInPanel2(AddProductPage newProductPage)
    {
        jPanel2.add(newProductPage);
    }
    
    public JTextField getSearchBar()
    {
        return searchBar;
    }
    
    public void noResult() //Display "No Result" message
    {
        JLabel noResults = new JLabel("No Result");
        noResults.setPreferredSize(new Dimension(300, 280));
        noResults.setFont(new Font("Arial",Font.PLAIN,20));
        noResults.setHorizontalAlignment(JLabel.CENTER);
        noResults.setVerticalAlignment(JLabel.CENTER);
        jPanel2.add(noResults);
    }
    
    //Buttons
    public JButton getButtonSearch()
    {
        return jButtonSearch;
    }

    public JButton getButtonDeleteProduct()
    {
        return jButtonDeleteProduct;
    }
    
        public JButton getButtonAddProduct()
    {
        return jButtonAddProduct;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonDeleteProduct;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables
    private JPanel jPanel2;
}
