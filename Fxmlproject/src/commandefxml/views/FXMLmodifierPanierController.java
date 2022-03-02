/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.views;

import commandefxml.entities.Commandeaffiche;
import commandefxml.entities.Panieraffiche;
import commandefxml.service.Commandeservice;
import commandefxml.service.Panierservice;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLmodifierPanierController implements Initializable {

   /**
     * Initializes the controller class.
     */
    
      private Connection con ;
        private Statement ste;
            private PreparedStatement pst;
    @FXML
    private TableView<Panieraffiche> tableview;
    
    @FXML
    private TableColumn<Panieraffiche,String> idh;
    
    
    @FXML
    private TableColumn<Panieraffiche,String> prixh;
    
    @FXML
    private TableColumn<Panieraffiche,String> clientidh;
    

    
        @FXML
    public TextField ida;
        
     @FXML
    public TextField prixa;
    
    @FXML
    public TextField clientida;
    
   
    @FXML 
    public Button modifierPanier;
    
    
  /*  @FXML
    private Button deleteButton;*/
    
    public Panierservice servicePanier = new Panierservice();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Panieraffiche> data = FXCollections.observableArrayList(servicePanier.readForTableview());
        idh.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("id"));
        prixh.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("prix"));
        clientidh.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("clientid"));
    
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(idh,prixh,clientidh);
    } 
    
      @FXML
   public void modifierPanier(ActionEvent event)throws  IOException {
    
   
     
             int value1 = Integer.parseInt(ida.getText());
            double value2 =  Double.parseDouble(prixa.getText());
            int value3 = Integer.parseInt(clientida.getText());
         
     
           servicePanier.updateperIds(value1,value2, value3) ;
               refreshTableView();
        
   }
       
    
     public  void refreshTableView() {        
        tableview.getColumns().clear();
        ObservableList<Panieraffiche> data = FXCollections.observableArrayList(servicePanier.readForTableview());
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(idh,prixh,clientidh);

}
}   
