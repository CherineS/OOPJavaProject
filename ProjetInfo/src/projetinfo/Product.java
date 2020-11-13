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
    private String m_name;
    private double m_price;
    private int m_quantity;
    private double m_promotion;
    
    public Product(String name,double price, int quantity, double promotion)
    {
        m_name = name;
        m_price = price;
        m_quantity = quantity;
        m_promotion = promotion;
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
    
    public double getPromotion()
    {
        return m_promotion;
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

    public void setPromotion(double promotion)
    {
        m_promotion = promotion;
    }


   
}
