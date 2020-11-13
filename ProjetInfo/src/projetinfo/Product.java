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
    
    public Product(int productNo, String name,double price, int quantity, int minimumPromotion, double valuePromotion)
    {
        m_productNo=productNo;
        m_name = name;
        m_price = price;
        m_quantity = quantity;
        m_minimumPromotion=minimumPromotion;
        m_valuePromotion = valuePromotion;
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
   
}
