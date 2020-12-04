/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import projetinfo.Product;
import projetinfo.ProductDAO;

/**
 *
 * @author Utilisateur
 */
public class ManagerProduitEnListe extends javax.swing.JPanel
{

    /**
     * Creates new form ManagerProduitEnListe
     */
    public ManagerProduitEnListe()
    {
        initComponents();
        name.setText("N/A");
        quantity.setText("N/A");
        price.setText("N/A");
    }
    
    public ManagerProduitEnListe(int productNo)
    {
        initComponents();
        imageDisplay.setLayout(new FlowLayout());
        imageDisplay.setPreferredSize(new Dimension(146,146));
        
        ProductDAO javaProductDAO = new ProductDAO();
        Product searchedProduct = javaProductDAO.createJavaProduct(productNo);
        
        name.setText(searchedProduct.getName());
        quantity.setText(Integer.toString(searchedProduct.getQuantity()));
        price.setText(Double.toString(searchedProduct.getPrice())+ "€");
        imageURL = searchedProduct.getURL();
        
        Image image = null;
        
        try {
            URL url = new URL(searchedProduct.getURL());
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(138, 138, Image.SCALE_SMOOTH);
        } catch (IOException error) {
            System.out.println("Erreur image");
        }
        
        JLabel label;
        if(image!=null)
        {
            label = new JLabel(new ImageIcon(image));
        }
        else 
            label= new JLabel();
        
        imageDisplay.add(label);
        add(imageDisplay);
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JPanel();
        quantity = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        name.setText("Name");
        name.setToolTipText("");

        price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        price.setText("Price");

        imageDisplay.setBackground(new java.awt.Color(255, 255, 255));
        imageDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imageDisplayLayout = new javax.swing.GroupLayout(imageDisplay);
        imageDisplay.setLayout(imageDisplayLayout);
        imageDisplayLayout.setHorizontalGroup(
            imageDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        imageDisplayLayout.setVerticalGroup(
            imageDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantity.setText("Quantity");

        jButton1.setText("Modify product information");

        jButton2.setText("Remove product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price)
                    .addComponent(quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(jButton1))
                        .addGap(9, 9, 9)
                        .addComponent(quantity)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price)
                            .addComponent(jButton2))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imageDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
    private String imageURL;
}