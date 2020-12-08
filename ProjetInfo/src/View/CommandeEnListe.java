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
import Model.Orders;
import java.text.SimpleDateFormat;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JTextArea;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

/**
 * Jframe form for only one order (pastOrders)
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
        jScrollPane1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER); 
        jScrollPane1.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER); 
        jScrollPane1.setBorder(createEmptyBorder());
        descriptionProduct.setText(myOrders.getProducts().getDescription());
        descriptionProduct.setBorder(createEmptyBorder());
        descriptionProduct.setLineWrap(true);
        descriptionProduct.setWrapStyleWord(true);
        
        quantity.setText("Quantité : " + Integer.toString(myOrders.getProducts().getQuantity()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        date.setText("Date : " + formatter.format(myOrders.getDate()));
        
        // Setup the image
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
        quantity = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionProduct = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(800, 200));

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

        nameProduct.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nameProduct.setText("Name");

        priceProduct.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        priceProduct.setText("Price");

        quantity.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        quantity.setText("Quantity");

        date.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        date.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(238, 238, 238));

        descriptionProduct.setEditable(false);
        descriptionProduct.setBackground(new java.awt.Color(238, 238, 238));
        descriptionProduct.setColumns(20);
        descriptionProduct.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        descriptionProduct.setRows(5);
        descriptionProduct.setBorder(null);
        descriptionProduct.setCaretColor(new java.awt.Color(238, 238, 238));
        descriptionProduct.setDisabledTextColor(new java.awt.Color(238, 238, 238));
        descriptionProduct.setSelectionColor(new java.awt.Color(238, 238, 238));
        jScrollPane1.setViewportView(descriptionProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(priceProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JTextArea descriptionProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameProduct;
    private javax.swing.JLabel priceProduct;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
    JTextArea test;
}
