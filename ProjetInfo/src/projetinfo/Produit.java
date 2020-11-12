/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetinfo;

/**
 *
 * @author antoi
 */
public class Produit
{
    private String m_nom;
    private double m_prix;
    private int m_quantite;
    private int m_promo;
    
    public Produit(String nom,double prix, int quantite,int promo)
    {
        m_nom = nom;
        m_prix = prix;
        m_quantite = quantite;
        m_promo = promo;
    }

    public void setNom(String m_nom)
    {
        this.m_nom = m_nom;
    }

    public void setPrix(double m_prix)
    {
        this.m_prix = m_prix;
    }

    public void setPromo(int m_promo)
    {
        this.m_promo = m_promo;
    }

    public void setQuantite(int m_quantite)
    {
        this.m_quantite = m_quantite;
    }
    
}
