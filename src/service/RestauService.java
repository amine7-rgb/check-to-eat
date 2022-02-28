/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Categorie;
import entity.Restau;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Datasource;
import java.lang.String;
import java.util.*;

/**
 *
 * @author amed1
 */
public class RestauService implements IService<Restau>{
    
    
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public RestauService() {
        conn = Datasource.getInstance().getCnx();
    }

  
    @Override
    public void insert(Restau r) {
        
     
        
      String req = "insert into partenaire (nom,datef,local,image,descr,id_cat) values (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getDatef());
            pst.setString(3, r.getLocal());
            pst.setString(4, r.getImage());
            pst.setString(5, r.getDescr());
            pst.setInt(6, r.getcat());
//          pst.setObject(6, r.getcat().getId());
         
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    @Override
    public void delete(Restau r) {
       
        
          String req = "delete from partenaire where nom=?";
         try {
            pst = conn.prepareStatement(req);
            pst.setString(1, r.getNom());
           int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
    System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    @Override
    public void update(Restau r) {
      
     

 String pnom =r.getNom(); 
   
     
    String req = "update partenaire SET datef=?,local=?,image=?,descr=?,id_cat=? WHERE nom=?";
   
      try {
          
            pst = conn.prepareStatement(req);
            pst.setString(1, r.getDatef());            
            pst.setString(2, r.getLocal());
            pst.setString(3, r.getImage());
            pst.setString(4, r.getDescr());

          //  pst.setInt(5, r.getId_cat());
            pst.setString(6, pnom);            
           //   pst.setInt(3,i);
           int rowsDeleted = pst.executeUpdate();
           
           
            if (rowsDeleted > 0) {
            System.out.println("A user was updated successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/
    @Override
    public List<Restau> read() {
        
                String req="select * from partenaire";
                    List<Restau> list=new ArrayList<>();
                 //   Restau r = new Restau();
                   // int a =r.getcat().getId();
                   // CatService ca = new CatService();
                   // Categorie m =new Categorie();
                    
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
             list.add(new Restau(rs.getInt("id"), rs.getString("nom"), rs.getString("datef"), rs.getString("local"), rs.getString("image"), rs.getString("descr"),rs.getInt("id_cat")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
/*
    @Override
    public List<Restau> readByNom() {
        
         String req="select * from partenaire  ORDER BY nom ASC";
                    List<Restau> list1=new ArrayList<>();
         try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list1.add(new Restau(rs.getInt("id"), rs.getString("nom"), rs.getString("datef"), rs.getString("local"), rs.getString("image"), rs.getString("descr"),rs.getInt("id_cat")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list1;
        
        
    }
    
    
    
    
    
    
    
    
    public Restau ChercherCentreParNom(String nom) {
        List<Restau> l = this.read();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getNom().equals(nom)) {
                return l.get(i);
            }
        }
        return null;
    }

    @Override
    public void insert(Restau t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    */


    
    @Override
    public void update(Restau t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public List<Restau> readByNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
