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
public class Personne
{
    private final String m_prenom;
    private final String m_nom;
    private final String m_mdp;
    private final String m_adressemail;

    public Personne(String prenom,String nom,String mdp,String adressemail)
    {
        m_prenom = prenom;
        m_nom = nom;
        m_mdp = mdp;
        m_adressemail = adressemail;
    }

    public String getMdp()
    {
        return m_mdp;
    }

    public String getAdressemail()
    {
        return m_adressemail;
    }

    public String getNom()
    {
        return m_nom;
    }

    public String getPrenom()
    {
        return m_prenom;
    }
    
    
}
