/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author antoi
 */
public class People
{

    protected String m_firstName;
    protected String m_lastName;
    protected String m_password;
    protected String m_email;
    protected String m_status;

    public People(String firstName, String lastName, String password, String email, String status)
    {
        m_firstName = firstName;
        m_lastName = lastName;
        m_password = password;
        m_email = email;
        m_status = status;
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

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }

    public void setStatus(String status)
    {
        m_status = status;
    }

    public void display()
    {
        System.out.println("FirstName:" + m_firstName + "  LastName:" + m_lastName + "  Password:" + m_password + "  Email:" + m_email + "  Status:" + m_status);
    }

}
