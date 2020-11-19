/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gaëtan
 */
public class OrdersDAO extends TablesDAO
{
    private ArrayList<Orders> myOrders = new ArrayList<>();
    private ArrayList<Product> myProductSearch = new ArrayList<>();

    public void AddShop(JTextField quantity, JTextField email, JTextField productNumber)
    {
        String inputQuantity = quantity.getText();
        String inputEmail = email.getText();
        String inputProductNumber = productNumber.getText();
        String inputDate = getDate();
        Product myProduct = null;
        Date date = null;
        int OrderNo = 0, condition = 0;
        int quantityInt = Integer.parseInt(inputQuantity);
        int productNo = Integer.parseInt(inputProductNumber);

        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
        } catch (ParseException ex)
        {
            System.out.println("Error AddShop OdersDAO date");
        }

        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM product");
            while (res.next())
            {
                if (productNo == res.getInt("productNo"))
                    myProduct = new Product(productNo, res.getString("name"), res.getDouble("price"), quantityInt,
                            res.getInt("minimumPromotion"), res.getDouble("valuePromotion"));
            }
        } catch (SQLException error)
        {
            System.out.println("Error AddShop OrdersDAO (product)");
        }
        closeConnection();

        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM orders");

            while (res.next())
            {
                OrderNo = res.getInt("orderNo") + 1;
            }
        } catch (SQLException error)
        {
            System.out.println("Error AddShop OrdersDAO (orders)");
        }
        closeConnection();

        Orders Order = new Orders(OrderNo, date, myProduct, ((double) myProduct.getQuantity() * myProduct.getPrice()), inputEmail);
        for (int i = 0; i < myOrders.size(); i++)
            if (Order.getProducts().getProductNo() == myOrders.get(i).getProducts().getProductNo())
            {
                myOrders.get(i).getProducts().setQuantity((quantityInt + myOrders.get(i).getProducts().getQuantity()));
                condition++;
            }

        if (condition == 0)
            myOrders.add(Order);
    }

    public void deleteShop(JTextField productNumber)
    {
        String inputProductNumber = productNumber.getText();
        int productNo = Integer.parseInt(inputProductNumber);

        for (int i = 0; i < myOrders.size(); i++)
            if (productNo == myOrders.get(i).getProducts().getProductNo())
                myOrders.remove(i);
    }

    public void addOrders() // PRIX A VOIR
    {
        getConnection();
        
        for (int i = 0; i < myOrders.size(); i++)
        {
            double price = (myOrders.get(i).getProducts().getQuantity()/myOrders.get(i).getProducts().getminimumPromotion())
                    *(myOrders.get(i).getProducts().getPrice()-myOrders.get(i).getProducts().getValuePromotion())*myOrders.get(i).getProducts().getminimumPromotion()
                    +(myOrders.get(i).getProducts().getQuantity()%myOrders.get(i).getProducts().getminimumPromotion())*(myOrders.get(i).getProducts().getPrice());

            String orderProductNo = "" + myOrders.get(i).getOrderNumber() + "-" + myOrders.get(i).getProducts().getProductNo();
            java.sql.Date dateSQL = new java.sql.Date(myOrders.get(i).getDate().getTime());
            
            try
            {
                stmt.execute("INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)"
                        + " VALUES "
                        + "('" + orderProductNo + "','" + myOrders.get(i).getOrderNumber() + "','" + myOrders.get(i).getProducts().getProductNo() 
                        + "','" + myOrders.get(i).getEmail() + "','" + myOrders.get(i).getProducts().getQuantity() + "', '" 
                        + price + "','" + dateSQL + "')");
            } catch (SQLException error)
            {
                System.out.println("Error addOrders OrdersDAO");
            }
        }
        closeConnection();
        myOrders.clear();
        myProductSearch.clear();
    }

    @Override
    public void deleteAllElements()
    {
        getConnection();
        try
        {
            String sqlStatement = "DELETE FROM orders";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteAllElements OrdersDAO");
        }
        closeConnection();
    }

    public void deleteElement()
    {
        getConnection();
        String inputDate = getDate();
        Date date = null;
        char[] mydate = inputDate.toCharArray();
        for (int i = 0; i < mydate.length; i++)
            if (mydate[i] == '/')
                mydate[i] = ' ';

        Scanner keyboard = new Scanner(String.copyValueOf(mydate));
        int day = keyboard.nextInt();
        int month = keyboard.nextInt();
        int year = keyboard.nextInt();
        if ((month - 3) < 1)
        {
            year--;
            month = month + 9;
        } else
            month = month - 3;

        inputDate = "" + day + "/" + month + "/" + year;

        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
        } catch (ParseException ex)
        {
            System.out.println("Error deleteElement OrdersDAO date");
        }

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        try
        {
            String sqlStatement = "DELETE FROM orders where date < '" + dateSQL + "' ";
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException error)
        {
            System.out.println("Error deleteAllElements OrdersDAO");
        }

        closeConnection();
    }

    public ArrayList<Orders> searchOrder(JTextField email) // A VOIR POUR LE PRODUIT RECUP LES INFOS
    {
        ArrayList<Orders> myOrdersSearch = new ArrayList<>();
        String inputEmail = email.getText();
        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM orders");

            while (res.next())
            {
                if(inputEmail==res.getString("email"))
                {   
                   java.util.Date dateJAVA = new java.util.Date(res.getDate("date").getTime());
                   Product product = new Product(res.getInt("productNo"), res.getInt("quantity"));
                   Orders order = new Orders(res.getInt("orderNo"),dateJAVA, product, res.getDouble("price"), inputEmail);
                   myOrdersSearch.add(order);    
                }
            }
        } catch (SQLException error)
        {
            System.out.println("Error searchOrder OrdersDAO");
        }
        closeConnection();
        
        return myOrdersSearch;
    }
}
