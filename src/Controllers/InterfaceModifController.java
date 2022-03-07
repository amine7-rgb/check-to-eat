package Controllers;

import Entities.Utilisateur;
import Services.ServiceAdmin;
import Services.ServiceUtilisateur;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.DataSource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GhAlone
 */
public class InterfaceModifController implements Initializable{
    
     @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_genre;

    @FXML
    private TextField txt_num;

    @FXML
    private ComboBox type;

    @FXML
    private PasswordField txt_mdp;

    @FXML
    private Button bt_modif;

    @FXML
    private Label id_lab;

    @FXML
    private Label lid;

    @FXML
    private ImageView imageView;

    @FXML
    void modifier(ActionEvent event) {

    }

        private File selectedFile;

    ServiceAdmin admin = new ServiceAdmin();
    ServiceUtilisateur userser = new ServiceUtilisateur();

    
    public void setnom(String n){
    txt_nom.setText(n);
    }


    public void setprenom(String p) {
    txt_prenom.setText(p);
    }
    
    public void setnum(String k) {
    txt_num.setText(k);     
    }

    public void setpasse(String s) {
    txt_mdp.setText(s);    }


    public void setgenre(String g) {
    txt_genre.setText(g);    }

  

    public void setemail(String h) {
    txt_email.setText(h);    }

  
    
    public void setId(String m) {
    lid.setText(m);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   type.getItems().addAll("Admin","user","partenaire");
        System.out.println(lid.getText());
    
  
        
    bt_modif.setOnAction(event -> {

            Path from = Paths.get(selectedFile.toURI());
                Path to = Paths.get("C:\\Users\\GhAlone\\Documents\\NetBeansProjects\\MainJavaFX\\src\\Images/"+selectedFile.getName());
                //Files.copy(from,to);
                Utilisateur user = new Utilisateur(txt_nom.getText(),txt_prenom.getText(),Integer.parseInt(txt_num.getText()),txt_mdp.getText(), (String) type.getValue(), txt_email.getText(),txt_genre.getText(), to.normalize().toString());
                userser.modifier(user);
           DataSource fdao = DataSource.getInstance();
            
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Formateur modifiée avec succés!");
            alert.show();
        });
        
    } }

               


   

