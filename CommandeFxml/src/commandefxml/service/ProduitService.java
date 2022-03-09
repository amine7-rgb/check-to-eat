/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.service;
import commandefxml.entities.*;
import commandefxml.utils.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class ProduitService implements Iservicepr<Produit>{
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
  
    private ResultSet rs;

    public ProduitService() {
           conn=Datasource.getInstance().getCnx();
    }
    
    
    @Override
    public void insert(Produit t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Produit t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> read() {
        String req="select * from menu";
                    List<Produit> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Produit(rs.getInt("id"), rs.getString("Nom"), rs.getDouble("prix"), rs.getInt("categorie_id")
                        , "", rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Panierservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void updateperIds(int value1, double value2, int value3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produit readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
