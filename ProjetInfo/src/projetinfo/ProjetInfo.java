/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.sql.*;
import javax.sql.*;

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
            String sqlStatementOrders1 = "INSERT INTO orders " + "(orderNo, productNo, quantity, totalPrice, date)" + " VALUES " + "(0,0,30,40,'2018-09-24')";
            String sqlStatementOrders2 = "INSERT INTO orders " + "(orderNo, productNo, quantity, totalPrice, date)" + " VALUES " + "(1,1,30,40,'2018-09-24')";
            stmt.executeUpdate(sqlStatementOrders1);
            stmt.executeUpdate(sqlStatementOrders2);
            con.close();
        } catch (SQLException error)
        {
            System.out.println("Database ORDERS déjà à jour");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        createDatabase();
    }

}

//        try
//        {
////            int value = 13;
////            String begin = "\'";
////            String end = "\'";
////            String name = "Banane";
////            name = begin.concat(name);
////            name = name.concat(end);
////            System.out.println("" + name);
//
//            // Class.forName("com.mysql.cj.jdbc.Driver"); // Pas nécéssaire
//            String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//            // localhost::3306 = port par défaut de mySQL
//            // Format à suivre : jdbc:mysql://localhost:3306/nom_database puis rajouter ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC 
//            // Pour l'erreur concernant les fuseaux horaires
//            Connection con = DriverManager.getConnection(url, "root", "");
//            // Format à suivre : URL,"Nom utilisateur", "MDP"
//
//            Statement stmt = con.createStatement();
////            ResultSet res = stmt.executeQuery("SELECT* FROM dept");
////            while (res.next())
////            {
////                String name = res.getString("loc");
////                System.out.println(name);
////            }
//
//            String sqlStatement = "INSERT INTO product " + "(name, price, promotion, quantity)" + " VALUES " + "('Kiwi',1.20,14,100)";
//            // Insérer un nouvelle élément dans la table dept 
//            // String sqlStatement = "DELETE FROM dept WHERE loc = 'Paris'";
//            // Supprimer un élément de la table en fonction d'un critère
//            // String sqlStatement = "DELETE FROM dept";
//            // Supprime tous les éléments
//            //String sqlStatement = "UPDATE product " + "SET quantity = " + value + " WHERE " + "name = " + name;
//            int rows = stmt.executeUpdate(sqlStatement);
//            System.out.println("nombre:" + rows);
//
//            con.close();
//            // Fermer la communication
//
//        } //        catch(ClassNotFoundException ex)
//        //        {
//        //            System.out.println(ex.getMessage());
//        //            Logger.getLogger(TESTPROJET.class.getName()).log(Level.SEVERE, null, ex);
//        //            System.out.println("Fail class not found ");    
//        //        }   // Code pas spécialement nécessaire, permets de savoir l'erreur précise
//        catch (SQLException error)
//        {
////            Logger.getLogger(TESTPROJET.class.getName()).log(Level.SEVERE, null, ex);
////            Code pas spécialement nécessaire, permets de savoir l'erreur précise
//            System.out.println("Fail SQL");
//        }
//    }
