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
      //System.out.println(ds2);

        //Restau p1=new Restau("mm","a","a","a","a"); 
        
       // RestauService ps=new RestauService();
     // ps.insert(p1);
      // ps.delete(p1);
     
     //  ps.update(p1);
       
       //System.out.println(ps.read());
          //ps.rechercher(p1,"amine") ;
      //   System.out.println(ps.readByNom());
       
      
      
      
      
      
      
      
      
      
       Categorie c1 =new Categorie("aa");  
       CatService cs = new CatService();
        //cs.insert(c1);
    //    cs.delete(c1);
        cs.updateid(c1);
    
       // cs.update(c1);
        // cs.supprimer(5);
         System.out.println(cs.read());
        
        System.out.println(cs.ChercherCentreParType("amine"));
     
        
        
    }
    
}
