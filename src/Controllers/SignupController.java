/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



import Entities.Utilisateur;
import Services.ServiceUtilisateur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.springframework.security.crypto.bcrypt.BCrypt;




/**
 *
 * @author GhAlone
 */
public class SignupController implements Initializable{
    
   @FXML
    private TextField num;

    @FXML
    private TextField txt_mdp;

    @FXML
    private Button signup;

    @FXML
    private CheckBox check;

    @FXML
    private Button btn_retour;

    @FXML
    private ImageView home;

    @FXML
    private Label passe;

    @FXML
    private ComboBox type;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    private RadioButton Female;

    @FXML
    private RadioButton Male;

    
    @FXML
    private ImageView imageView;

    @FXML
    private Label img;
    
    private File selectedFile;
     
ToggleGroup groupGender=new ToggleGroup();
    ServiceUtilisateur us= new ServiceUtilisateur();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type.getItems().addAll("user","partenaire");
         
        Male.setToggleGroup(groupGender);
        Female.setToggleGroup(groupGender);
        txt_mdp.setVisible(false);
       check.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_value, Boolean newValue) -> {
       if(check.isSelected()){
           txt_mdp.setText(mdp.getText());
           txt_mdp.setVisible(true);
           mdp.setVisible(false);
           return;
           
       }
      mdp.setText(txt_mdp.getText());
       mdp.setVisible(true);
       txt_mdp.setVisible(false);
       
       });
    }
    
    @FXML
    public void onChoseFile(ActionEvent event){
        FileChooser fc = new FileChooser();
        selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null){
            try {
                Image image = new Image(new FileInputStream(selectedFile));
                imageView.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Hey");
        }
    }
    
    public void register(){
        RadioButton selectedRadioButton = (RadioButton) groupGender.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
         if(selectedFile != null){
            try {
                Path from = Paths.get(selectedFile.toURI());
                Path to = Paths.get("C:\\Users\\GhAlone\\Documents\\NetBeansProjects\\MainJavaFX\\src\\Images/"+selectedFile.getName());
                //Files.copy(from,to);
                Utilisateur user = new Utilisateur(nom.getText(),prenom.getText(),Integer.parseInt(num.getText()),hashPassword(mdp.getText()),toogleGroupValue, email.getText(),(String) type.getValue(), to.normalize().toString());
                us.inscrir(user);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("file is null");
        }
         
    }
    
    private static String hashPassword(String txtpassword){
    return BCrypt.hashpw(txtpassword, BCrypt.gensalt());
    
}   //
}
