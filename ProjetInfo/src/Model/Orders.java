/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;  

/**
 *
 * Attributes of the class orders
 */
public class Orders
{
    private int m_orderNumber;
    private Date m_date;
    private Product m_products;
    private double m_price;
    private String m_email;


    // Constructor
    public Orders(int orderNumber, Date date, Product products, double price, String email)
    {
        m_orderNumber = orderNumber;
        m_date = date;
        m_products = products;
        m_price=price;
        m_email=email;
    }
    
    // Every getter
    public int getOrderNumber()
    {
        return m_orderNumber;
    }

    public Date getDate()
    {
        return m_date;
    }

    public Product getProducts()
    {
        return m_products;
    }

    public double getPrice()
    {
        return m_price;
    }
    
    public String getEmail()
    {
        return m_email;
    }

    // Every setter
    public void setOrderNumber(int orderNumber)
    {
        m_orderNumber = orderNumber;
    }

    public void setDate(Date date)
    {
        m_date = date;
    }

    public void setProducts(Product products)
    {
        m_products = products;
    }

    public void setPrice(double price)
    {
        m_price = price;
    }
    
    public void setEmail(String email)
    {
        m_email=email;
    }
}
