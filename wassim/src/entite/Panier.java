/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author User
 */
public class Panier {
  
    private int id;
    private String titre;
    private int quantite;
    private int prix;

    public Panier(int id, String titre, int quantite, int prix) {
        this.id = id;
        this.titre = titre;
        this.quantite = quantite;
        this.prix = prix;
    }
    public Panier(String titre, int quantite, int prix) {
        
        this.titre = titre;
        this.quantite = quantite;
        this.prix = prix;
    }
    

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "panier{" + "id=" + id + ", titre=" + titre + ", quantite=" + quantite + ", prix=" + prix + '}';
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
        final Panier other = (Panier) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    }  

