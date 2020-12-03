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
    Frame frame = new Frame();
    
    public View()
    {
        
    }
    
    public void setVisibleFrame()
    {
        frame.setVisible(true);
    }
    
    public Frame getFrame()
    {
       return frame; 
    }
}
