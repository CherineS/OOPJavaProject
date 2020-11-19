/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;
import projetinfo.TablesDAO;
import projetinfo.OrdersDAO;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import projetinfo.PeopleDAO;

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
//            String sqlStatementProduct1 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion)" + " VALUES " + "(0,'Banane',1,100,10,0.05)";
//            String sqlStatementProduct2 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion)" + " VALUES " + "(1,'Kiwi',1.20,150,10,0.12)";
//            stmt.executeUpdate(sqlStatementProduct1);
//            stmt.executeUpdate(sqlStatementProduct2);
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
        
        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementOrders1 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, date)" + " VALUES " + "('0-0',0,0,'gaga',30,'2020-08-18')";
            String sqlStatementOrders2 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, date)" + " VALUES " + "('1-1',1,1,'rara',40,'2019-09-24')";
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
//        JTextField quantity = new JTextField("42");
//        JTextField email= new JTextField("antoine.stutzmann@edu.ece.fr");
//        JTextField number = new JTextField("0");
//        JTextField quantity2 = new JTextField("32");
//        JTextField email2 = new JTextField("gaetan.bouchy@yahoo.fr");
//        JTextField number2 = new JTextField("1");
//        OrdersDAO myobj = new OrdersDAO();
        
        PeopleDAO myobj = new PeopleDAO();
        JTextField element = new JTextField("password");
        JTextField modification = new JTextField("123456");
        String email = "antoine.stutzmann@edu.ece.fr";
        myobj.changeElement(element, modification, email);
        
        
        
//       myobj.AddShop(quantity, email, number);
//       myobj.AddShop(quantity2, email2, number2);
//       myobj.deleteShop(number);
//       myobj.addOrders(); 
//       ProductDAO myobj2= new ProductDAO();
//       myobj2.deleteElements(email);     
//       myobj.deleteAllElements();    
//       myobj.deleteElement();
  
    }
}