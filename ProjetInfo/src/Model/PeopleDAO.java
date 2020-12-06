/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.swing.JComboBox;
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

    public void changeElement(JTextField name, JTextField password, JTextField firstname,String email)
    {
        String mypassword = password.getText();
        String myname = name.getText();
        String myfirstname = firstname.getText();

        getConnection();
        try
        {
                stmt.executeUpdate("UPDATE people " + "SET password  = '" + mypassword + "' " + "WHERE" + " email = '" + email + "' ");
                stmt.executeUpdate("UPDATE people " + "SET firstname = '" + myfirstname + "' " + "WHERE" + " email = '" + email + "' ");
                stmt.executeUpdate("UPDATE people " + "SET lastname  = '" + myname + "' " + "WHERE" + " email = '" + email + "' ");
        } catch (SQLException error)
        {
            System.out.println("Error changeElement PeopleDAO");
        }
        closeConnection();
    }
    
    public ArrayList<String> getinformation(String email)
    {
        ArrayList<String> myinfo = new ArrayList<>();
        String Email,firstname,name,password;
        getConnection();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM people WHERE email = '" + email + "'"); 
            while(rs.next())
            {    
            myinfo.add(rs.getString("email"));
            myinfo.add(rs.getString("lastName"));
            myinfo.add(rs.getString("firstName"));
            myinfo.add(rs.getString("password"));
            }
        } catch (SQLException error)
        {
            System.out.println("Error with information from PeopleDAO");
        }
        closeConnection();
        return myinfo;
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
    
    public int newinscription(JTextField myemail, JPasswordField mypassword,JPasswordField mypassword2,JTextField name,JTextField firstname,JComboBox<String> status)
    {
        String inputemail = myemail.getText();
        String inputpassword = mypassword.getText();
        String inputpassword2 = mypassword.getText();
        String inputname = name.getText();
        String inputfirstname = firstname.getText();
        String inputstatus = (String)status.getSelectedItem();
        if(inputemail.contains("@") && (!testEmail(inputemail)) && (inputpassword.length()>5) && (!inputname.isEmpty()) && (!inputfirstname.isEmpty()) && (inputpassword.equals(inputpassword2)))
        {
            getConnection();
           try
        {
         stmt.executeUpdate("INSERT INTO people" + "(email, firstName, lastName, password, status)" + " VALUES " + "('" + inputemail + "','" + inputfirstname + "','" + inputname + "','" + inputpassword + "','" + inputstatus + "')");
          return 0;
        } catch (SQLException error)
        {
            System.out.println("Error addElement PeopleDAO");
        }
        closeConnection();
        }
        else{
                if(testEmail(inputemail))
                    {
                       return 1;
                    }
                if(!inputemail.contains("@"))
                    {
                       return 2;
                    }
                if(inputname.isEmpty())
                    {
                       return 3;
                    }
                if(inputfirstname.isEmpty())
                    {
                       return 4;
                    }
                if(inputpassword.length()>5)
                    {
                       return 5;
                    }
                if(inputpassword.equals(inputpassword2))
                    {
                       return 6;
                    }
                
          }
      return 50;
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