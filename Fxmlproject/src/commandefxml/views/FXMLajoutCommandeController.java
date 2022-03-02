/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.views;

import commandefxml.entities.Commande;
import commandefxml.service.Commandeservice;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLajoutCommandeController implements Initializable {
    
    @FXML
    public TextField titreField;
    
    @FXML
    public TextField dateField;
    
    @FXML
    public TextField panierFKField;
    
    @FXML 
    public Button ajoutButton;
    
    @FXML 
    public Button next;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML 
    public void ajouterCommande(ActionEvent event)throws  IOException{
        Commande c = new Commande();
        c.setTitre(titreField.getText());
        c.setDate_de_commande(dateField.getText());
        c.setPanierFK(Integer.parseInt(panierFKField.getText()));
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        c.setListe_de_produits(list);
        Commandeservice cs = new Commandeservice();
        cs.insert(c);
        System.out.println("commande ajouté");
    }
    
    
}
