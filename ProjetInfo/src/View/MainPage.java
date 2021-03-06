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

public class MainPage extends javax.swing.JPanel
{

    /**
     * Main page of the shop 
     */

    // init components and add differents images and panel on it
    public MainPage()
    {
        initComponents();
        manualInitComponents();
        logoMainPage();
        searchBarMainPage();
        cartMainPage();
        profileMainPage();
        decoBarMainPage();
    }

    public void manualInitComponents()
    {
        manageProductsPage = new ManageProductsPage();
        
        //Removing button edges
        shopButton.setBorderPainted(false);
        trendButton.setBorderPainted(false);
        salesButton.setBorderPainted(false);
        pastOrdersButton.setBorderPainted(false);
        jButtonManageProduct.setBorderPainted(false);

        //Creates "the bottom part of the frame"
        setLayout(new FlowLayout());
        jPanel2 = new JPanel();
        jPanel2.setBackground(Color.white);
        jPanel2.setPreferredSize(new Dimension(1600, 660));
        scroll = new JScrollPane(jPanel2);
        scroll.setPreferredSize(new Dimension(1600, 660));
        scroll.setBorder(createEmptyBorder());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        searchBar = new JTextField(100); // search bar
        searchBar.setBackground(new Color(242, 242, 242));
        Font font = new Font("Courier", Font.BOLD, 18);
        searchBar.setFont(font);
        searchBar.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        buttonText = new JButton();
        buttonText.setBounds(590, 21, 300, 40);
        buttonText.setOpaque(false);
        buttonText.setContentAreaFilled(false);
        buttonText.setBorderPainted(false);
        buttonText.add(searchBar); //  Button adds search bar
        jPanel1.add(buttonText);

        jButtonSearch = new JButton();  //Search button
        jButtonSearch.setBounds(910, 17, 60, 50);
        jButtonSearch.setOpaque(false);
        jButtonSearch.setContentAreaFilled(false);
        jButtonSearch.setBorderPainted(false);
        jPanel1.add(jButtonSearch);
        
        jButtonCart = new JButton();   // Button cart
        jButtonCart.setBounds(1330, 11, 65, 65);
        jButtonCart.setOpaque(false);
        jButtonCart.setContentAreaFilled(false);
        jButtonCart.setBorderPainted(false);
        jPanel1.add(jButtonCart);
        
        jButtonProfile = new JButton(); // Button profile
        jButtonProfile.setBounds(1420, 11, 65, 65);
        jButtonProfile.setOpaque(false);
        jButtonProfile.setContentAreaFilled(false);
        jButtonProfile.setBorderPainted(false);
        jPanel1.add(jButtonProfile);
        
        jButtonDisconnect = new JButton(); // Bouton disconnect
        jButtonDisconnect.setBounds(1500, 11, 65, 65);
        jButtonDisconnect.setOpaque(false);
        jButtonDisconnect.setContentAreaFilled(false);
        jButtonDisconnect.setBorderPainted(false);
        jPanel1.add(jButtonDisconnect);

        buttonImage = new JButton(); // Middle search bar image button
        buttonImage.setBounds(555, 6, 450, 70);
        buttonImage.setOpaque(false);
        buttonImage.setContentAreaFilled(false);
        buttonImage.setBorderPainted(false);

    }
    
    //The button is visible only for employees
    public void manageButton(boolean visible)
    {
        if(visible==false)
            jButtonManageProduct.setVisible(false);
        else 
            jButtonManageProduct.setVisible(true);
    }
    
    //Display a message
    public void displayText(String message)
    {
        JLabel noResults = new JLabel(message);
        noResults.setPreferredSize(new Dimension(300, 280));
        noResults.setFont(new Font("Arial",Font.PLAIN,20));
        noResults.setHorizontalAlignment(JLabel.CENTER);
        noResults.setVerticalAlignment(JLabel.CENTER);
        jPanel2.add(noResults);
    }

    public void logoMainPage() // Image logo
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
    
    public void decoBarMainPage() // Image disconnect
    {
        jPanelDeconnection.setLayout(new FlowLayout());
        jPanelDeconnection.setPreferredSize(new Dimension(65, 65));

        String imageURL = "https://i.goopics.net/XWqrX.jpg";

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        } catch (IOException error)
        {
            System.out.println("Erreur cartMainPage");
        }

        JLabel label;
        if (image != null)
            label = new JLabel(new ImageIcon(image));
        else
            label = new JLabel();

