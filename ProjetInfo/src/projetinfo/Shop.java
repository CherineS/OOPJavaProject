/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import com.sun.webkit.dom.KeyboardEventImpl;
import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antoi
 */
public class Shop
{

    private ArrayList<Produit> m_reserve;
    private ArrayList<Personne> m_personne;

    public Shop(ArrayList<Produit> reserve, ArrayList<Personne> personne)
    {
        m_personne = personne;
        m_reserve = reserve;
    }

    public ArrayList<Personne> getPersonne()
    {
        return m_personne;
    }

    public ArrayList<Produit> getReserve()
    {
        return m_reserve;
    }

    public void setQuantity()
    {
        Scanner keyboard = new Scanner(System.in);
        
        // Condition à rajouter pour le fait que ce soit un employé et pas un client
        
        String name;
        String begin = "\'";
        String end = "\'";
        int quantity;
        System.out.println("Choisir le nom de l'objet à modifier");
        name=keyboard.next();
        System.out.println("Choisir la quantité à mettre");
        quantity=keyboard.nextInt();
        name = begin.concat(name);
        name = name.concat(end);
        
        
        for (int i = 0; i < m_reserve.size(); i++)
            if (name.equals(m_reserve.get(i).getName()))
                try
                {
                    String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
                    Connection con = DriverManager.getConnection(url, "root", "");
                    Statement stmt = con.createStatement();
                    
                    String sqlStatement = "UPDATE product" + "SET quantity = " + quantity + " WHERE " + "name = " + name;
                    
                    con.close();
                } catch (SQLException error)
                {
                    System.out.println("Fail setQuantity SHOP");
                }
    }

}
