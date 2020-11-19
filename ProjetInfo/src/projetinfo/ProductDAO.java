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
    
    //Ajoute un produit dans la BDD
    public void addElement(JTextField jName, JTextField jPrice, JTextField jQuantity, JTextField jMinPromotion, JTextField jPromotion)
    {
        String name = jName.getText();
        double price = Double.parseDouble(jPrice.getText());
        int quantity = Integer.parseInt(jQuantity.getText());
        double valuePromotion = Double.parseDouble(jMinPromotion.getText());
        int minPromotion = Integer.parseInt(jPromotion.getText());
        
        getConnection();
        try
        {
            String sqlStatement = "SELECT productNo FROM product";
            ResultSet res = stmt.executeQuery(sqlStatement);
            int productNo=0;
            
            while (res.next()) 
                productNo++;
            
            sqlStatement = "INSERT INTO product "+ "(productNo, name, price, quantity, minimumPromotion, valuePromotion)" +
                    " VALUES ("+ productNo +", '"+ name +"', "+ price +", "+ quantity +", "+ minPromotion +", "+ valuePromotion +")";
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e)
        {
            System.out.println("Error addElements ProductDAO");
        }
        closeConnection();
    }
    
    //Modifie l'attribut d'un élément
    public void changeElement(String element, JTextField modification, int productNo)
    {
        String inputmodification = modification.getText();
        
        getConnection();
        try
        {
            stmt.executeUpdate("UPDATE product "+ "SET "+ element +" = "+ inputmodification +" WHERE productNo = "+ productNo);
        } catch (Exception e)
        {
            System.out.println("Error changeElement ProductDAO");
        }
        closeConnection();
    }
    
    //Supprime un produit selon son numéro de produit (clé primaire)
    public void deleteElement(int productNo)
    {
        getConnection();
        try
        {
            String sqlStatement = "UPDATE product "+ "SET quantity = 0 " +"WHERE productNo = "+ productNo;
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e)
        {
            System.out.println("Error deleteElements ProductDAO");
        }
        closeConnection();
    }

    //Recherche d'un produit en fonction de son nom et retourne les clés primaires des résultats
    public ArrayList<Integer> searchElement(String name)
    {
        ArrayList<Integer> results=null;
        
        getConnection();
        try
        {    
            String sqlStatement = "SELECT productNo FROM product WHERE name LIKE '"+ name +"'";
            ResultSet res = stmt.executeQuery(sqlStatement);
            
            while (res.next())
            {
                results.add(res.getInt("productNo"));
            }
            
            return results;
        } catch (Exception e)
        {
            System.out.println("Error setElements ProductDAO");
        }
        closeConnection();
        
        return results;
    }
}