        jPanelDeconnection.setBackground(Color.white);
        jPanelDeconnection.add(label);
        jPanel1.add(jPanelDeconnection);
        revalidate();
        repaint();
    }

    public void searchBarMainPage() // Image search
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

    public void cartMainPage() // Image cart
    {
        jPanelCart.setLayout(new FlowLayout());
        jPanelCart.setPreferredSize(new Dimension(65, 65));
        String imageURL = "https://i.goopics.net/bWen0.jpg";

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
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

    public void profileMainPage()  // Image profile
    {
        jPanelPeople.setLayout(new FlowLayout());
        jPanelPeople.setPreferredSize(new Dimension(65, 65));

        String imageURL = "https://i.goopics.net/w2ARR.jpg"; 

        Image image = null;

        try
        {
            URL url = new URL(imageURL);
            Image imageBeforeResize = ImageIO.read(url);
            image = imageBeforeResize.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
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

    // Actions on panel / frame / scroll bar
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
    
    public void resetScroll()
    {
        scroll.getViewport().setViewPosition(new Point(0,0));
    }

    public void emptyPanel2()
    {
        jPanel2.removeAll();
    }

    public void addInPanel2(OneProduct newProduct)
    {
        jPanel2.add(newProduct);
    }
    
    public void addInPanel2(ProfilePage pp)
    {
        jPanel2.add(pp);
    }

    public void addInPanel2(AddProductPage newProductPage)
    {
        jPanel2.add(newProductPage);
    }
    
    public void addInPanel2(ManageProductsPage newManageProductsPage)
    {   
        jPanel2.add(newManageProductsPage);
    }
    
    public void addInPanel2(ManagerProduct newProduct)
    {   
        jPanel2.add(newProduct);
    }
    
    public void addInPanel2(AllPastOrders newOrder)
    {
        jPanel2.add(newOrder);
    }
    
    public void addInPanel2(OnePastOrder newOrders)
    {
        jPanel2.add(newOrders);
    }
    
    public void addInPanel2(CurrentOrders newOrders)
    {
        jPanel2.add(newOrders);
    }
    
    public void addInPanel2(OrdersPaymentAndPrice OPAP)
    {
       jPanel2.add(OPAP); 
    }
    
    public void addInPanel2(PaymentPage pp)
    {
        jPanel2.add(pp);
    }
    
    public void addInPanel2(UpdateProductPage newUpdateProductPage)
    {
        jPanel2.add(newUpdateProductPage);
    }
    
    //getters
    public JPanel getPanel2()
    {
        return jPanel2;
    }

    public JTextField getSearchBar()
    {
        return searchBar;
    }
    
    //Buttons getter
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
    
    public JButton getButtonDisoconnect()
    {
        return jButtonDisconnect;
    }
    
    public JButton getTrendButton()
    {
        return trendButton;
    }
    
    public JButton getButtonSales()
    {
        return salesButton;
    }
    
    public JButton getPastOrderButton()
    {
        return pastOrdersButton;
    }

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
        jButtonManageProduct = new javax.swing.JButton();
        jPanelLogo = new javax.swing.JPanel();
        jPanelCart = new javax.swing.JPanel();
        jPanelPeople = new javax.swing.JPanel();
        jPanelDeconnection = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 125));

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(1600, 32));

        shopButton.setBackground(new java.awt.Color(255, 102, 51));
        shopButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        shopButton.setForeground(new java.awt.Color(255, 255, 255));
        shopButton.setText("La boutique");

        trendButton.setBackground(new java.awt.Color(255, 102, 51));
        trendButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        trendButton.setForeground(new java.awt.Color(255, 255, 255));
        trendButton.setText("Tendances");
        trendButton.setPreferredSize(new java.awt.Dimension(140, 41));

        salesButton.setBackground(new java.awt.Color(255, 102, 51));
        salesButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salesButton.setForeground(new java.awt.Color(255, 255, 255));
        salesButton.setText("Promotions");
        salesButton.setPreferredSize(new java.awt.Dimension(140, 41));

        pastOrdersButton.setBackground(new java.awt.Color(255, 102, 51));
        pastOrdersButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pastOrdersButton.setForeground(new java.awt.Color(255, 255, 255));
        pastOrdersButton.setText("Historique des commandes");
        pastOrdersButton.setToolTipText("");
        pastOrdersButton.setPreferredSize(new java.awt.Dimension(140, 41));

        jButtonManageProduct.setBackground(new java.awt.Color(255, 102, 51));
        jButtonManageProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonManageProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButtonManageProduct.setText("Gérer les produits");
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
                .addComponent(pastOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 724, Short.MAX_VALUE)
                .addComponent(jButtonManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shopButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(trendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pastOrdersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButtonManageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanelCart.setPreferredSize(new java.awt.Dimension(65, 65));

        javax.swing.GroupLayout jPanelCartLayout = new javax.swing.GroupLayout(jPanelCart);
        jPanelCart.setLayout(jPanelCartLayout);
        jPanelCartLayout.setHorizontalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanelCartLayout.setVerticalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanelPeople.setPreferredSize(new java.awt.Dimension(65, 65));

        javax.swing.GroupLayout jPanelPeopleLayout = new javax.swing.GroupLayout(jPanelPeople);
        jPanelPeople.setLayout(jPanelPeopleLayout);
        jPanelPeopleLayout.setHorizontalGroup(
            jPanelPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanelPeopleLayout.setVerticalGroup(
            jPanelPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanelDeconnection.setPreferredSize(new java.awt.Dimension(65, 65));

        javax.swing.GroupLayout jPanelDeconnectionLayout = new javax.swing.GroupLayout(jPanelDeconnection);
        jPanelDeconnection.setLayout(jPanelDeconnectionLayout);
        jPanelDeconnectionLayout.setHorizontalGroup(
            jPanelDeconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanelDeconnectionLayout.setVerticalGroup(
            jPanelDeconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1219, 1219, 1219)
                .addComponent(jPanelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanelPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanelDeconnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDeconnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");

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
                .addGap(0, 660, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanelDeconnection;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelPeople;
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
    private JButton jButtonDisconnect;
    private ManageProductsPage manageProductsPage;   
}
