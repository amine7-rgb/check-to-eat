/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import javafx.scene.control.TableColumn.CellDataFeatures;
import entite.evenement;
import entite.option;
import java.io.FilterReader;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import service.evenementService;
import service.optionService;
import sun.rmi.transport.Transport;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Gestion_evenementController implements Initializable {

    @FXML
    private Label tfNom;
    @FXML
    private Button btnoption;
    @FXML
    private Button btnajout;
    @FXML
    private Button btnsuppr;
    @FXML
    private Button btnmodif;
    
    private evenementService evenementService;
    private optionService optionService;
    
    @FXML
    private TableColumn<evenement, Integer> tfid;
    @FXML
    private TableColumn<evenement, Date> tfdate_debut;
    @FXML
    private TableColumn<evenement, Date> tfdate_fin;
    @FXML
    private TableColumn<evenement, String> tfsujet;
    @FXML
    private TableColumn<evenement, Integer> tfnbre_place;
    private TableColumn<evenement, Integer> tfchoix_option;
    @FXML
    private TableView<evenement> aff_evenement;
    @FXML
    private TextField tfid1;
    @FXML
    private TextField tfsujet1;
    @FXML
    private TextField tfnbreplace1;
    @FXML
    private DatePicker tfdatedeb1;
    @FXML
    private DatePicker tfdatef1;
    
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    int index = -1;
    @FXML
    private TextField tfchercher;
    @FXML
    private Label tfrecherche;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     this.evenementService = new evenementService();
     this.optionService = new optionService();
     afficher();
    }    

    
    
    
    public void afficher(){

        ObservableList evenementListe = FXCollections.observableList(evenementService.read());

        tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement, Date>("date_debut"));
        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement, Date>("date_fin"));
        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement, String>("sujet"));
        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));
        
        
        
        aff_evenement.setItems(evenementListe);
        //c1.setVisible(false);
    }
    public void clear(){
        tfid1.clear();
        tfdatedeb1.setValue(null);
        tfdatef1.setValue(null);
        tfsujet1.clear();
        tfnbreplace1.clear();   
    }
    @FXML
    private void onClick1(ActionEvent event) {
         int id = Integer.parseInt(tfid1.getText());
        java.sql.Date date_debut =java.sql.Date.valueOf(tfdatedeb1.getValue().toString());
        java.sql.Date date_fin =java.sql.Date.valueOf(tfdatef1.getValue().toString());
        String sujet = tfsujet1.getText();
        int nbre_place = Integer.parseInt(tfnbreplace1.getText());
        evenement e = new evenement(date_debut,date_fin,sujet,nbre_place);
        evenementService.inserEvenementPst(e);
        afficher();
        clear();
        
    }

    @FXML
    private void onClick2(ActionEvent event) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("supp_evenement.fxml"));
            try {
            Parent root = loader.load();
            Supp_evenementController controller = loader.getController();
            tfNom.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        afficher();
        clear();
   
    }

    @FXML
    private void  onClick3(ActionEvent event)   {
        
        try{
          String l = tfsujet1.getText();
          int m = Integer.parseInt(tfnbreplace1.getText());
          int o= Integer.parseInt(tfid1.getText());
          evenementService.update(o,l,m);
          afficher(); 
        }
        catch(Exception ex){
        System.out.println(ex.getMessage());
        }
        afficher();
        clear();
}

    @FXML
    private void onCreate(ActionEvent event) {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
        try {
            Parent root = loader.load();
            Option1Controller controller = loader.getController();
            tfNom.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        afficher();
        clear();
    }
    
    public void setTfdate_fin(String value) {
        this.tfdate_fin.setText(value);
    }

    public void setTfId(String value) {
        this.tfid.setText(value);
    }

    public void setTfnbre_place(String value) {
        this.tfnbre_place.setText(value);
    }

    public void setTfsujet(String value) {
        this.tfsujet.setText(value);
    }

    public void setTfdate_debut(String value) {
        this.tfdate_debut.setText(value);
    }

    private void btnoption(TableColumn.CellEditEvent<optionService, option> event) {
    ObservableList optionListe = FXCollections.observableList(optionService.read());

        tfchoix_option.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("code"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("option1.fxml"));
        try {
            Parent root = loader.load();
            Option1Controller controller = loader.getController();
            tfNom.getScene().setRoot(root);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        afficher();
        clear();
    }
    
    @FXML
    void getSelected (MouseEvent event){
        
        index = aff_evenement.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        tfid1.setText(tfid.getCellData(index).toString());
        tfdatedeb1.setPromptText(tfdate_debut.getCellData(index).toString());
        tfdatef1.setPromptText(tfdate_fin.getCellData(index).toString());
        tfsujet1.setText(tfsujet.getCellData(index).toString());
        tfnbreplace1.setText(String.valueOf(tfnbre_place.getCellData(index).toString()));

    }
    
//    public void rechercher(ActionEvent event)throws  IOException{
//     
//        int value1 = Integer.parseInt(tfchercher.getText());
//        evenementService.Recherche(value1) ;
//        ObservableList<evenement> dataListe = FXCollections.observableList(evenementService.read());
//        
//        tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
//        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_debut"));
//        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_fin"));
//        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement,String>("sujet"));
//        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));
//  
//        aff_evenement.setItems(dataListe);
//  
//        FilteredList<evenement> filterData = new FilteredList<>(dataListe, b-> true);
//        TextField filterInput = new TextField();
//        filterInput.textProperty().addListener((Observable, olValue, newValue)->{
//                filterData.setPredicate(evenement->{
//                    if (newValue== null || newValue.isEmpty()){
//                        return true;
//                }
//                    String lowerCaseFilter = newValue.toLowerCase();
//                    if (String.valueOf(evenement.getId()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                        return true;
//                    }else if (evenement.getSujet().toLowerCase().indexOf(lowerCaseFilter) != -1){
//                        return true;
//                    }else if (String.valueOf(evenement.getNbre_place()).toLowerCase().indexOf(lowerCaseFilter) != -1){
//                        return true;
//                    }else
//                        return false;
//                    
//    });
//                });
//            SortedList<evenement> sortedData = new SortedList<>(filterData);
//            sortedData.comparatorProperty().bind(aff_evenement.comparatorProperty());
//            aff_evenement.setItems(sortedData);
//   
//        
//     }


    @FXML
    private void submit(TableColumn.CellEditEvent<evenementService, evenement> event) {
       ObservableList evenementListe = FXCollections.observableList(evenementService.read());

        tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_debut"));
        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement,Date>("date_fin"));
        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement,String>("sujet"));
        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("nbre_place"));

        
      afficher();
      clear();
    }

    @FXML
    private void Recherche(ActionEvent event) throws  IOException{
     List<evenement> listE = new ArrayList<>();
      int value1 = Integer.parseInt(tfchercher.getText());
      ObservableList evenementListe = FXCollections.observableList(evenementService.Recherche(value1));
      try {
            evenement e = new evenement();
            Statement st = conn.createStatement();
            String requete = "SELECT * FROM evenement WHERE id = '"+value1+"'";
            //System.out.println("Evenement trouvee!");
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {   
        tfdate_debut.setCellValueFactory(new PropertyValueFactory<evenement,Date>(String.valueOf(rs.getDate(2))));
        tfdate_fin.setCellValueFactory(new PropertyValueFactory<evenement,Date>(String.valueOf(rs.getDate(3))));
        tfsujet.setCellValueFactory(new PropertyValueFactory<evenement,String>(rs.getString(4)));
        tfnbre_place.setCellValueFactory(new PropertyValueFactory<evenement,Integer>(String.valueOf(rs.getDouble(5))));
        aff_evenement.setItems(evenementListe);   
        //listE.add(new evenement(rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getInt(5)));
            }
            //System.out.println(listE); 
        } catch (SQLException ex) {
             Logger.getLogger(evenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return listE;
    
       
        //evenementService.Recherche(value1) ;
////        ObservableList evenementListe =  (ObservableList) listE;
                //FXCollections.observableList(evenementService.Recherche(value1));

        //tfid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
        

//      aff_evenement.setItems(evenementListe);
      afficher();
    }
   
    
    }