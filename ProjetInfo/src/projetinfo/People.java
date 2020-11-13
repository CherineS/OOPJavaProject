/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

/**
 *
 * @author antoi
 */
public class People
{
    private final String m_firstName;
    private final String m_lastName;
    private final String m_password;
    private final String m_email;
    private final String m_status;

    public People(String firstName,String lastName,String password,String email, String status)
    {
        m_firstName = firstName;
        m_lastName = lastName;
        m_password = password;
        m_email = email;
        m_status=status;
    }

    public String getFirstName()
    {
        return m_firstName;
    }
      
    public String getLastName()
    {
        return m_lastName;
    }
    
    public String getPassword()
    {
        return m_password;
    }

    public String getEmail()
    {
        return m_email;
    }
    
    public String getStatus()
    {
        return m_status;
    }
    
}
