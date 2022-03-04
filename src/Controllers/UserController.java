/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Utilisateur;
import Services.ServiceAdmin;
import Services.ServiceUtilisateur;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author GhAlone
 */
public class UserController implements Initializable {
    
    
    @FXML
    private TableView<Utilisateur> apprenants;

    @FXML
    private TableColumn<Utilisateur, Integer> iduser;

    @FXML
    private TableColumn<Utilisateur, String> nom;

    @FXML
    private TableColumn<Utilisateur, String> nomp;

    @FXML
    private TableColumn<Utilisateur, Integer> num;

    @FXML
    private TableColumn<Utilisateur, String> passe;

    @FXML
    private TableColumn<Utilisateur, String> genre;

    @FXML
    private TableColumn<Utilisateur, String> email;

    @FXML
    private TableColumn<Utilisateur, String> role;

    @FXML
    private TableColumn<Utilisateur, String> image;

    @FXML
    private Button btn_supp;

    @FXML
    private Button btn_modif;

    @FXML
    private TextField txt_search;
    
    ServiceUtilisateur user = new ServiceUtilisateur();
    ServiceAdmin admin = new ServiceAdmin();
    ObservableList<Utilisateur> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataList = user.afficher();
        iduser.setCellValueFactory(new PropertyValueFactory<>("id"));       
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));        
        nomp.setCellValueFactory(new PropertyValueFactory<>("prenom"));        
        num.setCellValueFactory(new PropertyValueFactory<>("num_tel"));        
        passe.setCellValueFactory(new PropertyValueFactory<>("mot_pass"));  
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));  
        email.setCellValueFactory(new PropertyValueFactory<>("adress_email")); 
        role.setCellValueFactory(new PropertyValueFactory<>("role"));  
        image.setCellValueFactory(new PropertyValueFactory<>("image"));  
        
        
        
        apprenants.setItems(dataList);
        
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Utilisateur> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (employee.getAdress_email().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(employee.getGenre()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		      SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(apprenants.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		apprenants.setItems(sortedData);
                
                
        
    }
    
    
    @FXML
    void click(ActionEvent event) {
        Utilisateur person = apprenants.getSelectionModel().getSelectedItem();
                System.out.println(person);
                       try {
                FXMLLoader loader =new FXMLLoader(getClass().getResource("/Interfaces/modification.fxml"));  
                Parent root = loader.load();
                InterfaceModifController c = loader.getController();
                c.setnom(person.getNom());
                c.setprenom(person.getPrenom());
//                c.setnum(String.valueOf(person.getNum_tel()));
                c.setpasse(person.getMot_pass());
                c.setgenre(person.getGenre());
                c.setemail(person.getAdress_email());
                c.setimage(person.getImage());
                c.setId(valueOf(person.getId()));
                
                 Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    
      @FXML
    void delete(ActionEvent event) {
        Utilisateur person = apprenants.getSelectionModel().getSelectedItem();
        admin.delete(person);
    }
    
}
