/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author GhAlone
 */
public class Utilisateur {
    private int id ; 
    private String nom ;
    private String prenom ;
    private int num_tel ;
    private String mot_pass ;
    private String genre ;
    private String adress_email ;
    private String role ;
    private String image ; 

    public Utilisateur(int id, String mot_pass, String adress_email) {
        this.id = id;
        this.mot_pass = mot_pass;
        this.adress_email = adress_email;
    }


    public Utilisateur(int id) {
        this.id = id;
    }



    public Utilisateur(String mot_pass, String adress_email, String role) {
        this.mot_pass = mot_pass;
        this.adress_email = adress_email;
        this.role = role;
    }

   

    
    
    public Utilisateur(String nom, String prenom, int num_tel, String mot_pass, String genre, String adress_email, String role, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.mot_pass = mot_pass;
        this.genre = genre;
        this.adress_email = adress_email;
        this.role = role;
        this.image = image;
    }

    public Utilisateur(int id, String nom, String prenom, int num_tel, String mot_pass, String genre, String adress_email, String role, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.mot_pass = mot_pass;
        this.genre = genre;
        this.adress_email = adress_email;
        this.role = role;
        this.image = image;
    }

    public Utilisateur(String text, String text0, String text1, String text2, String hashPassword, String toString) {
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

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getMot_pass() {
        return mot_pass;
    }

    public void setMot_pass(String mot_pass) {
        this.mot_pass = mot_pass;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdress_email() {
        return adress_email;
    }

    public void setAdress_email(String adress_email) {
        this.adress_email = adress_email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + ", mot_pass=" + mot_pass + ", genre=" + genre + ", adress_email=" + adress_email + ", role=" + role + ", image=" + image + '}';
    }
    
    
    
}
