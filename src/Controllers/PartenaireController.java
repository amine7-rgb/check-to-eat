/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.RestauService;

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
    private void addevent(ActionEvent event)  throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/gui/gestion_evenement.fxml"));
        acpane.getChildren().add(p);

    }

}
     
