/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.swing.JTextField;

/**
 *
 * @author Gaëtan
 */
public class PeopleDAO extends TablesDAO
{
    public void addElement(JTextField email,JTextField FirstName,JTextField lastName,JTextField password,JTextField status)
    {
        String inputEmail = email.getText();
        String inputFirstName = FirstName.getText();
        String inputlastName = lastName.getText();
        String inputpassword = password.getText();
        String inputstatus = password.getText();
        getConnection();
        try
        {   
          stmt.executeUpdate("INSERT INTO people" + "(email, firstName, lastName, password, status)" +  " VALUES "  + "('" + inputEmail + "','" + inputFirstName + "','" + inputlastName + "','" + inputpassword + "','" +  inputstatus + "')");
        }
       catch (SQLException error)
        {
            System.out.println("People already exist in the Data Base");
        }
        closeConnection();
    } 
    
    public void changeElement(JTextField element, JTextField modification, String email)
    {
        String inputElement = element.getText();
        String inputmodification = modification.getText();

        getConnection();
        try
        {
            if (inputElement.equals("password"))
                stmt.executeUpdate("UPDATE people " + "SET password  = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
            if (inputElement.equals("firstname"))
                stmt.executeUpdate("UPDATE people " + "SET firstname = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
            if (inputElement.equals("lastname"))
                stmt.executeUpdate("UPDATE people " + "SET lastname  = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
        } catch (SQLException error)
        {
            System.out.println("Modification impossible");
        }
        closeConnection();
    }
    
    public void deleteElements(JTextField email)
    {
        String inputEmail = email.getText();
        getConnection();
        try
        { 
          String sqlStatement = "DELETE FROM people where email =  '" + inputEmail + "' ";
          stmt.executeUpdate(sqlStatement);
       
        }
       catch (SQLException error)
        {
            System.out.println("Error People don't exist");
        }
       closeConnection();
    }
    
    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM people";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteAllElements PeopleDAO");
        }
        closeConnection();
    }
}

