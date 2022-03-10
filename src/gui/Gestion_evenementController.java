///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui;
//
////import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
////import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
////import javafx.scene.control.TableColumn.CellDataFeatures;
//import entite.evenement;
//import entite.option;
////import java.io.FilterReader;
//import java.io.IOException;
////import java.net.Authenticator;
////import java.net.PasswordAuthentication;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
////import java.util.ResourceBundle;
//import utils.Datasource;
////import java.sql.SQLException;
////import java.sql.Statement;
////import java.time.Duration;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Observable;
////import java.util.Properties;
////import java.util.ResourceBundle;
////import java.util.logging.Level;
////import java.util.logging.Logger;
////import javafx.animation.TranslateTransition;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
////import javafx.collections.transformation.FilteredList;
////import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
////import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
////import javafx.scene.layout.AnchorPane;
////import javafx.scene.layout.VBox;
//import service.evenementService;
//import service.optionService;
////import sun.rmi.transport.Transport;
///**
// * FXML Controller class
// *
// * @author HP
// */
//
///*
//public class Gestion_evenementController implements Initializable {
//
//    @FXML
//    private Label tfNom;
//    @FXML
//    private Button btnoption;
//    @FXML
//    private Button btnajout;
//    @FXML
//    private Button btnsuppr;
//    @FXML
//    private Button btnmodif;
//    
//    private evenementService evenementService;
//    private optionService optionService;
//    
//    @FXML
//    private TableColumn<evenement, Integer> tfid;
//    @FXML
//    private TableColumn<evenement, Date> tfdate_debut;
//    @FXML
//    private TableColumn<evenement, Date> tfdate_fin;
//    @FXML
//    private TableColumn<evenement, String> tfsujet;
//    @FXML
//    private TableColumn<evenement, Integer> tfnbre_place;
//    private TableColumn<evenement, Integer> tfchoix_option;
//    @FXML
//    private TableView<evenement> aff_evenement;
//    @FXML
//    private TextField tfid1;
//    @FXML
//    private TextField tfsujet1;
//    @FXML
//    private TextField tfnbreplace1;
//    @FXML
//    private DatePicker tfdatedeb1;
//    @FXML
//    private DatePicker tfdatef1;
//    
//    private Connection conn;
//    private PreparedStatement pst;
//    private ResultSet rs;
//    int index = -1;
//    @FXML
//    private TextField tfchercher;
//    @FXML
//    private Label tfrecherche;
//    
//   // mailutil mail = new mailutil();
//    /**
//     * Initializes the controller class.
//     */
//
///*
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//     this.evenementService = new evenementService();
//     this.optionService = new optionService();
//     afficher();
//    }    
//
//    
//    
//    
//    public void afficher(){
//
//        ObservableList evenementListe = FXCollections.observableList(evenementService.read());
//
//        tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
//        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement, Date>("date_debut"));
//        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement, Date>("date_fin"));
//        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement, String>("sujet"));
//        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));
//        
//        
//        
//        aff_evenement.setItems(evenementListe);
//        //c1.setVisible(false);
//    }
//    public void clear(){
//        tfid1.clear();
//        tfdatedeb1.setValue(null);
//        tfdatef1.setValue(null);
//        tfsujet1.clear();
//        tfnbreplace1.clear();   
//    }
//    @FXML
//    private void onClick1(ActionEvent event) {
//         int id = Integer.parseInt(tfid1.getText());
//        java.sql.Date date_debut =java.sql.Date.valueOf(tfdatedeb1.getValue().toString());
//        java.sql.Date date_fin =java.sql.Date.valueOf(tfdatef1.getValue().toString());
//        String sujet = tfsujet1.getText();
//        int nbre_place = Integer.parseInt(tfnbreplace1.getText());
//        evenement e = new evenement(date_debut,date_fin,sujet,nbre_place);
//        evenementService.inserEvenementPst(e);
//       // mail.send_mail("raoudha.bettaibi@esprit.tn ", tfNom.getText());
//        afficher();
//        clear();
//        
//    }
//
//    @FXML
//    private void onClick2(ActionEvent event) {
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("supp_evenement.fxml"));
//            try {
//            Parent root = loader.load();
//            Supp_evenementController controller = loader.getController();
//            tfNom.getScene().setRoot(root);
//        }catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }
//        afficher();
//        clear();
//   
//    }
//
//    @FXML
//    private void  onClick3(ActionEvent event)   {
//        
//        try{
//          String l = tfsujet1.getText();
//          int m = Integer.parseInt(tfnbreplace1.getText());
//          int o= Integer.parseInt(tfid1.getText());
//          evenementService.update(o,l,m);
//          afficher(); 
//        }
//        catch(Exception ex){
//        System.out.println(ex.getMessage());
//        }
//        afficher();
//        clear();
//}
//
//    @FXML
//    private void onCreate(ActionEvent event) {
//     FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
//        try {
//            Parent root = loader.load();
//            Option1Controller controller = loader.getController();
//            tfNom.getScene().setRoot(root);
//        }catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }
//        afficher();
//        clear();
//    }
//
//    private void btnoption(TableColumn.CellEditEvent<optionService, option> event) {
//    ObservableList optionListe = FXCollections.observableList(optionService.read());
//
//        tfchoix_option.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("code"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
//        try {
//            Parent root = loader.load();
//            Option1Controller controller = loader.getController();
//            tfNom.getScene().setRoot(root);
//        }catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }
//        afficher();
//        clear();
//    }
//    
//    @FXML
//    void getSelected (MouseEvent event){
//        
//        index = aff_evenement.getSelectionModel().getSelectedIndex();
//        if (index <= -1){
//            return;
//        }
//        tfid1.setText(tfid.getCellData(index).toString());
//        tfdatedeb1.setPromptText(tfdate_debut.getCellData(index).toString());
//        tfdatef1.setPromptText(tfdate_fin.getCellData(index).toString());
//        tfsujet1.setText(tfsujet.getCellData(index).toString());
//        tfnbreplace1.setText(String.valueOf(tfnbre_place.getCellData(index).toString()));
//
//    }
//
//    @FXML
//    private void Rechercher(ActionEvent event) {
//    if(tfchercher.getText().trim().length() > 0){
// ObservableList evenementListe = FXCollections.observableArrayList(evenementService.Rechercher(tfchercher.getText()));
//
//        tfid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_debut"));
//        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_fin"));
//        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement,String>("sujet"));
//        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));
//
//            aff_evenement.getItems().clear();
//            aff_evenement.setItems(evenementListe);
//        }else 
//        afficher();
//    }
//
//    private void submit(TableColumn.CellEditEvent<evenementService, evenement> event) {
//       ObservableList evenementListe = FXCollections.observableList(evenementService.read());
//
//        tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
//        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_debut"));
//        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_fin"));
//        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement,String>("sujet"));
//        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));
//
//        
//      afficher();
//      clear();
//    }
//
//    @FXML
//    private void submit(TableColumn.CellEditEvent<S, T> event) {
//    }
//
//   
//}
//    */
//    