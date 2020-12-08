/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
        
/**
 *
 * Main who calls the controller and add buttons to click on them and to use 
 */
public class Main
{
    public static void main(String[] args) 
    {
       Controller myController = new Controller();
       myController.addAllButtons();
    }
}