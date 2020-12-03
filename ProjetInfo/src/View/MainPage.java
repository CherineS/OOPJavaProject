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
import javax.swing.*;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

/**
 *
 * @author Utilisateur
 */
public class MainPage extends javax.swing.JPanel
{

    /**
     * Creates new form MainPage1
     */

    public MainPage()
    {
        initComponents();
        manualInitComponents();
        logoMainPage();
        searchBarMainPage();
        cartMainPage();
        profileMainPage();
    }

    public void manualInitComponents()
    {
        manageProductsPage = new ManageProductsPage();
        
        //Suppression des bords des boutons
        shopButton.setBorderPainted(false);
        trendButton.setBorderPainted(false);
        salesButton.setBorderPainted(false);
        pastOrdersButton.setBorderPainted(false);
        parametersButton.setBorderPainted(false);
        jButtonManageProduct.setBorderPainted(false);

        setLayout(new FlowLayout());
        jPanel2 = new JPanel();
        jPanel2.setBackground(Color.white);
        jPanel2.setPreferredSize(new Dimension(1600, 700));
        scroll = new JScrollPane(jPanel2);

        scroll.setPreferredSize(new Dimension(1600, 700));
        scroll.setBorder(createEmptyBorder());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        searchBar = new JTextField(100); // Barre de recherche
        searchBar.setBackground(new Color(242, 242, 242));
        Font font = new Font("Courier", Font.BOLD, 18);
        searchBar.setFont(font);

        buttonText = new JButton();
        buttonText.setBounds(590, 21, 300, 40);
        buttonText.setOpaque(false);
        buttonText.setContentAreaFilled(false);
        buttonText.setBorderPainted(false);
        searchBar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        buttonText.add(searchBar); // Bouton ajoute barre de recherche
        jPanel1.add(buttonText);

        jButtonSearch = new JButton();
        jButtonSearch.setBounds(910, 17, 60, 50);
        jButtonSearch.setOpaque(false);
        jButtonSearch.setContentAreaFilled(false);
        jButtonSearch.setBorderPainted(false);
        jPanel1.add(jButtonSearch);
        
        jButtonCart = new JButton();   // Bouton panier
        jButtonCart.setBounds(1270, 12, 70, 70);
        jButtonCart.setOpaque(false);
        jButtonCart.setContentAreaFilled(false);
        jButtonCart.setBorderPainted(false);
        jPanel1.add(jButtonCart);
        
        jButtonProfile = new JButton(); // Bouton profil
        jButtonProfile.setBounds(1442, 9, 75, 75);
        jButtonProfile.setOpaque(false);
        jButtonProfile.setContentAreaFilled(false);
        jButtonProfile.setBorderPainted(false);
        jPanel1.add(jButtonProfile);

        buttonImage = new JButton(); // Bouton imega barre de recherche du milieu
        buttonImage.setBounds(555, 6, 450, 70);
        buttonImage.setOpaque(false);
        buttonImage.setContentAreaFilled(false);
        buttonImage.setBorderPainted(false);
    }
    
    public void displayText(String message) //Display a message
    {
        JLabel noResults = new JLabel(message);
        noResults.setPreferredSize(new Dimension(300, 280));
        noResults.setFont(new Font("Arial",Font.PLAIN,20));
        noResults.setHorizontalAlignment(JLabel.CENTER);
        noResults.setVerticalAlignment(JLabel.CENTER);
        jPanel2.add(noResults);
    }

