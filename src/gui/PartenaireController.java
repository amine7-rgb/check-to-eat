/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import entity.Categorie;
import java.awt.AWTException;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import static jdk.nashorn.internal.objects.NativeJava.type;
import static org.omg.CORBA.AnySeqHelper.type;
import service.CatService;

        
      
        /**
 * FXML Controller class
 *
 * @author amed1
 */
public class PartenaireController implements Initializable {
    CatService srv = new CatService();
    Categorie c =new Categorie();
    String elpath;
    @FXML
    private Button ajout;
     
    @FXML
    private TableColumn<? ,?> c1;
    @FXML
    private TableColumn <? ,?>  c2;      
    /*
    @FXML
    private AnchorPane btn;
    @FXML
    private Button up;
    @FXML
    private Button supp;
    */
    @FXML
    private JFXButton addbtn1;
    /*
    @FXML
    private JFXTextField tid;
    @FXML
    private JFXTextField type;
    */
     @FXML
    private JFXTextField txt2;
    @FXML
    private JFXTextField txt3;
    @FXML
    private TableView<?> table;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    /**
     * Initializes the controller class.
     */
    
     //private CatService ca;
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficher();
         
        
    }   */ 
    /*
    private void go_table(MouseEvent event) {
        String type=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        txt3.setText(type);

    }
    */
    
    
    /*
    @FXML
    private void submit(ActionEvent event) throws AWTException, SQLException, FileNotFoundException, DocumentException {
    
        Categorie c = new Categorie(Integer.parseInt(txt2.getText()),txt3.getText());
       // System.out.println(tid.getText());
      srv.insert(c);
      clear();
        
      afficher();
          
        
    }

     public void afficher(){

        ObservableList obeListe = FXCollections.observableList(srv.read());

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        
        table.setItems(obeListe);
        //c1.setVisible(false);
        
    }
/*
    @FXML
    private void supprimer (ActionEvent event)
    {
         int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimer(k);
            afficher();
            clear();
    
    }
     */
    /*
    private void clear(){
        txt2.clear();
        txt3.clear();
    }

    @FXML
    private void update(ActionEvent event) {
        
         String t1 = txt3.getText();
        int t2 =Integer.parseInt(txt2.getText());
         int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifierbs(k, t1);
        afficher();
        clear();
        
        
    }
    

    @FXML
    private void importer(ActionEvent event) {
     
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));//importation de l'image ou
        fc.setTitle("Veuillez choisir l'image"); //titre de la
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            String path = selectedFile.getName();
            
            try {
                path = selectedFile.toURI().toURL().toExternalForm();
                System.out.println(path);
                elpath=path;
            } catch (MalformedURLException ex) {
                System.out.println(ex.getMessage());
            }
                          
      //   Image image = new Image(path);
            
           // Image image = new Image(selectedFile.toURI().toString()) {};
            //img.setImage(path) ;
              if(path.equals(""))
            {
                boolean verificationImage = false;
            }
            else 
                  
              { boolean verificationImage = true;
}
        
   
    }

    }
/*
    @FXML
    private void supprimer(javafx.scene.input.MouseEvent event) {
    }
*//*
    @FXML
    private void supp(javafx.scene.input.MouseEvent event) {
         int k=Integer.valueOf(c1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimer(k);
            afficher();
            clear();
    }
*/


}

    
    
    
    
    
    
