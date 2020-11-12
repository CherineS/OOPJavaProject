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
public class Shop
{
    private ArrayList<Produit> m_reserve;
    private ArrayList<Personne> m_personne;
    
    public Shop(ArrayList<Produit> reserve,ArrayList<Personne> personne)
    {
        m_personne = personne;
        m_reserve = reserve;
    }

    public ArrayList<Personne> getPersonne()
    {
        return m_personne;
    }

    public ArrayList<Produit> getReserve()
    {
        return m_reserve;
    }
    
    
}
