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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLAffichePanierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Panieraffiche> tableview;
    
    @FXML
    private TableColumn<Panieraffiche,String> ids;
    
    
    @FXML
    private TableColumn<Panieraffiche,String> prixs;
    
    @FXML
    private TableColumn<Panieraffiche,String> clientids;
    
    
    
    @FXML
    private Button deleteButton;
    
    public Panierservice servicePanier = new Panierservice();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Panieraffiche> data = FXCollections.observableArrayList(servicePanier.readForTableview());
        ids.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("id"));
        prixs.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("prix"));
        clientids.setCellValueFactory(new PropertyValueFactory<Panieraffiche,String>("clientid"));
       
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(ids,prixs,clientids);
    }    
    
    @FXML
    public void supprimerPanier(){
        int id=Integer.parseInt(tableview.getSelectionModel().getSelectedItem().getId());
        servicePanier.delete(id);
        System.out.println("commande supprimé");
        refreshTableView();
    }
    
    public  void refreshTableView() {        
        tableview.getColumns().clear();
        ObservableList<Panieraffiche> data = FXCollections.observableArrayList(servicePanier.readForTableview());
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(ids,prixs,clientids);

}
}
