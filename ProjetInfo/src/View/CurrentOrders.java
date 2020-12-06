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
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import Model.Orders;
import Model.ProductDAO;

/**
 *
 * @author Gaëtan
 */
public class CurrentOrders extends javax.swing.JPanel
{

    /**
     * Creates new form CurrentOrders
     */
    public CurrentOrders()
    {
        initComponents();
    }

    public CurrentOrders(Orders myOrders)
    {
        initComponents();
        imageDisplay.setLayout(new FlowLayout());
        imageDisplay.setPreferredSize(new Dimension(146, 146));

        name.setText(myOrders.getProducts().getName());
        

        double thePrice = myOrders.getPrice();

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String stringPrice = df.format(thePrice);
        char[] myPrice = stringPrice.toCharArray();
        for (int j = 0; j < myPrice.length; j++)
            if (myPrice[j] == ',')
                myPrice[j] = '.';

        thePrice = Double.parseDouble(String.copyValueOf(myPrice));
        price.setText(Double.toString(thePrice) + "€");
        description.setText(myOrders.getProducts().getDescription());
        jLabel1.setText(jLabel1.getText()+Integer.toString(myOrders.getProducts().getQuantity()));

        Image image = null;

        try
        {
            URL url = new URL(myOrders.getProducts().getURL());
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(138, 138, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur image");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        imageDisplay.add(label);
        add(imageDisplay);
        revalidate();
        repaint();
    }

    public JButton getSupprimer()
    {
        return supprimer;
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
        supprimer = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        name.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        name.setText("Name");
        name.setToolTipText("");

        price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                supprimerActionPerformed(evt);
            }
        });

        description.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        description.setText("Description");
        description.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        description.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quantité : ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(price)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(supprimer)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(price))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(supprimer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_supprimerActionPerformed
    {//GEN-HEADEREND:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private javax.swing.JPanel imageDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
