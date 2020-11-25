/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Utilisateur
 */
public class View
{
    MainPage myMainPage = new MainPage();
    
    public View()
    {
        
    }
    
    public void setVisibleMainpage()
    {
        myMainPage.setVisible(true);
    }
    
    public MainPage getMainPage()
    {
       return myMainPage; 
    }
}
