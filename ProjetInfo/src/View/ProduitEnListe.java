/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import projetinfo.*;
import projetinfo.Product;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
Sources :
Read image from URL : https://www.codeflow.site/fr/article/java__how-to-read-an-image-from-file-or-url
Resize image : https://www.baeldung.com/java-resize-image
*/

/**
 *
 * @author Utilisateur
 */
public class ProduitEnListe extends javax.swing.JPanel
{
    /**
     * Creates new form FicheProduitClient
     */
    public ProduitEnListe()
    {
        initComponents();
        name.setText("N/A");
        price.setText("N/A");
    }
    
    public ProduitEnListe(int productNo)
    {
        initComponents();
        imageDisplay.setLayout(new FlowLayout());
        imageDisplay.setPreferredSize(new Dimension(146,146));
        
        ProductDAO javaProductDAO = new ProductDAO();
        Product searchedProduct = javaProductDAO.createJavaProduct(productNo);
        
        name.setText(searchedProduct.getName());
        price.setText(Double.toString(searchedProduct.getPrice())+ "€");
        description.setText(searchedProduct.getDescription());
        quantityLeft.setText(quantityLeft.getText()+Integer.toString(searchedProduct.getQuantity())+")");
        
        if(searchedProduct.getValuePromotion()>0)
        {
            promotionRed.setText("Promotion !");
            promotionText.setText("Promotion :  -"+ Double.toString(searchedProduct.getValuePromotion())
                    + "% tous les " + Integer.toString(searchedProduct.getminimumPromotion())+ " produits achetés !");
        }
        else{
            promotionRed.setText("");
            promotionText.setText("");
        }
        
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
    
    public JButton getAddToCartButton()
    {
        return jButtonAddToCart;
    }
    
    public JTextField getQuantityToBuy()
    {
        return quantityToBuy;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        description1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JPanel();
        jButtonAddToCart = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        quantityToBuy = new javax.swing.JTextField();
        quantityLeft = new javax.swing.JLabel();
        promotionRed = new javax.swing.JLabel();
        promotionText = new javax.swing.JLabel();

        description1.setText("Description");
        description1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        name.setText("Name");
        name.setToolTipText("");

        price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        jButtonAddToCart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddToCart.setText("Ajouter au panier");
        jButtonAddToCart.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAddToCartActionPerformed(evt);
            }
        });

        description.setText("Description");
        description.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Quantité :");

        quantityToBuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantityToBuy.setText("1");

        quantityLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLeft.setText("(Quantité restante : ");
        quantityLeft.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        promotionRed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        promotionRed.setForeground(new java.awt.Color(255, 0, 0));
        promotionRed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        promotionRed.setText("Promotion !");

        promotionText.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        promotionText.setText("Promotion : ");
        promotionText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promotionRed, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(promotionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAddToCart)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityToBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(quantityLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name)
                                    .addComponent(promotionRed))
                                .addGap(23, 23, 23)
                                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(price)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(quantityToBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantityLeft)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddToCart)
                            .addComponent(promotionText))
                        .addGap(8, 8, 8)))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddToCartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddToCartActionPerformed
    {//GEN-HEADEREND:event_jButtonAddToCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddToCartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private javax.swing.JLabel description1;
    private javax.swing.JPanel imageDisplay;
    private javax.swing.JButton jButtonAddToCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    private javax.swing.JLabel promotionRed;
    private javax.swing.JLabel promotionText;
    private javax.swing.JLabel quantityLeft;
    private javax.swing.JTextField quantityToBuy;
    // End of variables declaration//GEN-END:variables
}
