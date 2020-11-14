/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
/**
 *
 * @author Gaëtan
 */
public class OrdersDAO extends TablesDAO
{
    private ArrayList<Orders> m_databaseOrders = new ArrayList<>();
    private ArrayList<Product> m_databaseProducts = new ArrayList<>();

    @Override
    public void readElements()
    {  
        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM people");
            while (res.next())
            {
                Product myProduct = new Product(res.getInt("productNo"),null,res.getDouble("totalPrice"),res.getInt("quantity"),0,0);
                m_databaseProducts.add(myProduct);
                Orders myOrders = new Orders(res.getInt("orderNo"),res.getDate("date"),m_databaseProducts);
                m_databaseOrders.add(myOrders);
            }
        } 
        catch (SQLException error)
        {
            System.out.println("Error readElements OrdersDAO");
        }
        closeConnection();
    }

    @Override
    public void addElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM orders";
            stmt.executeUpdate(sqlStatement);
        } 
        catch (SQLException error)
        {
            System.out.println("Error deleteAllElements OrdersDAO");
        }
        closeConnection();
    }

    @Override
    public void setElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public void totalPrice()
//    {    
//        for(int i=0; i<m_products.size(); i++)
//        {       
//             m_totalPrice=(m_products.get(i).getQuantity()/m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()-m_products.get(i).getValuePromotion())) + (m_products.get(i).getQuantity()%m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()));
//        }
//    }
}
