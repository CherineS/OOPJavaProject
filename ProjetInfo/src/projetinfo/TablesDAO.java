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
 * @author Gaëtan
 */
public abstract class TablesDAO
{
    protected String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    protected String user = "root";
    protected String password = "";
    protected Connection con;
    protected Statement stmt;

    public void getConnection() // Etablir la connection
    {
        try
        {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException error)
        {
            System.out.println("Error create connection");
        }
    }

    public void closeConnection() // Fermer la connection
    {
        try
        {
        con.close();
        }
        catch (SQLException error)
        {
            System.out.println("Error close connection");
        }
    }

    
    public abstract void readElements(); // 1 méthode pour lire ==> Au début du programme, lire chaque table
    public abstract void addElement(); // 1 méthode pour ajouter un élément, nécessite les attributs de l'élément en question 
    // 2 options ==> Scanner ou Passer en paramètres
    public abstract void deleteElement(); // Supprimer un élément en fonction de la clé primaire
    public abstract void deleteAllElements(); // 1 méthode pour tout delete
    public abstract void setElement(); // Modifier un élément en fonction de la clé primaire

}
