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
import projetinfo.Orders;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Formatter;

/**
 *
 * @author Gaëtan
 */
public class CommandeEnListe extends javax.swing.JPanel
{
    public CommandeEnListe(Orders myOrders)
    {
        initComponents();
        jPanel2.setLayout(new FlowLayout());
        jPanel2.setPreferredSize(new Dimension(152,152));
        
        nameProduct.setText("Nom : " + myOrders.getProducts().getName());
        priceProduct.setText("Prix : " + Double.toString(myOrders.getPrice())+"€");
        descriptionProduct.setText(myOrders.getProducts().getDescription());
        quantity.setText("Quantité : " + Integer.toString(myOrders.getProducts().getQuantity()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        date.setText("Date : " + formatter.format(myOrders.getDate()));
        
        
        Image image = null;
        
        try {
            URL url = new URL(myOrders.getProducts().getURL());
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(142, 142, Image.SCALE_SMOOTH);
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
        
        jPanel2.add(label);
        add(jPanel2);
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

        jPanel2 = new javax.swing.JPanel();
        nameProduct = new javax.swing.JLabel();
        priceProduct = new javax.swing.JLabel();
        descriptionProduct = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(152, 152));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        nameProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameProduct.setText("Name");

        priceProduct.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        priceProduct.setText("Price");

        descriptionProduct.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        descriptionProduct.setText("jLabel1");
        descriptionProduct.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        quantity.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        quantity.setText("Quantity");

        date.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        date.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(descriptionProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(nameProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel descriptionProduct;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameProduct;
    private javax.swing.JLabel priceProduct;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
}
