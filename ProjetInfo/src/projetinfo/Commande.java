/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;
import java.util.ArrayList;
/**
 *
 * @author antoi
 */
public class Commande
{
    private int m_numcommande;
    private String m_date;
    private ArrayList<Produit> m_produits;
    
   public Commande(int numcommande,String date, ArrayList<Produit> produits)
   {
       m_numcommande = numcommande;
       m_date = date;
       m_produits = produits;
   }
}
