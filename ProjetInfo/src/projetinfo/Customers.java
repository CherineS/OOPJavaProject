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
public class Customers extends Personne
{
    
    private ArrayList<Commande> m_mescommandes;
    private double m_solde;
    public Customers(String prenom, String nom, String mdp, String adressemail,double solde)
    {
        super(prenom, nom, mdp, adressemail);
        m_solde = solde;
    }
    
}
