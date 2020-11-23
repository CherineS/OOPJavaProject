/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

/**
 *
 * @author antoi
 */
public class Product
{
    private int m_productNo;
    private String m_name;
    private double m_price;
    private int m_quantity;
    private int m_minimumPromotion;
    private double m_valuePromotion;
    private String m_imageUrl;

    public Product()
    {
        m_productNo = -1;
        m_name = "N/A";
        m_price = 0;
        m_quantity = 0;
        m_minimumPromotion = 0;
        m_valuePromotion = 0;
        m_imageUrl = null;
    }
    
    public Product(int productNo, String name, double price, int quantity, int minimumPromotion, double valuePromotion, String imageUrl)
    {
        m_productNo = productNo;
        m_name = name;
        m_price = price;
        m_quantity = quantity;
        m_minimumPromotion=minimumPromotion;
        m_valuePromotion = valuePromotion;
        m_imageUrl = imageUrl;
    }
    
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
    
    public void display()
    {
        System.out.println("ProductNo:" + m_productNo + "  Name:" + m_name + "  Price:" + m_price + "  Quantity:" + m_quantity
                            + "  MinimumPromotion:" + m_minimumPromotion + "  ValuePromotion:" + m_valuePromotion);
    }
}
