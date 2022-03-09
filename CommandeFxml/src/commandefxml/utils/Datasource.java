/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.utils;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class Datasource {
    
 private String url="jdbc:mysql://localhost:3306/gestion_commande";
    private String login="root";
    private String pwd=""; 
    
    private static Connection cnx;
    private static Datasource instance;
    private Datasource(){
          try {
              cnx=DriverManager.getConnection(url, login, pwd);
          } catch (SQLException ex) {
              Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
          }

    }
    public static Datasource getInstance(){
        if(instance==null)
            instance=new Datasource();
        return instance; 
    }

    public static Connection getCnx() {
        return cnx;
    }
    
}