/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author GhAlone
 */
public class PartenaireController implements Initializable{
    @FXML
    private Pane acpane;
    @FXML
    private AnchorPane contentArea;


    
        
    
    @FXML
    void changeUser(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/Interfaces/profilePar.fxml"));
        contentArea.getChildren().removeAll();
        acpane.getChildren().setAll(p);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }
}
