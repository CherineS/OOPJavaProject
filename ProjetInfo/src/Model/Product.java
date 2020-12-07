/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Product
{
    // Attributes of a product
    private int m_productNo;
    private String m_name;
    private double m_price;
    private int m_quantity;
    private int m_minimumPromotion;
    private double m_valuePromotion;
    private String m_imageUrl;
    private String m_description;

    // Constructor
    public Product()
    {
        m_productNo = -1;
        m_name = "N/A";
        m_price = 0;
        m_quantity = 0;
        m_minimumPromotion = 0;
        m_valuePromotion = 0;
        m_imageUrl = null;
        m_description = null;
    }
    
    // Constructor
    public Product(int productNo, String name, double price, int quantity, int minimumPromotion, double valuePromotion, String imageUrl, String description)
    {
        m_productNo = productNo;
        m_name = name;
        m_price = price;
        m_quantity = quantity;
        m_minimumPromotion=minimumPromotion;
        m_valuePromotion = valuePromotion;
        m_imageUrl = imageUrl;
        m_description = description;
    }
    
    // Constructor
    public Product(int productNo, String name, double price, int quantity, int minimumPromotion, double valuePromotion, String description)
    {
        m_productNo = productNo;
        m_name = name;
        m_price = price;
        m_quantity = quantity;
        m_minimumPromotion=minimumPromotion;
        m_valuePromotion = valuePromotion;
        m_description = description;
    }
    
    //getters
    public int getProductNo()
    {
        return m_productNo;
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public double getPrice()
    {
        return m_price;
    }
    
    public int getQuantity()
    {
        return m_quantity;
    }
    
    public int getminimumPromotion()
    {
        return m_minimumPromotion;
    }
    
    public double getValuePromotion()
    {
        return m_valuePromotion;
    }
    
    public String getURL()
    {
        return m_imageUrl;
    }
    
    public String getDescription()
    {
        return m_description;
    }
    
    //setters
    public void setProductNo(int productNo)
    {
        m_productNo=productNo;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setPrice(double price)
    {
        m_price = price;
    }
    
    public void setQuantity(int quantity)
    {
        m_quantity = quantity;
    }
    
    public void setminimumPromotion(int minimumPromotion)
    {
        m_minimumPromotion=minimumPromotion;
    }

    public void setValuePromotion(double valuePromotion)
    {
        m_valuePromotion = valuePromotion;
    }
    
    public void setDescription(String description)
    {
        m_description = description;
    }
}
