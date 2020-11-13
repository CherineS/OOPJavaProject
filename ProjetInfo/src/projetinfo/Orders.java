/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author antoi
 */
public class Orders
{

    private int m_orderNumber;
    private Date m_date;
    private ArrayList<Product> m_products;
    private double m_totalPrice;

    public Orders(int orderNumber, Date date, ArrayList<Product> products)
    {
        m_orderNumber = orderNumber;
        m_date = date;
        m_products = products;
    }
    
    public void totalPrice()
    {    
        for(int i=0; i<m_products.size(); i++)
        {       
             m_totalPrice=(m_products.get(i).getQuantity()/m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()-m_products.get(i).getValuePromotion())) + (m_products.get(i).getQuantity()%m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()));
        }
    }

    public int getOrderNumber()
    {
        return m_orderNumber;
    }

    public Date getDate()
    {
        return m_date;
    }

    public ArrayList<Product> getProducts()
    {
        return m_products;
    }

    public double getTotalPrice()
    {
        return m_totalPrice;
    }

    public void setOrderNumber(int orderNumber)
    {
        m_orderNumber = orderNumber;
    }

    public void setDate(Date date)
    {
        m_date = date;
    }

    public void setProducts(ArrayList<Product> products)
    {
        m_products = products;
    }

    public void setTotalPrice(double totalPrice)
    {
        m_totalPrice = totalPrice;
    }

}
