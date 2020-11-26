/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import View.*;
import java.awt.*;
import Controller.*;

import java.math.RoundingMode;
import javax.swing.*;
import java.sql.*;
import javax.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.ArrayList;

        
public class ProjetInfo
{
    public static void createDatabase()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementProduct1 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL)" + " VALUES " + "(2,'Pomme',1,100,10,0.05,'https://fac.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2FFAC.2F2019.2F09.2F20.2Ff9a0f4d7-6214-4e0c-9c55-bfc706e473a2.2Ejpeg/1200x1200/quality/80/crop-from/center/quels-sont-les-bienfaits-du-kiwi.jpeg')";
            String sqlStatementProduct2 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL)" + " VALUES " + "(3,'Pomme22',1.20,150,10,0.12,'https://fac.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2FFAC.2F2019.2F09.2F20.2Ff9a0f4d7-6214-4e0c-9c55-bfc706e473a2.2Ejpeg/1200x1200/quality/80/crop-from/center/quels-sont-les-bienfaits-du-kiwi.jpeg')";
            stmt.executeUpdate(sqlStatementProduct1);
            stmt.executeUpdate(sqlStatementProduct2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database PRODUIT déjà à jour");
        }

//        try
//        {
//            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "");
//            Statement stmt = con.createStatement();
//            String sqlStatementPeople1 = "INSERT INTO people " + "(email, firstName, lastName, password, status)" + " VALUES " + "('gaetan.bouchy@yahoo.fr','Gaetan','Bouchy','holibani','employee')";
//            String sqlStatementPeople2 = "INSERT INTO people " + "(email, firstName, lastName, password, status)" + " VALUES " + "('antoine.stutzmann@edu.ece.fr','Antoine','Stutzmann','Test','people')";
//            stmt.executeUpdate(sqlStatementPeople1);
//            stmt.executeUpdate(sqlStatementPeople2);
//            con.close();
//        } catch (SQLException error)
//        {
//            System.out.println("Database PEOPLE déjà à jour");
//        }
//        
//        try
//        {
//            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "");
//            Statement stmt = con.createStatement();
//            String sqlStatementOrders1 = "INSERT INTO orders " + "(orderNo, productNo, quantity, date)" + " VALUES " + "(0,0,30,'2018-09-24')";
//            String sqlStatementOrders2 = "INSERT INTO orders " + "(orderNo, productNo, quantity, date)" + " VALUES " + "(1,1,30,'2018-09-24')";
//            stmt.executeUpdate(sqlStatementOrders1);
//            stmt.executeUpdate(sqlStatementOrders2);
//            con.close();
//        } catch (SQLException error)
//        {
//            System.out.println("Database ORDERS déjà à jour");
//        }
    }
    
    public static void main(String[] args) 
    {
//        createDatabase();
        
        Controller myController = new Controller();
        myController.addAllButtons();
    }
}