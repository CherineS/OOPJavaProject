/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import View.*;
import Controller.*;
import java.math.RoundingMode;

import java.sql.*;
import java.text.DecimalFormat;
import javax.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.ArrayList;

import projetinfo.TablesDAO;
import projetinfo.OrdersDAO;
import projetinfo.PeopleDAO;
import projetinfo.ProductDAO;
import projetinfo.Orders;
import projetinfo.People;
import projetinfo.Product;

        
public class ProjetInfo
{
    public static void main(String[] args) 
    {    
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
    }
}