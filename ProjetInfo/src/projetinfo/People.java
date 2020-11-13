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
    private String m_firstName;
    private String m_lastName;
    private String m_password;
    private String m_email;

    public People(String firstName,String lastName,String password,String email)
    {
        m_firstName = firstName;
        m_lastName = lastName;
        m_password = password;
        m_email = email;
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
    
    public void setFirstName(String firstName)
    {
        m_firstName=firstName;
    }
      
    public void setLastName(String lastName)
    {
        m_lastName=lastName;
    }
    
    public void setPassword(String password)
    {
        m_password=password;
    }

    public void setEmail(String email)
    {
       m_email=email;
    }
    
}
