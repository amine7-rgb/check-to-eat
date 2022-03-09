/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entite.option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Datasource;

/**
 *
 * @author HP
 */
public class optionService {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
     public optionService() {
        conn = Datasource.getInstance().getCnx();
    }

    public void insert(option o) {
        
        String req = "insert into option (nom,prix) values (?,?)";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserOptionPst(option o) {
        
        String req = "insert into option (nom,prix) values (?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1,o.getNom());
            pst.setDouble(2,o.getPrix());
            pst.executeUpdate();

            } catch (SQLException ex) {
            Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int code) {
        
        try {
           PreparedStatement pt =conn.prepareStatement("delete from option where code =?");
            pt.setInt(1,code);
            pt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    public void update(int code , String n ,double p){
        {
    String req = "UPDATE `option` SET `nom`=?,`prix`=? WHERE `code`=?";
   
      try {
          
            pst = conn.prepareStatement(req);
            pst.setString(1,n);
            pst.setDouble(2,p);
            pst.setInt(3,code);
           pst.execute();   
        } catch (SQLException ex) {
            Logger.getLogger(evenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public List<option> read() {
        
        String req="select * from option";
        
        List<option> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new option(rs.getInt("code"), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    public option  readById(option o,int code) {
      
        String req="select * from option WHERE code= '"+ o.getCode() +"'";

        option op=null;
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                op=new option(rs.getInt("code"), rs.getString(2), rs.getDouble(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return op;
    }

        public List<option> RechercheCommandei(int code) {
         List<option> listE = new ArrayList<>();
        try {
            option o = new option();
            Statement st = conn.createStatement();
            String requete = "SELECT * FROM commande WHERE id = '"+code+"'";
            System.out.println("Commande trouvee!");
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {   
           listE.add(new option(rs.getInt("code"), rs.getString(2), rs.getDouble(3)));
            }
            System.out.println(listE); 
        } catch (SQLException ex) {
             Logger.getLogger(optionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listE;
    }
}
