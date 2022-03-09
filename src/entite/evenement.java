/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class evenement {

  
     private int id;
     private Date date_debut;
     private Date date_fin;
     private String sujet;
     //private String nom_resto; //on va changer le type par restaurant l'entité de Amine 
     private int nbre_place;
     //private option o;   il peut avoir la valeur null si on veut pas avoir un plat personalisé dans notre evenement.

    public evenement() {
    }

    public evenement(int id,Date date_debut, Date date_fin, String sujet, int nbre_place) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.sujet = sujet;
//        this.nom_resto = nom_resto;
        this.nbre_place = nbre_place;
    
    }

    public evenement(Date date_debut, Date date_fin, String sujet, int nbre_place) {
        
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.sujet = sujet;
//        this.nom_resto = nom_resto;
        this.nbre_place = nbre_place;
    
    }

    public evenement(java.util.Date date_debut, java.util.Date date_fin, String sujet, int nbre_place) {
        this.date_debut= (Date) date_debut;
        this.date_fin = (Date) date_fin;
        this.sujet = sujet;
//        this.nom_resto = nom_resto;
        this.nbre_place = nbre_place;
    }

    public evenement(int id) {
        this.id = id;
    }

    public evenement(LocalDate value, LocalDate value0, String toString, String toString0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getSujet() {
        return sujet;
    }


    public int getNbre_place() {
        return nbre_place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setNbre_place(int nbre_place) {
        this.nbre_place = nbre_place;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", date de debut=" + date_debut + ", date de fin=" + date_fin + 
                "sujet=" + sujet + ", nbre de place=" + nbre_place + '}';
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
        final evenement other = (evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