    public void logoMainPage()
    {
        jPanelLogo.setLayout(new FlowLayout());
        jPanelLogo.setPreferredSize(new Dimension(82, 82));

        String imageURL = "https://i.goopics.net/eWdq9.jpg";

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(82, 82, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur logoMainPage");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        jPanelLogo.setBackground(Color.white);
        jPanelLogo.add(label);
        jPanel1.add(jPanelLogo);
        revalidate();
        repaint();
    }

    public void searchBarMainPage()
    {
        String imageURL = "https://i.goopics.net/4rypZ.jpg";
        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(405, 63, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur searchBarMainPage");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        buttonImage.add(label);
        jPanel1.add(buttonImage);
        revalidate();
        repaint();
    }

    public void cartMainPage()
    {
        jPanelCart.setLayout(new FlowLayout());
        jPanelCart.setPreferredSize(new Dimension(80, 80));

        String imageURL = "https://i.goopics.net/bWen0.jpg";
        // https://i.goopics.net/bWen0.jpg avec écriture panier
        // https://i.goopics.net/oGZlJ.jpg avec écriture mon panier

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur cartMainPage");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        jPanelCart.setBackground(Color.white);
        jPanelCart.add(label);
        jPanel1.add(jPanelCart);
        revalidate();
        repaint();
    }

    public void profileMainPage()
    {
        jPanelPeople.setLayout(new FlowLayout());
        jPanelPeople.setPreferredSize(new Dimension(80, 80));

        String imageURL = "https://i.goopics.net/w2ARR.jpg"; 
        // https://i.goopics.net/w2ARR.jpg  avec écriture profil
        // https://i.goopics.net/0pOxw.jpg avec écriture mon profil

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur profileMainPage");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        jPanelPeople.setBackground(Color.white);
        jPanelPeople.add(label);
        jPanel1.add(jPanelPeople);
        revalidate();
        repaint();
    }

    public void addPanelInFrame()
    {
        add(scroll);
    }

    public void hideScroll()
    {
        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
    }

    public void showScroll()
    {
        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
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
    
    public void addInPanel2(ManageProductsPage newManageProductsPage)
    {   
        jPanel2.add(newManageProductsPage);
    }
    
    public void addInPanel2(ManagerProduitEnListe newProduct)
    {   
        jPanel2.add(newProduct);
    }
    
    public JTextField getSearchBar()
    {
        return searchBar;
    }
    
    //Buttons
    public JButton getButtonSearch()
    {
        return jButtonSearch;
    }

    public JButton getButtonManageProduct()
    {
        return jButtonManageProduct;
    }

    public JButton getButtonShop()
    {
        return shopButton;
    }
    
    public JButton getButtonCart()
    {
        return jButtonCart;
    }
    
    public JButton getButtonProfile()
    {
        return jButtonProfile;
    }

    //Concerne le manageProductsPage
    public ManageProductsPage getManagerPage()
    {
        return manageProductsPage;
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        shopButton = new javax.swing.JButton();
        trendButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        pastOrdersButton = new javax.swing.JButton();
        parametersButton = new javax.swing.JButton();
        jButtonManageProduct = new javax.swing.JButton();
        jPanelLogo = new javax.swing.JPanel();
        jPanelCart = new javax.swing.JPanel();
        jPanelPeople = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 120));

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        shopButton.setBackground(new java.awt.Color(255, 102, 51));
        shopButton.setForeground(new java.awt.Color(255, 255, 255));
        shopButton.setText("Shop");

        trendButton.setBackground(new java.awt.Color(255, 102, 51));
        trendButton.setForeground(new java.awt.Color(255, 255, 255));
        trendButton.setText("On trend");
        trendButton.setPreferredSize(new java.awt.Dimension(140, 41));

        salesButton.setBackground(new java.awt.Color(255, 102, 51));
        salesButton.setForeground(new java.awt.Color(255, 255, 255));
        salesButton.setText("Sales");
        salesButton.setPreferredSize(new java.awt.Dimension(140, 41));

        pastOrdersButton.setBackground(new java.awt.Color(255, 102, 51));
        pastOrdersButton.setForeground(new java.awt.Color(255, 255, 255));
        pastOrdersButton.setText("Past orders");
        pastOrdersButton.setToolTipText("");
        pastOrdersButton.setPreferredSize(new java.awt.Dimension(140, 41));

        parametersButton.setBackground(new java.awt.Color(255, 102, 51));
        parametersButton.setForeground(new java.awt.Color(255, 255, 255));
        parametersButton.setText("Account parameters");
        parametersButton.setPreferredSize(new java.awt.Dimension(140, 41));

        jButtonManageProduct.setBackground(new java.awt.Color(255, 102, 51));
        jButtonManageProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButtonManageProduct.setText("Manage products");
        jButtonManageProduct.setPreferredSize(new java.awt.Dimension(170, 25));
        jButtonManageProduct.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonManageProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pastOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parametersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 672, Short.MAX_VALUE)
                .addComponent(jButtonManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(shopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(parametersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(trendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pastOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogo.setPreferredSize(new java.awt.Dimension(82, 82));

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelCartLayout = new javax.swing.GroupLayout(jPanelCart);
        jPanelCart.setLayout(jPanelCartLayout);
        jPanelCartLayout.setHorizontalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelCartLayout.setVerticalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPeopleLayout = new javax.swing.GroupLayout(jPanelPeople);
        jPanelPeople.setLayout(jPanelPeopleLayout);
        jPanelPeopleLayout.setHorizontalGroup(
            jPanelPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelPeopleLayout.setVerticalGroup(
            jPanelPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jPanelPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 692, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonManageProductActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonManageProductActionPerformed
    {//GEN-HEADEREND:event_jButtonManageProductActionPerformed

    }//GEN-LAST:event_jButtonManageProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonManageProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCart;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelPeople;
    private javax.swing.JButton parametersButton;
    private javax.swing.JButton pastOrdersButton;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton shopButton;
    private javax.swing.JButton trendButton;
    // End of variables declaration//GEN-END:variables
    private JTextField searchBar;
    private JPanel jPanel2;
    private JScrollPane scroll;
    private JButton buttonText;
    private JButton buttonImage;
    private JButton jButtonSearch;
    private JButton jButtonCart;
    private JButton jButtonProfile;
    private ManageProductsPage manageProductsPage;
}
