/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_cruds;

import entite.Commande;
import java.sql.*;
import entite.Panier;
import service.Panierservice;
import service.Commandeservice;
import utils.Datasource;
import java.util.Date;

/**
 *
 * @author User
 */
public class Gestion_cruds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  


    Date r = new Date(2000, 11, 19) ;
  

     Panier p1=new Panier(52,"ooohh",615,99);
    Panierservice pst=new Panierservice();
    pst.delete(p1);
//   pst.insert(p1);
    /*    pst.insert(p1);
            pst.insert(p1);
                pst.insert(p1);
                    pst.insert(p1);*/
    
       Panier p3=new Panier(22,"xxxhh",65,70);
    Panierservice psi=new Panierservice();    
  // psi.delete(p3);
  //  psi.update( p3);
    
    
     Commande p7;
        p7 = new Commande("oophh","2000-12-15");
    Commandeservice psu=new Commandeservice();
    psu.insert(p7);
    Commande   p23 = new Commande(6,"xxxhh","1999-22-15");
    Commandeservice psr=new Commandeservice();
   // psr.delete(p23);
   // psr.insert(p23);
     Commande  p10 = new Commande(6,"xpphh","2100-10-15");
    Commandeservice pso=new Commandeservice();
    //pso.delete(p10);
   // pso.update( p10);
   // pso.insert(p10);
    }
    
}
