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
public class FXMLAfficheController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Commandeaffiche> tableview;
    
    @FXML
    private TableColumn<Commandeaffiche,String> ids;
    
    
    @FXML
    private TableColumn<Commandeaffiche,String> titres;
    
    @FXML
    private TableColumn<Commandeaffiche,String> dateCommandes;
    
    @FXML
    private TableColumn<Commandeaffiche,String> panierFKs;
    
    @FXML
    private Button deleteButton;
    
    public Commandeservice serviceCommande = new Commandeservice();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Commandeaffiche> data = FXCollections.observableArrayList(serviceCommande.readForTableview());
        ids.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("id"));
        titres.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("titre"));
        dateCommandes.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("date_de_commande"));
        panierFKs.setCellValueFactory(new PropertyValueFactory<Commandeaffiche,String>("panierFK"));
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(ids,titres,dateCommandes,panierFKs);
    }    
    
    @FXML
    public void deleteCommande(){
        int id=Integer.parseInt(tableview.getSelectionModel().getSelectedItem().getId());
        serviceCommande.delete(id);
        System.out.println("commande supprimé");
        refreshTableView();
    }
    
    public  void refreshTableView() {        
        tableview.getColumns().clear();
        ObservableList<Commandeaffiche> data = FXCollections.observableArrayList(serviceCommande.readForTableview());
        tableview.setItems(data);
        tableview.getColumns().clear();
        tableview.getColumns().addAll(ids,titres,dateCommandes,panierFKs);

}
}
