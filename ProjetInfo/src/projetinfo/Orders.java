/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author antoi
 */
public class Orders
{
    private int m_orderNumber;
    private Date m_date;
    private ArrayList <Product> m_products;
    
   public Orders(int orderNumber,Date date, ArrayList <Product> products)
   {
       m_orderNumber = orderNumber;
       m_date = date;
       m_products = products;
   }
   
}