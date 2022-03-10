/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.option;
//import gui.affiche_optionController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.optionService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutOptionController implements Initializable {

    @FXML
    private TextField textFieldCode;
    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldPrix;

    private optionService optionService;
    @FXML
    private Button btnSubmit;
    /**
     * Initializes the controller class. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.optionService = new optionService();
    }    

   

    @FXML
    private void onAjout(ActionEvent event) {
                int code = Integer.parseInt(textFieldCode.getText());
        String nom = textFieldNom.getText();
        Double prix = Double.parseDouble( textFieldPrix.getText());
        option o = new option(nom,prix);
        optionService.inserOptionPst(o);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
        try {
            Parent root = loader.load();
            Option1Controller controller = loader.getController();
//            controller.settFCode(code+"");
//            controller.settFNom(nom);
//            controller.settFPrix(prix+"");
////            
            textFieldCode.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    
    }

}
