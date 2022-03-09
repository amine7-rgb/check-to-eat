/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.option;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.optionService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SuppoptionController implements Initializable {


    @FXML
    private Button btnsupprim;
    
    private optionService optionService;
    @FXML
    private Label tfcode;
    @FXML
    private TextField tfcode1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.optionService = new optionService();
    }    

    @FXML
    private void onSupprim(ActionEvent event) {
        int code = Integer.parseInt(tfcode1.getText());
       
        //option o = new option(code);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
        try {
            optionService.delete(code);
        Parent root = loader.load();
        Option1Controller controller = loader.getController();
        tfcode.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
