/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
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
    
      String req = "insert into partenaire (nom,datef,local,image,descr) values (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getDatef());
            pst.setString(3, r.getLocal());
            pst.setString(4, r.getImage());
            pst.setString(5, r.getDescr());
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

    @Override
    public void update(Restau r) {
      
     
 String a = "h";
 String pnom =r.getNom();
 String pp ="hh"; 
 String uu ="loc";
 String ss ="taa";    
     
    String req = "update partenaire SET datef=?,local=?,image=?,descr=? WHERE nom=?";
   
      try {
          
            pst = conn.prepareStatement(req);
            pst.setString(1, a);            
            pst.setString(2, pp);
            pst.setString(3, uu);
            pst.setString(4, ss);
            pst.setString(5, pnom);
            
           //   pst.setInt(3,i);
           int rowsDeleted = pst.executeUpdate();
           
           
            if (rowsDeleted > 0) {
            System.out.println("A user was updated successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Restau> read() {
        
                String req="select * from partenaire";
                    List<Restau> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Restau(rs.getInt("id"), rs.getString("nom"), rs.getString("datef"), rs.getString("local"), rs.getString("image"), rs.getString("descr")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }

    @Override
    public List<Restau> readByNom() {
        
         String req="select * from partenaire  ORDER BY nom ASC";
                    List<Restau> list1=new ArrayList<>();
         try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list1.add(new Restau(rs.getInt("id"), rs.getString("nom"), rs.getString("datef"), rs.getString("local"), rs.getString("image"), rs.getString("descr")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list1;
        
        
    }

    
    
}
