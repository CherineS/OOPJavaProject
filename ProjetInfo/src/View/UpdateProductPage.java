/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import projetinfo.Product;
import projetinfo.ProductDAO;

/**
 *
 * @author Utilisateur
 */
public class UpdateProductPage extends javax.swing.JPanel
{
    int currentKey;
    
    /**
     * Creates new form ProductPage
     */
    public UpdateProductPage()
    {
        initComponents();
    }
    
    public UpdateProductPage(int primaryKey)
    {
        initComponents();
        imageDisplay.setLayout(new FlowLayout());
        imageDisplay.setPreferredSize(new Dimension(146,146));
        currentKey=primaryKey;
        
        ProductDAO javaProductDAO = new ProductDAO();
        Product searchedProduct = javaProductDAO.createJavaProduct(primaryKey);
        
        productNo.setText(Integer.toString(primaryKey));
        imageURL.setText(searchedProduct.getURL());
        name.setText(searchedProduct.getName());
        name.setText(searchedProduct.getName());
        quantity.setText(Integer.toString(searchedProduct.getQuantity()));
        price.setText(Double.toString(searchedProduct.getPrice()));
        description.setText(searchedProduct.getDescription());
        valuePromotion.setText(Double.toString(searchedProduct.getValuePromotion()));
        minPromotion.setText(Integer.toString(searchedProduct.getminimumPromotion()));
        
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
    
    public void delete()
    {
        quantity.setText("0");
    }
    
    public int getProductNo()
    {
        return currentKey;
    }
    
    public JButton getValidateButton()
    {
        return updateButton;
    }
    
    public JButton getDeleteButton()
    {
        return deleteButton;
    }

    public JTextField getTheName()
    {
        return name;
    }

    public JTextField getImageURL()
    {
        return imageURL;
    }

    public JTextField getPrice()
    {
        return price;
    }

    public JTextField getQuantity()
    {
        return quantity;
    }

    public JTextField getValuePromotion()
    {
        return valuePromotion;
    }

    public JTextField getMinPromotion()
    {
        return minPromotion;
    }
    
    public JTextField getDescription()
    {
        return description;
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabelName = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        productNo = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        imageURL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        minPromotion = new javax.swing.JTextField();
        valuePromotion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabelName1 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1031, 538));
        setRequestFocusEnabled(false);

        jLabelName.setText("Nom :");
        jLabelName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name1.setText("Produit n°");
        name1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        productNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        productNo.setText("productNo");
        productNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        price.setText("Price");

        jLabel4.setText("Quantité :");

        jLabel7.setText("achats");

        imageURL.setText("URL");
        imageURL.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                imageURLActionPerformed(evt);
            }
        });

        jLabel3.setText("Price :");

        minPromotion.setText("Minimum");

        valuePromotion.setText("%");
        valuePromotion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                valuePromotionActionPerformed(evt);
            }
        });

        jLabel8.setText("URL de l'image :");

        jLabel5.setText("Promotion :");

        jLabel6.setText("pour");

        quantity.setText("Quantity");

        name.setText("Name");
        name.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nameActionPerformed(evt);
            }
        });

        updateButton.setText("Mettre à jour");

        deleteButton.setText("Supprimer ce produit");

        jLabelName1.setText("Description :");
        jLabelName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        description.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        description.setText("Input description...");
        description.setAutoscrolls(false);
        description.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                descriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(name1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(imageURL, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabelName)
                                    .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(171, 171, 171)
                                        .addComponent(jLabelName1))
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(valuePromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(minPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(472, 472, 472))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name1)
                    .addComponent(productNo)
                    .addComponent(deleteButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelName)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelName1))
                            .addComponent(description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(valuePromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(minPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(imageURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(47, 47, 47))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nameActionPerformed
    {//GEN-HEADEREND:event_nameActionPerformed

    }//GEN-LAST:event_nameActionPerformed

    private void imageURLActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_imageURLActionPerformed
    {//GEN-HEADEREND:event_imageURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageURLActionPerformed

    private void valuePromotionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_valuePromotionActionPerformed
    {//GEN-HEADEREND:event_valuePromotionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valuePromotionActionPerformed

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_descriptionActionPerformed
    {//GEN-HEADEREND:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField description;
    private javax.swing.JPanel imageDisplay;
    private javax.swing.JTextField imageURL;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JTextField minPromotion;
    private javax.swing.JTextField name;
    private javax.swing.JLabel name1;
    private javax.swing.JTextField price;
    private javax.swing.JLabel productNo;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField valuePromotion;
    // End of variables declaration//GEN-END:variables
}
