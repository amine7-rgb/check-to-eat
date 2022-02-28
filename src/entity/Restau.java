/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author amed1
 */
public class Restau {
    
    private int id;
    private String nom;
    private String datef;
    private String local;
    private String image;
    private String descr;
//    private Categorie id_cat ; 
    //categorie 
    private int id_cat;

    public Restau(int id, String nom, String datef, String local, String image, String descr,int id_cat) {  /*Categorie id_cat*/
        this.id = id;
        this.nom = nom;
        this.datef = datef;
        this.local = local;
        this.image = image;
        this.descr = descr;
        this.id_cat=id_cat;
    }
    
    
    public Restau(int id, String nom, String datef, String local, String image, String descr) {
        this.id = id;
        this.nom = nom;
        this.datef = datef;
        this.local = local;
        this.image = image;
        this.descr = descr;

    }
  
    
    public Restau(String nom, String datef, String local, String image, String descr,int id_cat) { /*Categorie id_cat*/
    
        this.nom = nom;
        this.datef = datef;
        this.local = local;
        this.image = image;
        this.descr = descr;
        this.id_cat=id_cat;
    }
    
    public Restau(String nom, String datef, String local, String image, String descr) {
    
        this.nom = nom;
        this.datef = datef;
        this.local = local;
        this.image = image;
        this.descr = descr;
     
    }

    public Restau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

   /* public Categorie getcat() {
        return id_cat;
    }
*/
    
      public int getcat() {
        return id_cat;
    }
    
    
    @Override
    public String toString() {
        return "Restau{" + "id=" + id + ", nom=" + nom + ", datef=" + datef + ", local=" + local + ", image=" + image + ", descr=" + descr + ", id_cat=" + id_cat + '}';
    }
/*
    public void setId_cat(Categorie id_cat) {
        this.id_cat = id_cat;
    }
*/
    
    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Restau other = (Restau) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_cat != other.id_cat) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.datef, other.datef)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.descr, other.descr)) {
            return false;
        }
        return true;
    }


    
    
    
    
}
