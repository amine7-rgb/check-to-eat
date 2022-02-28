/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.CatService;
import entity.Categorie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author amed1
 */
public class CategorieController implements Initializable {

    CatService cs =new CatService();
    
    String elpath;
    
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private JFXTextField txt2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }    

    @FXML
    private void go_table(MouseEvent event) {
       String type=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
       txt2.setText(type);
       
    }

    @FXML
    private void submit(ActionEvent event)  throws AWTException, SQLException, FileNotFoundException, DocumentException {
        
        Categorie c =new Categorie(txt2.getText());
        
        cs.insert(c);
                   clear();
        afficher();
        
    }
    
    public void afficher(){

        ObservableList obeListe = FXCollections.observableList(cs.read());

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        
        table.setItems(obeListe);
        //c1.setVisible(false);
        
    }

    @FXML
    private void delete(ActionEvent event) {
        
        int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        cs.supprimerr(k);
        afficher();
        clear();
        
    }
    
    private void clear(){
    
        txt2.clear();
    
    }

    @FXML
    private void update(ActionEvent event) {
        String t1 =txt2.getText();
        int k =Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        cs.modifierbs(k, t1);
        afficher();
        clear();
    }
    
    
    
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

