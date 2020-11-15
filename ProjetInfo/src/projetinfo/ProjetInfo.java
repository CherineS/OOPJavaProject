/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;

/**
 *
 * @author antoine
 */
public class ProjetInfo
{

    public static void createDatabase()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementProduct1 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion)" + " VALUES " + "(0,'Banane',1,100,10,0.05)";
            String sqlStatementProduct2 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion)" + " VALUES " + "(1,'Kiwi',1.20,150,10,0.12)";
            stmt.executeUpdate(sqlStatementProduct1);
            stmt.executeUpdate(sqlStatementProduct2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database PRODUIT déjà à jour");
        }

        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementPeople1 = "INSERT INTO people " + "(email, firstName, lastName, password, status)" + " VALUES " + "('gaetan.bouchy@yahoo.fr','Gaetan','Bouchy','holibani','employee')";
            String sqlStatementPeople2 = "INSERT INTO people " + "(email, firstName, lastName, password, status)" + " VALUES " + "('antoine.stutzmann@edu.ece.fr','Antoine','Stutzmann','Test','people')";
            stmt.executeUpdate(sqlStatementPeople1);
            stmt.executeUpdate(sqlStatementPeople2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database PEOPLE déjà à jour");
        }
        
        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementOrders1 = "INSERT INTO orders " + "(orderNo, productNo, quantity, date)" + " VALUES " + "(0,0,30,'2018-09-24')";
            String sqlStatementOrders2 = "INSERT INTO orders " + "(orderNo, productNo, quantity, date)" + " VALUES " + "(1,1,30,'2018-09-24')";
            stmt.executeUpdate(sqlStatementOrders1);
            stmt.executeUpdate(sqlStatementOrders2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database ORDERS déjà à jour");
        }
    }
    
    
    public static void main(String[] args)
    {
//        createDatabase();
//        ArrayList<Product> databaseProducts = new ArrayList<>();
//        ProductDAO myobj = new ProductDAO();
//        myobj.deleteElement();
//        myobj.readElements();
//        databaseProducts=myobj.getDatabaseProducts();
//        for(int i=0; i<databaseProducts.size(); i++)
//            databaseProducts.get(i).display();
    }

}