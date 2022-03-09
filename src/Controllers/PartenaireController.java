/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author GhAlone
 */
public class PartenaireController {
    @FXML
    private Pane acpane;
    @FXML
    private BorderPane Bpadmin;
    @FXML
    private Button gererPro;
    @FXML
    private Button gererRes;
    @FXML
    private Button GererPub;
    @FXML
    private Button GererCat;
    @FXML
    private Label l;

    
    
    @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/profilePar.fxml"));
        acpane.getChildren().add(p);

    }

    @FXML
    private void addR(ActionEvent event)  throws IOException {
         Pane p = FXMLLoader.load(getClass().getResource("/gui/partenaire.fxml"));
        acpane.getChildren().add(p);
        
    }

    @FXML
    private void evente(ActionEvent event)  throws IOException{
          Pane p = FXMLLoader.load(getClass().getResource("/gui/partenaire.fxml"));
        acpane.getChildren().add(p);
        
    }

    }

