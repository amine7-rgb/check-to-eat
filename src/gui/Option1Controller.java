/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.evenement;
import entite.option;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.optionService;
import utils.Datasource;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Option1Controller implements Initializable {

    @FXML
    private Label tfNom;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnmodifier;

    private optionService optionService;
    @FXML
    private TableColumn<option, Integer> tfcode;
    @FXML
    private TableColumn<option, String> tfnom;
    @FXML
    private TableColumn<option, Double> tfprix;
    @FXML
    private TableView<option> aff_option;
    @FXML
    private TextField tfcode1;
    @FXML
    private TextField tfnom1;
    @FXML
    private TextField tfprix1;
    int index = -1;
    private Connection conn= Datasource.getInstance().getCnx();;
    @FXML
    private Button retour;
    @FXML
    private Label tfchercher;
    @FXML
    private TextField tfrechercher;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.optionService = new optionService();
        afficher();
        Update();
        rechercher();
    }    
    public void afficher(){

        ObservableList optionListe = FXCollections.observableList(optionService.read());

        tfcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tfnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tfprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        aff_option.setItems(optionListe);      
    }
    public void clear(){
        tfcode1.clear();
        tfnom1.clear();
        tfprix1.clear();   
    }
    @FXML
    private void onClick1(ActionEvent event) {
        int id = Integer.parseInt(tfcode1.getText());
        String nom = tfnom1.getText();
        Double prix = Double.parseDouble(tfprix1.getText());
        option o = new option(id,nom,prix);
        optionService.inserOptionPst(o);
        afficher();
        clear();
    }

    @FXML
    private void onClick2(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("suppoption.fxml"));
            try {
            Parent root = loader.load();
            SuppoptionController controller = loader.getController();
            tfNom.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onClick3(ActionEvent event) {
        String l = tfnom1.getText();
        double m = Double.parseDouble(tfprix1.getText());
        int o= Integer.parseInt(tfcode1.getText());
        optionService.update(o,l,m);
        afficher(); 
        clear();
}
 
    @FXML
    private void getSelected(MouseEvent event) {
    index = aff_option.getSelectionModel().getSelectedIndex();
        if (index<= -1){
            return;
        }
        tfcode1.setPromptText(String.valueOf(tfcode.getCellData(index).toString()));
        tfnom1.setPromptText(String.valueOf(tfnom.getCellData(index).toString()));
        tfprix1.setPromptText(tfprix.getCellData(index).toString());      
        afficher();
        clear();
    }
    
    public void Update(){
        ObservableList optionListe = FXCollections.observableList(optionService.read());

        tfcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tfnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tfprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        
        
        aff_option.setItems(optionListe);
    }

    @FXML
    private void retour(ActionEvent event) {
    try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("gestion_evenement.fxml"));
            Parent root = loader.load();
            Gestion_evenementController controller = loader.getController();
            tfnom1.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    public void rechercher() {
        ObservableList<option> dataListe = FXCollections.observableList(optionService.read());
        
        tfcode.setCellValueFactory(new PropertyValueFactory<option,Integer>("code"));
        tfnom.setCellValueFactory(new PropertyValueFactory<option,String>("nom"));
        tfprix.setCellValueFactory(new PropertyValueFactory<option,Double>("prix"));
  
        aff_option.setItems(dataListe);
  
        FilteredList<option> filterData = new FilteredList<>(dataListe, b-> true);
        TextField filterInput = new TextField();
        filterInput.textProperty().addListener((Observable, olValue, newValue)->{
                filterData.setPredicate(evenement->{
                    if (newValue== null || newValue.isEmpty()){
                        return true;
                }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (evenement.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else
                        return false;
                    
    });
                });
            SortedList<option> sortedData = new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(aff_option.comparatorProperty());
            aff_option.setItems(sortedData);
            
            afficher();
            clear();
        
     }
}
