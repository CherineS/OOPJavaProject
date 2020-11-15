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
public class ProductDAO extends TablesDAO
{
    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM product";
            stmt.executeUpdate(sqlStatement);
        } 
        catch (SQLException error)
        {
            System.out.println("Error deleteAllElements ProductDAO");
        }
        closeConnection();
    }
    
    @Override
    public void addElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


//    @Override
//    public void readElements()
//    {  
//        getConnection();
//        try
//        {
//            ResultSet res = stmt.executeQuery("SELECT* FROM product");
//            while (res.next())
//            {
//                
//                Product myProduct = new Product(res.getInt("productNo"),res.getString("name"), res.getDouble("price"),
//                                        res.getInt("quantity"),res.getInt("minimumPromotion"),res.getDouble("valuePromotion"));
//                //m_databaseProducts.add(myProduct);
//            }
//        } 
//        catch (SQLException error)
//        {
//            System.out.println("Error readElements ProductDAO");
//        }
//        closeConnection();
//    }
