/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

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
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;


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
    private ImageView image;

    @FXML
    private PasswordField mdp;

    @FXML
    private RadioButton Female;

    @FXML
    private RadioButton man;

    @FXML
    private Button btimg;
    String s;   
    @FXML
    void add_users(ActionEvent event) {

    }
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void actionPerformed(ActionEvent e){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi","root","");
            String req="insert into utilisateur(nom,prenom,num_tel,mot_pass,genre,adress_email,role,image)values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst= conn.prepareStatement(req);
            InputStream is= new FileInputStream(new File(s));
            pst.setString(1,nom.getText());   
            pst.setString(2,prenom.getText());   
            pst.setString(3,num.getText());   
            pst.setString(4,mdp.getText());   
            pst.setString(5,nom.getText());   
            pst.setString(7,type.getValue().toString());
            pst.setString(7,nom.getText());   
            pst.setString(8,nom.getText());   
            pst.executeQuery();
            JOptionPane.showMessageDialog(null, "saved");
        }catch(Exception ex){
            ex.printStackTrace();
                
        }
    }   


   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type.getItems().addAll("user","partenaire");
    }
}