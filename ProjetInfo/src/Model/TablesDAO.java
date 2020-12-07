/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

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

     // get the connection to the database
    public void getConnection()
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

    // close the connection to the database
    public void closeConnection()
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
    
    // get the current date and return it
    public String getDate()
    {  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        return formatter.format(date);
    }

    public abstract void deleteAllElements(); 
 
}
