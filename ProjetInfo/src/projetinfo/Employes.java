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
public class Employes extends Personne
{
    
    public Employes(String prenom, String nom, String mdp, String adressemail)
    {
        super(prenom, nom, mdp, adressemail);
    }
    
    public void AjoutProduit(Produit nouveau,Shop shop)
    {
        ArrayList<Produit> analyse;
        analyse = shop.getReserve();
        if(shop.getReserve().contains(nouveau))
      {
        for(int i=0;i<shop.getReserve().size();i++)
        {
          //analyse.get(i) = nouveau;
        }
      }
      else{shop.getReserve().add(nouveau);}
    }
    public void EnleverProduit(Produit enlever,Shop shop)
    {
     
    }
    public void ModifierPrix()
    {
        
    }
    
    public void AjouterPromo()
    {
        
    }
    public void EnleverPromo()
    {
        
    }
    
}
