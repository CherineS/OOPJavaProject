/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;

/**
 *
 * @author Gaëtan
 */
public class OrdersDAO extends TablesDAO
{
    private final ArrayList<Orders> myOrders = new ArrayList<>();
    private final ArrayList<Product> myProductSearch = new ArrayList<>();

    public boolean AddShop(JTextField quantity, String email, int productNo)
    {
        String inputDate = getDate();
        Product myProduct = null;
        Date date = null;
        boolean result = false;
        int OrderNo = 0, condition = 0;
        int quantityInt = Integer.parseInt(quantity.getText());

        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
        } catch (ParseException ex)
        {
            System.out.println("Error AddShop OrdersDAO date");
        }

        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM product");
            Statement stmt2 = con.createStatement();

            while (res.next())
            {
                if (productNo == res.getInt("productNo"))
                {
                    if (quantityInt > res.getInt("quantity"))
                        quantityInt = res.getInt("quantity");

                    int quantitySQL = res.getInt("quantity") - quantityInt;
                    myProduct = new Product(productNo, res.getString("name"), res.getDouble("price"), quantityInt,
                            res.getInt("minimumPromotion"), res.getDouble("valuePromotion"), res.getString("lienURL"), res.getString("description"));

                    stmt2.executeUpdate("UPDATE product " + "SET quantity = " + quantitySQL + " WHERE productNo = " + productNo);
                    result = true;
                }
            }
        } catch (SQLException error)
        {
            System.out.println("Error AddShop OrdersDAO (product)");
        }
        closeConnection();

        if (myProduct != null)
        {
            double price;
            if(myProduct.getminimumPromotion()!=0)
            {
                price = (myProduct.getQuantity() / myProduct.getminimumPromotion())
                    * (myProduct.getPrice() * (1 - (myProduct.getValuePromotion() * 0.01))) * myProduct.getminimumPromotion()
                    + (myProduct.getQuantity() % myProduct.getminimumPromotion()) * (myProduct.getPrice());
            }
            else 
                price = (myProduct.getQuantity()*myProduct.getPrice());

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);
            String stringPrice = df.format(price);

            char[] myPrice = stringPrice.toCharArray();
            for (int j = 0; j < myPrice.length; j++)
                if (myPrice[j] == ',')
                    myPrice[j] = '.';

            price = Double.parseDouble(String.copyValueOf(myPrice));
            Orders Order = new Orders(OrderNo, date, myProduct, price, email);

            if (result == true)
            {
                for (int i = 0; i < myOrders.size(); i++) // Si déjà un produit, augmente quantité simplement, n'en créer pas un autre
                    if (Order.getProducts().getProductNo() == myOrders.get(i).getProducts().getProductNo())
                    {
                        myOrders.get(i).getProducts().setQuantity((quantityInt + myOrders.get(i).getProducts().getQuantity()));
                        myOrders.get(i).setPrice(myOrders.get(i).getPrice() + price);
                            if(myOrders.get(i).getProducts().getQuantity()>=myOrders.get(i).getProducts().getminimumPromotion()&&myOrders.get(i).getProducts().getValuePromotion()!=0)
                            {
                                myOrders.get(i).setPrice(myOrders.get(i).getProducts().getQuantity()/ myOrders.get(i).getProducts().getminimumPromotion()
                                * (myOrders.get(i).getProducts().getPrice() * (1 - (myOrders.get(i).getProducts().getValuePromotion() * 0.01))) * myOrders.get(i).getProducts().getminimumPromotion()
                                + (myOrders.get(i).getProducts().getQuantity() % myOrders.get(i).getProducts().getminimumPromotion()) * (myOrders.get(i).getProducts().getPrice()));
                            }
                            
                        condition++;
                    }

                if (condition == 0)
                    myOrders.add(Order);
            }
        }

        return result;
    }

    public void deleteShop(int productNo)
    {
        getConnection();

        for (int i = 0; i < myOrders.size(); i++)
            if (productNo == myOrders.get(i).getProducts().getProductNo())
            {
                try
                {
                    ResultSet res = stmt.executeQuery("SELECT* FROM product");
                    Statement stmt2 = con.createStatement();

                    while (res.next())
                    {
                        if (productNo == res.getInt("productNo"))
                        {
                            int quantitySQL = res.getInt("quantity") + myOrders.get(i).getProducts().getQuantity();
                            stmt2.executeUpdate("UPDATE product " + "SET quantity = " + quantitySQL + " WHERE productNo = " + productNo);
                        }
                    }
                } catch (SQLException error)
                {
                    System.out.println("Error deleteShop OrdersDAO");
                }

                myOrders.remove(i);
            }

        closeConnection();
    }

    public void addOrders()
    {
        int numberOrder = OrderNoMax();
        getConnection();

        for (int i = 0; i < myOrders.size(); i++)
        {

            String orderProductNo = "" + numberOrder + "-" + myOrders.get(i).getProducts().getProductNo();
            java.sql.Date dateSQL = new java.sql.Date(myOrders.get(i).getDate().getTime());

            try
            {
                stmt.execute("INSERT INTO orders " + "(orderProductNo, orderNo, productNo, email, quantity, price, date)"
                        + " VALUES "
                        + "('" + orderProductNo + "','" + numberOrder + "','" + myOrders.get(i).getProducts().getProductNo()
                        + "','" + myOrders.get(i).getEmail() + "','" + myOrders.get(i).getProducts().getQuantity() + "', '"
                        + myOrders.get(i).getPrice() + "','" + dateSQL + "')");
            } catch (SQLException error)
            {
                System.out.println("Error addOrders OrdersDAO");
            }
        }
        closeConnection();
        myOrders.clear();
        myProductSearch.clear();
    }

    public int OrderNoMax()
    {
        getConnection();
        ArrayList<Integer> myOrdersTest = new ArrayList<>();
        int result = 0;
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM orders");
            while (res.next())
            {
                myOrdersTest.add(res.getInt("orderNo"));
            }
        } catch (SQLException error)
        {
            System.out.println("Error AddShop OrdersDAO (orders)");
        }

        if (!myOrdersTest.isEmpty())
            result = Collections.max(myOrdersTest) + 1;

        closeConnection();
        return result;
    }

    public ArrayList<Orders> getOrders()
    {
        return myOrders;
    }

    public ArrayList<Integer> getOnTrend(ArrayList<Integer> products)
    {
        getConnection();

        try
        {
            String sqlStatement = "SELECT* FROM orders";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                products.set(Integer.parseInt(res.getString("productNo")), Integer.parseInt(res.getString("quantity")) + products.get(Integer.parseInt(res.getString("productNo"))));
            }

        } catch (SQLException error)
        {
            System.out.println("Error searchElement ProductDAO");
        }

        closeConnection();

        return products;
    }

    public ArrayList<Orders> getPastOrders(int number)
    {
        ArrayList<Orders> pastOrders = new ArrayList<>();
        getConnection();

        try
        {
            String sqlStatement = "SELECT* FROM orders WHERE orderNo ='" + number + "' ";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                Product myProduct = new Product(res.getInt("productNo"), "N/A", 0, 0, 0, 0, null, null);
                Orders myOrd = new Orders(res.getInt("orderNo"), res.getDate("date"), myProduct, res.getDouble("price"), res.getString("email"));
                pastOrders.add(myOrd);
            }

        } catch (SQLException error)
        {
            System.out.println("Error searchElement ProductDAO");
        }

        closeConnection();
        return pastOrders;
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

    public int findQuantity(String orderProdNo)
    {
        int quantity = 0;
        getConnection();
        try
        {
            String sqlStatement = "SELECT quantity FROM orders WHERE orderProductNo ='" + orderProdNo + "' ";
            ResultSet res = stmt.executeQuery(sqlStatement);

            while (res.next())
            {
                quantity = res.getInt("quantity");
            }

        } catch (SQLException error)
        {
            System.out.println("Error searchElement ProductDAO");
        }
        closeConnection();
        return quantity;
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

    public ArrayList<Orders> searchOrder(String email)
    {
        ArrayList<Orders> myOrdersSearch = new ArrayList<>();

        getConnection();
        try
        {
            ResultSet res = stmt.executeQuery("SELECT* FROM orders");

            while (res.next())
            {
                if (email.equals(res.getString("email")))
                {
                    java.util.Date dateJAVA = new java.util.Date(res.getDate("date").getTime());
                    int productNo = res.getInt("productNo");
                    int quantity = res.getInt("quantity");
                    int orderNo = res.getInt("orderNo");
                    double price = res.getDouble("price");

                    Product product = null;

                    try
                    {
                        Statement stmt2 = con.createStatement();
                        ResultSet result = stmt2.executeQuery("SELECT* FROM product");

                        while (result.next())
                        {
                            if (productNo == result.getInt("productNo"))
                                product = new Product(result.getInt("productNo"), result.getString("name"), result.getDouble("price"),
                                        quantity, result.getInt("minimumPromotion"), result.getDouble("valuePromotion"), result.getString("lienURL"), result.getString("description"));
                        }
                    } catch (SQLException error)
                    {
                        System.out.println("Error searchOrder OrdersDAO (Product)");
                    }

                    Orders order = new Orders(orderNo, dateJAVA, product, price, email);
                    myOrdersSearch.add(order);
                }
            }
        } catch (SQLException error)
        {
            System.out.println("Error searchOrder OrdersDAO (Orders)");
        }
        closeConnection();

        return myOrdersSearch;
    }
}
