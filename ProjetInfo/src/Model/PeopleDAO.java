/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gaëtan
 */
public class PeopleDAO extends TablesDAO
{

    // add a people into the database
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

    // change an element of people into the database
    public void changeElement(JTextField name, JTextField password, JTextField firstname, JLabel email)
    {
        String mypassword = password.getText();
        String myname = name.getText();
        String myfirstname = firstname.getText();
        String myemail = email.getText();
        getConnection();
        try
        {
            stmt.executeUpdate("UPDATE people SET password  = '" + mypassword + "' WHERE email = \"" + myemail + "\"");
            stmt.executeUpdate("UPDATE people SET firstName = '" + myfirstname + "'WHERE  email = \"" + myemail + "\"");
            stmt.executeUpdate("UPDATE people SET lastName  = '" + myname + "' WHERE email = \"" + myemail + "\"");
        } catch (SQLException error)
        {
            System.out.println("Error changeElement PeopleDAO");
        }
        closeConnection();
    }

    // to have the information of a people
    public ArrayList<String> getinformation(String email)
    {
        ArrayList<String> myinfo = new ArrayList<>();
        getConnection();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM people WHERE email = '" + email + "'");
            while (rs.next())
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

    // Delete an account
    public void deleteElements(JTextField email)
    {
        String myemail = email.getText();
        getConnection();
        try
        {
            /*String sqlStatement = "DELETE FROM people where email =  \"" + myemail + "\"";
            
            stmt.execute(sqlStatement);*/
            PreparedStatement st = con.prepareStatement("DELETE FROM people WHERE email = ?");
            st.setString(1, myemail);
            st.executeUpdate();
        } catch (SQLException error)
        {
            System.out.println("Error deleteElements PeopleDAO");
        }
        closeConnection();
    }

    // To have the status of the people (employee or customer)
    public String statusPeople(String email)
    {
        String status = null;
        getConnection();
        try
        {
            String sqlStatement = "SELECT status FROM people where email = \"" + email + "\"";
            ResultSet res = stmt.executeQuery(sqlStatement);
            while (res.next())
            {
                status = res.getString("status");
            }

        } catch (SQLException error)
        {
            System.out.println("Error Connection");
        }
        closeConnection();
        return status;
    }

    // Try to connect on the first page, test if the conditions are OK
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
                if (email.equals(res.getString("email")) && thePassword.equals(res.getString("password")))
                    return true;
            }

        } catch (SQLException error)
        {
            System.out.println("Error Connection");
        }

        closeConnection();
        return false;
    }

    // get the status
    public String getstatus(JTextField email)
    {
        String myemail = email.getText();
        getConnection();
        try
        {
            String status = "SELECT status FROM people where email = \"" + myemail + "\"";
            ResultSet res = stmt.executeQuery(status);
            while (res.next())
            {
                return res.getString("status");
            }
        } catch (SQLException error)
        {
            System.out.println("Error Connection");
        }
        return "Error";
    }

    // Conditions for the inscription
    public int newinscription(JTextField myemail, JPasswordField mypassword, JPasswordField mypassword2, JTextField name, JTextField firstname, JComboBox<String> status)
    {
        String inputemail = myemail.getText();
        String inputpassword = mypassword.getText();
        String inputpassword2 = mypassword2.getText();
        String inputname = name.getText();
        String inputfirstname = firstname.getText();
        String inputstatus = (String) status.getSelectedItem();
        if (testEmail(inputemail))
            return 1;
        if (!inputemail.contains("@"))
            return 2;
        if (inputname.isEmpty())
            return 3;
        if (inputfirstname.isEmpty())
            return 4;
        if (inputpassword.length() <= 5)
            return 5;
        if (!inputpassword.equals(inputpassword2))
            return 6;

        if (inputemail.contains("@") && (!testEmail(inputemail)) && (inputpassword.length() > 5) && (!inputname.isEmpty()) && (!inputfirstname.isEmpty()) && (inputpassword.equals(inputpassword2)))
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
        return 50;
    }

    // Condition on the email
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

    // Delete all elements of people into the database
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
