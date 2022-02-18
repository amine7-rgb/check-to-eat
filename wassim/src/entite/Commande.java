/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author User
 */
public class Commande {
     private int id;
    private String titre;
    private String date_de_commande;

    public Commande(int id, String titre, String date_de_commande) {
        this.id = id;
        this.titre = titre;
        this.date_de_commande = date_de_commande;
    }

    public Commande(String titre, String date_de_commande) {
        this.titre = titre;
        this.date_de_commande = date_de_commande;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDate_de_commande() {
        return date_de_commande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate_de_commande(String date_de_commande) {
        this.date_de_commande = date_de_commande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", titre=" + titre + ", date_de_commande=" + date_de_commande + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    }


    
    
    
