/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpartenaire;

import entity.Categorie;
import entity.Restau;
import java.sql.*;
import service.RestauService;
import service.CatService;
import utils.Datasource;



/**
 *
 * @author amed1
 */
public class Gpartenaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
          // TODO code application logic here
      //  Datasource ds1=Datasource.getInstance();
    //   System.out.println(ds1);
        
        //Datasource ds2=Datasource.getInstance();
     // System.out.println(ds2);

       Categorie c1 =new Categorie("ammmmmmm");  
       CatService cs = new CatService();
        
      cs.insert(c1);
       System.out.println(cs.read());
      // c1=cs.readid("ammmmmmm");
       //System.out.println(c1);
       //cs.supprimer(57);
       //cs.delete(c1);
    //    System.out.println(cs.readid("a"));
      ////  System.out.println(cs.read());
       //System.out.println(c1);
       //System.out.println(cs.read());
         
       
     
      
     // Restau p1=new Restau("amine","rr","a","a","a",c1); 
      Restau p1=new Restau("amie","rr","a","a","a",65); 
      RestauService ps=new RestauService();
     ps.insert(p1);
      
      //ps.delete(p1);
     System.out.println(ps.read());
    
     
      // ps.update(p1);
     
     
          //ps.rechercher(p1,"amine") ;
      //   System.out.println(ps.readByNom());
      //  System.out.println(ps.ChercherCentreParNom("mm"));
       
      
      
      
      
      
      
      
      
      
      // Categorie c1 =new Categorie("aa");  
       //CatService cs = new CatService();
    //   cs.insert(c1);
    // cs.delete(c1);
        //cs.updateid(c1);
    
       // cs.update(c1);
        // cs.supprimer(5);
         //System.out.println(cs.read());
        
        //System.out.println(cs.ChercherCentreParType("amine"));
     
        
        
    }
}
