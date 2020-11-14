/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;

/**
 *
 * @author Gaëtan
 */
public class PeopleDAO extends TablesDAO
{
    
    private ArrayList<People> m_databasePeoples = new ArrayList<>(); 
    
    @Override
    public void readElements()
    {  
        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM people");
            while (res.next())
            {
                
                People myPeople = new People(res.getString("firstName"),res.getString("lastName"),res.getString("password"),
                                             res.getString("email"), res.getString("status"));
                m_databasePeoples.add(myPeople);
            }
        } 
        catch (SQLException error)
        {
            System.out.println("Error readElements PeopleDAO");
        }
        closeConnection();
    }
    
    public ArrayList<People> getDatabasePeoples()
    {
        return m_databasePeoples;
    }

    @Override
    public void addElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM people";
            stmt.executeUpdate(sqlStatement);
        } 
        catch (SQLException error)
        {
            System.out.println("Error deleteAllElements PeopleDAO");
        }
        closeConnection();
    }

    @Override
    public void setElement()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
