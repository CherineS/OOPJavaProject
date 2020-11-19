/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
}


