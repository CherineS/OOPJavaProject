/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        } catch (SQLException error)
        {
            System.out.println("Error deleteAllElements ProductDAO");
        }
        closeConnection();
    }

    //Ajoute un produit dans la BDD
    public void addElement(JTextField jName, JTextField jPrice, JTextField jQuantity, JTextField jMinPromotion, JTextField jPromotion, JTextField jImage, JTextField jdescription)
    {
        String name = jName.getText();
        double price = Double.parseDouble(jPrice.getText());
        int quantity = Integer.parseInt(jQuantity.getText());
        double valuePromotion = Double.parseDouble(jPromotion.getText());
        int minPromotion = Integer.parseInt(jMinPromotion.getText());
        String imageURL = jImage.getText();
        String description = jdescription.getText();

        getConnection();
        try
        {
            String sqlStatement = "SELECT productNo FROM product";
            ResultSet res = stmt.executeQuery(sqlStatement);
            int productNo = 0;

            while (res.next())
            {
                productNo++;
            }

            sqlStatement = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)"
                    + " VALUES (" + productNo + ", '" + name + "', " + price + ", " + quantity + ", " + minPromotion + ", " + valuePromotion + ", '"+ imageURL +"','"+ description +"' )";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error addElement ProductDAO");
        }
        
        closeConnection();
    }

    //Modifie l'attribut d'un élément
    public void changeElement(String element, JTextField modification, int productNo)
    {
        getConnection();
        try
        {
            switch (element)
            {
                case "price":
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element + " = " + Double.parseDouble(modification.getText()) +" WHERE productNo = "+ productNo);
                    break;
                case "valuePromotion":
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element + " = " + Double.parseDouble(modification.getText()) +" WHERE productNo = "+ productNo);
                    break;
                case "quantity":
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element +" = "+ Integer.parseInt(modification.getText()) +" WHERE productNo = "+ productNo);
                    break;
                case "minimumPromotion":
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element +" = "+ Integer.parseInt(modification.getText()) +" WHERE productNo = "+ productNo);
                    break;
                case "name":
                    String myName = "'" + modification.getText() + "'";
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element + " = " + myName +" WHERE productNo = "+ productNo);
                    break;
                case "description":
                    String myDescription = "'" + modification.getText() + "'";
                    stmt.executeUpdate("UPDATE product "+ "SET "+ element + " = " + myDescription +" WHERE productNo = "+ productNo);
                    break;
            }
            
        } catch (NumberFormatException  | SQLException error)
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
            String sqlStatement = "UPDATE product " + "SET quantity = 0 " + "WHERE productNo = " + productNo;
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteElements ProductDAO");
        }
        closeConnection();
    }
    
    //Retourne toutes clés primaires des produits
    public ArrayList<Integer> returnAllElement()
    {
        ArrayList<Integer> results = new ArrayList<>();

        getConnection();
        try
        {
            String sqlStatement = "SELECT productNo FROM product WHERE quantity != 0";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                results.add(res.getInt("productNo"));
            }

        } catch (SQLException error)
        {
            System.out.println("Error searchElement ProductDAO");
        }
        closeConnection();

        return results;
    }

    //Recherche d'un produit en fonction de son nom et retourne les clés primaires des résultats
    public ArrayList<Integer> searchElement(JTextField myName)
    {
        ArrayList<Integer> results = new ArrayList<>();
        String name = myName.getText();
        name = "%" + name + "%";

        getConnection();
        try
        {
            String sqlStatement = "SELECT productNo FROM product WHERE name LIKE \""+ name +"\"";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                results.add(res.getInt("productNo"));
            }

        } catch (SQLException error)
        {
            System.out.println("Error searchElement ProductDAO");
        }
        closeConnection();

        return results;
    }
    
    public Product createJavaProduct(int productNo)
    {
        Product newJavaProduct = new Product();
        
        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM product WHERE productNo = "+ productNo);
            while (res.next())
            {
                
                newJavaProduct = new Product(res.getInt("productNo"),res.getString("name"), res.getDouble("price"),
                                        res.getInt("quantity"),res.getInt("minimumPromotion"),res.getDouble("valuePromotion"),
                                        res.getString("lienURL"), res.getString("description"));
            }
        } 
        catch (SQLException error)
        {
            System.out.println("Error readElements ProductDAO");
        }
        closeConnection();
        
        return newJavaProduct;
    }
}
