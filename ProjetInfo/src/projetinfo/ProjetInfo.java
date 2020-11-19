/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import View.*;
import Controller.*;

import java.sql.*;
import javax.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.ArrayList;

import projetinfo.TablesDAO;
import projetinfo.OrdersDAO;
import projetinfo.PeopleDAO;
import projetinfo.ProductDAO;
import projetinfo.Orders;
import projetinfo.People;
import projetinfo.Product;

        



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
            String test = "YOLO";
            String test2 = "Fuck";
            
            String sqlStatementPeople2 = "INSERT INTO people " + "(email, firstName, lastName, password, status)" + " VALUES " + "('antoine.stutzmann@edu.ece.fr','Antoine','Stutzmann','Test','people')";
            stmt.executeUpdate("INSERT INTO people" + "(email, firstName, lastName, password, status)" +  " VALUES "  + "('" + test2 + "','" + test + "','" + test + "','" + test + "','" + test + "')");
            stmt.executeUpdate(sqlStatementPeople2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database PEOPLE déjà à jour");
        }
    }
    
    
    public static void main(String[] args) 
    {    
        //createDatabase();
    }
}