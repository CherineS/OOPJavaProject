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
//        try
//        {
//            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "");
//            Statement stmt = con.createStatement();
//            String sqlStatementProduct1 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(0,'Pomme',0.40,200,10,5,'https://assets.letemps.ch/sites/default/files/media/2020/08/16/file7bvv3g0v9rdyivvq9bw.jpg', 'Pomme bio provenant de nos agriculteurs locaux')";
//            String sqlStatementProduct2 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(1,'Banane',0.55,150,8,6,'https://www.jaimefruitsetlegumes.ca/wp-content/uploads/2019/08/iStock_000007671231Large-e1565725651658-700x700.jpg', 'Belle banane')";
//            String sqlStatementProduct3 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(2,'Kiwi',0.45,100,5,3,'https://produits.bienmanger.com/34089-0w470h470_Kiwi_Frais_Bio.jpg', 'Mmmmhhhh le kiwi')";
//            String sqlStatementProduct4 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(3,'Pamplemousse',0.80,70,10,4,'https://www.havea.com/media/catalog/product/cache/44f3c051f19eb24a4baafa2b36eefbbb/2/e/2e59f3297bbee087fa9eb0d603690845f7e2ae2b_pamplemousse_min.jpg', 'Quel pamplemousse')";
//            String sqlStatementProduct5 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(4,'Orange',0.30,60,7,9,'https://lh3.googleusercontent.com/proxy/BM6O2ZJd3i6P-Twbo8FDNpXwHcqTIUeIbNrRg1SHDUs1jYuOXwENUh0MRGcFAmrDe6t_JirKGC4odHIRnSsz6nc2csrlEdixtd9_uFTtK-rRCMhOwGt7hUdtfN4bTKAf3-qs4WR9E84', 'Orange bien orange')";
//            String sqlStatementProduct6 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(5,'Cerise',0.09,500,20,15,'https://www.academiedugout.fr/images/15839/1200-auto/cerise_000.jpg?poix=50&poiy=50', 'Cerise exceptionnelle')";
//            String sqlStatementProduct7 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(6,'Poire',0.50,50,4,2,'https://www.academiedugout.fr/images/17155/1200-auto/poire_000.jpg?poix=50&poiy=50', 'La poire')";
//            String sqlStatementProduct8 = "INSERT INTO product " + "(productNo, name, price, quantity, minimumPromotion, valuePromotion, lienURL, description)" + " VALUES " + "(7,'Abricot',0.25,80,6,1,'https://observatoire-des-aliments.fr/wp-content/uploads/2013/02/abricot-2.jpg', 'El abricot de la muerte')";
//            
//            stmt.executeUpdate(sqlStatementProduct1);
//            stmt.executeUpdate(sqlStatementProduct2);
//            stmt.executeUpdate(sqlStatementProduct3);
//            stmt.executeUpdate(sqlStatementProduct4);
//            stmt.executeUpdate(sqlStatementProduct5);
//            stmt.executeUpdate(sqlStatementProduct6);
//            stmt.executeUpdate(sqlStatementProduct7);
//            stmt.executeUpdate(sqlStatementProduct8);
//            con.close();
//        } catch (SQLException error)
//        {
//            System.out.println("Database PRODUIT déjà à jour");
//        }

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
        
        try
        {
            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sqlStatementOrders1 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('0-0',0,0,'gaetan.bouchy@yahoo.fr',20,17,'2020-12-04')";
            String sqlStatementOrders2 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('0-1',0,1,'gaetan.bouchy@yahoo.fr',40,28,'2020-12-04')";
            String sqlStatementOrders3 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('1-2',1,2,'gaetan.bouchy@yahoo.fr',60,38,'2020-12-04')";
            String sqlStatementOrders4 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('1-3',1,3,'gaetan.bouchy@yahoo.fr',50,42,'2020-12-04')";
            String sqlStatementOrders5 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('1-4',1,4,'gaetan.bouchy@yahoo.fr',24,18,'2020-12-04')";
            String sqlStatementOrders6 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('2-5',2,5,'gaetan.bouchy@yahoo.fr',28,23,'2020-12-04')";
            String sqlStatementOrders7 = "INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)" + " VALUES " + "('3-6',3,6,'gaetan.bouchy@yahoo.fr',14,12,'2020-12-04')";
            
            stmt.executeUpdate(sqlStatementOrders1);
            stmt.executeUpdate(sqlStatementOrders2);
            stmt.executeUpdate(sqlStatementOrders3);
            stmt.executeUpdate(sqlStatementOrders4);
            stmt.executeUpdate(sqlStatementOrders5);
            stmt.executeUpdate(sqlStatementOrders6);
            stmt.executeUpdate(sqlStatementOrders7);
            
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database ORDERS déjà à jour");
        }
    }
    
    public static void main(String[] args) 
    {
//       createDatabase();
        
       Controller myController = new Controller();
       myController.addAllButtons();
    }
}