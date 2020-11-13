/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;

/**
 *
 * @author antoi
 */
public class Customers extends People
{

    private ArrayList<Orders> m_orders;
    private double m_account;

    public Customers(String firstName, String name, String password, String email, double account)
    {
        super(firstName, name, password, email);
        m_account = account;
    }

    public ArrayList<Orders> getOrders()
    {
        return m_orders;
    }

    public double getAccount()
    {
        return m_account;
    }
    
    public void setOrders(ArrayList<Orders> orders)
    {
        m_orders=orders;
    }
    
    public void setAccount(double account)
    {
        m_account=account;
    }

}
