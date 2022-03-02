/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import commandefxml.entities.*;
import commandefxml.service.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import commandefxml.utils.Datasource;

import javafx.scene.control.cell.PropertyValueFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLmodifierCommandeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      private Connection con ;
        private Statement ste;
            private PreparedStatement pst;
    @FXML
    private TableView<Commandeaffiche> tableview;
    
    @FXML
    private TableColumn<Commandeaffiche,String> idy;
    
    
    @FXML
    private TableColumn<Commandeaffiche,String> titrey;
    
    @FXML
    private TableColumn<Commandeaffiche,String> datey;
    
    @FXML
    private TableColumn<Commandeaffiche,String> panierFKy;
    
        @FXML
    public TextField idx;
        
     @FXML
    public TextField titrex;
    
    @FXML
    public TextField datex;
    
    @FXML
    public TextField panierFKx;
    
    @FXML 
    public Button modifierCommande;
    
    
  /*  @FXML
    private Button deleteButton;*/
    
    public Commandeservice serviceCommande = new Commandeservice();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Commandeaffiche> data = FXCollections.observableArrayList(serviceCommande.readForTableview());
        idy.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("id"));
        titrey.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("titre"));
        datey.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("date_de_commande"));
        panierFKy.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("panierFK"));
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(idy,titrey,datey,panierFKy);
    } 
    
      @FXML
   public void modifierCommande(ActionEvent event)throws  IOException {
    
   
     
             int value1 = Integer.parseInt(idx.getText());
            String value2 = titrex.getText();
            String value3 = datex.getText();
            int value4 = Integer.parseInt(panierFKx.getText());
     
           serviceCommande.updateperId(value1,value2, value3,value4) ;
               refreshTableView();
        
   }
       
    
    public  void refreshTableView() {        
        tableview.getColumns().clear();
        ObservableList<Commandeaffiche> data = FXCollections.observableArrayList(serviceCommande.readForTableview());
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(idy,titrey,datey,panierFKy);

}
    
}