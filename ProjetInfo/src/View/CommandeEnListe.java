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
import projetinfo.OrdersDAO;
import projetinfo.Orders;

/**
 *
 * @author Gaëtan
 */
public class CommandeEnListe extends javax.swing.JFrame
{
    public CommandeEnListe()
    {
        initComponents();
    }
    
    public CommandeEnListe(Orders myOrders)
    {
        initComponents();
        jPanelOrders.setLayout(new FlowLayout());
        jPanelOrders.setPreferredSize(new Dimension(146,146));
        
        nameProduct.setText(myOrders.getProducts().getName());
        PriceProduct.setText(Double.toString(myOrders.getPrice())+"€");
        
        imageURL = myOrders.getProducts().getURL();
        
        Image image = null;
        
        try {
            URL url = new URL("Null");
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
        
        jPanelOrders.add(label);
        add(jPanelOrders);
        revalidate();
        repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jPanelOrders = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nameProduct = new javax.swing.JTextField();
        PriceProduct = new javax.swing.JTextField();
        DescriptionProduct = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelOrders.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        nameProduct.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nameProduct.setText("Name");
        nameProduct.setPreferredSize(new java.awt.Dimension(50, 25));
        nameProduct.setSelectionColor(new java.awt.Color(0, 0, 0));
        nameProduct.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nameProductActionPerformed(evt);
            }
        });

        PriceProduct.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        PriceProduct.setText("Price");
        PriceProduct.setPreferredSize(new java.awt.Dimension(50, 25));

        DescriptionProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DescriptionProduct.setText("Description Product");
        DescriptionProduct.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DescriptionProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrdersLayout = new javax.swing.GroupLayout(jPanelOrders);
        jPanelOrders.setLayout(jPanelOrdersLayout);
        jPanelOrdersLayout.setHorizontalGroup(
            jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrdersLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PriceProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(DescriptionProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanelOrdersLayout.setVerticalGroup(
            jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrdersLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelOrdersLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelOrdersLayout.createSequentialGroup()
                                .addComponent(nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(PriceProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DescriptionProduct))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameProductActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nameProductActionPerformed
    {//GEN-HEADEREND:event_nameProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameProductActionPerformed

    private void DescriptionProductActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DescriptionProductActionPerformed
    {//GEN-HEADEREND:event_DescriptionProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DescriptionProduct;
    private javax.swing.JTextField PriceProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelOrders;
    private javax.swing.JTextField nameProduct;
    // End of variables declaration//GEN-END:variables
    private String imageURL;
}
