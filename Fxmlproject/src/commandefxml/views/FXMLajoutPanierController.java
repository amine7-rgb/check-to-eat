/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.views;

import commandefxml.entities.Commande;
import commandefxml.entities.Panier;
import commandefxml.service.Commandeservice;
import commandefxml.service.Panierservice;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLajoutPanierController implements Initializable {
    
    @FXML
    public TextField prixField;
    
    @FXML
    public TextField clientidField;
    
    @FXML 
    public Button ajouterPanier;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML 
    public void ajouterPanier(ActionEvent event)throws  IOException{
        Panier c = new Panier();
        c.setPrix(Double.parseDouble(prixField.getText()));
        c.setClientid(Integer.parseInt(clientidField.getText()));
        Panierservice cs = new Panierservice();
        
        cs.insert(c);
        System.out.println("panier ajouté");
    }
    
}
