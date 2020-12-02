/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gaëtan
 */
public class PeopleDAO extends TablesDAO
{

    public void addElement(JTextField email, JTextField FirstName, JTextField lastName, JTextField password, JTextField status)
    {
        String inputEmail = email.getText();
        String inputFirstName = FirstName.getText();
        String inputlastName = lastName.getText();
        String inputpassword = password.getText();
        String inputstatus = status.getText();
        getConnection();

        try
        {
            stmt.executeUpdate("INSERT INTO people" + "(email, firstName, lastName, password, status)" + " VALUES " + "('" + inputEmail + "','" + inputFirstName + "','" + inputlastName + "','" + inputpassword + "','" + inputstatus + "')");
        } catch (SQLException error)
        {
            System.out.println("Error addElement PeopleDAO");
        }
        closeConnection();
    }

    public void changeElement(String element, JTextField modification, String email)
    {
        String inputmodification = modification.getText();

        getConnection();
        try
        {
            if (element.equals("password"))
                stmt.executeUpdate("UPDATE people " + "SET password  = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
            if (element.equals("firstName"))
                stmt.executeUpdate("UPDATE people " + "SET firstname = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
            if (element.equals("lastName"))
                stmt.executeUpdate("UPDATE people " + "SET lastname  = '" + inputmodification + "' " + "WHERE" + " email = '" + email + "' ");
        } catch (SQLException error)
        {
            System.out.println("Error changeElement PeopleDAO");
        }
        closeConnection();
    }

    public void deleteElements(String email)
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM people where email =  '" + email + "' ";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteElements PeopleDAO");
        }
        closeConnection();
    }

    public boolean Connection(JTextField myemail, JPasswordField mypassword)
    {
        String email = myemail.getText();
        String thePassword = mypassword.getText();
        
        getConnection();
        try
        {
            String sqlStatement = "SELECT* FROM people";
            ResultSet res = stmt.executeQuery(sqlStatement);
            
            while (res.next())
            {
                if (email.equals(res.getString("email"))&&thePassword.equals(res.getString("password")))
                    return true;
            }
   
        } catch (SQLException error)
        {
            System.out.println("Error Connection");
        }
      
        closeConnection();
   return false;
    }

    public boolean testEmail(String email)
    {
        getConnection();
        try
        {
            String sqlStatement = "SELECT* FROM people";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                if (email.equals(res.getString("email")))
                    return true;
            }
        } catch (SQLException error)
        {
            System.out.println("Error testEmail");
        }
        closeConnection();
        return false;
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
