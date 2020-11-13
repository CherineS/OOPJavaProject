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
    
    public Product(String name,double price, int quantity,int promotion)
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

    public void setNom(String name)
    {
        m_name = name;
    }

    public void setPrix(double price)
    {
        m_price = price;
    }

    public void setPromo(double promotion)
    {
        m_promotion = promotion;
    }

    public void setQuantite(int quantity)
    {
        m_quantity = quantity;
    }
   
}
