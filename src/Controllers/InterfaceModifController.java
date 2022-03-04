package Controllers;

import Entities.Utilisateur;
import Services.ServiceAdmin;
import Services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        
    private TextField num;
        @FXML
    private ComboBox<String> cb_cinteret;

   

    @FXML
    private PasswordField txt_mdp;

    @FXML
    private Button bt_modif;

    @FXML
    private Label id_lab;

    @FXML
    private TextField image;
    
    @FXML
    private Label lid;
    
    ServiceAdmin admin = new ServiceAdmin();
    ServiceUtilisateur userser = new ServiceUtilisateur();

    
    public void setnom(String n){
    txt_nom.setText(n);
    }


    public void setprenom(String p) {
    txt_prenom.setText(p);
    }
    
    public void setnum(String k) {
    num.setText(k);     
    }

    public void setpasse(String s) {
    txt_mdp.setText(s);    }


    public void setgenre(String g) {
    txt_genre.setText(g);    }

  

    public void setemail(String h) {
    txt_email.setText(h);    }

  



    public void setimage(String m) {
    image.setText(m);
    }
    
    public void setId(String m) {
    lid.setText(m);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   cb_cinteret.getItems().addAll("Admin","user","partenaire");
        System.out.println(lid.getText());
    }
    
    @FXML
    void modifier(ActionEvent event) {
        int nu = Integer.parseInt(num.getText());
        System.out.println(nu);
        Utilisateur user = new Utilisateur(Integer.parseInt(lid.getText()), txt_nom.getText(), txt_prenom.getText(), nu, txt_mdp.getText(), txt_genre.getText(), txt_email.getText(), cb_cinteret.getValue(), image.getText());
        userser.modifier(user);
    }
    


   
}
