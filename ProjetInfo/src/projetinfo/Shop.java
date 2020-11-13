/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

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

    private ArrayList<Product> m_products = new ArrayList<>();
    private People m_people;

    public Shop(ArrayList<Product> products, People people)
    {
        m_products = products;
        m_people = people;
    }

    public People getPeople()
    {
        return m_people;
    }

    public ArrayList<Product> getProducts()
    {
        return m_products;
    }

    public void setQuantityEmploye()
    {
        Scanner keyboard = new Scanner(System.in);

        // Condition à rajouter pour le fait que ce soit un employé et pas un client
        String name;
        int quantity;
        System.out.println("Choisir le nom de l'objet à modifier");
        name = keyboard.next();
        System.out.println("Choisir la quantité à mettre");
        quantity = keyboard.nextInt();

        for (int i = 0; i < m_products.size(); i++)
            if (name.equals(m_products.get(i).getName()))
                try
                {
                    String begin = "\'";
                    String end = "\'";
                    name = begin.concat(name);
                    name = name.concat(end);
                    String url = "jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
                    Connection con = DriverManager.getConnection(url, "root", "");
                    Statement stmt = con.createStatement();
//                    System.out.println("name:" + name);
//                    System.out.println("quantity:" + quantity);
                    String sqlStatement = "UPDATE product" + "SET quantity = " + quantity + " WHERE " + "name = " + name;
                    stmt.executeUpdate(sqlStatement);
                    con.close();

                } catch (SQLException error)
                {
                    System.out.println("Fail setQuantity SHOP");
                }

    }
}
