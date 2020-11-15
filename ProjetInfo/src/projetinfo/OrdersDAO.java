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
    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM orders";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteAllElements OrdersDAO");
        }
        closeConnection();
    }

    @Override
    public void addElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    public void totalPrice()
//    {    
//        for(int i=0; i<m_products.size(); i++)
//        {       
//             m_totalPrice=(m_products.get(i).getQuantity()/m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()-m_products.get(i).getValuePromotion())) + (m_products.get(i).getQuantity()%m_products.get(i).getminimumPromotion()*(m_products.get(i).getPrice()));
//        }
//    }

//    @Override
//    public void readElements()
//    {
//        getConnection();
//        try
//        {
//            ResultSet res = stmt.executeQuery("SELECT* FROM people");
////            
//            while (res.next())
//            {
//                int stock = res.getInt("orderNo");
//                do
//                {
//                    for (int i = 0; i < m_allProducts.size(); i++)
//                        if (res.getInt("ProductNo") == m_allProducts.get(i).getProductNo())
//                        {
//                            Product myProduct = new Product(m_allProducts.get(i).getProductNo(), m_allProducts.get(i).getName(),
//                                    m_allProducts.get(i).getPrice(), res.getInt("quantity"),
//                                    m_allProducts.get(i).getminimumPromotion(), m_allProducts.get(i).getValuePromotion());
//                            
//                            m_databaseProducts.add(myProduct);
//                        }
//
//                } while (res.getInt("OrderNo") == stock);
//
//                Orders myOrders = new Orders(res.getInt("orderNo"), res.getDate("date"), m_databaseProducts);
//                m_databaseOrders.add(myOrders);
//            }
//        } catch (SQLException error)
//        {
//            System.out.println("Error readElements OrdersDAO");
//        }
//        closeConnection();
//    }
