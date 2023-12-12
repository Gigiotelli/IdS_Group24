/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Gigi
 */
public class View implements Initializable {
    
    private String input; //= null;
    
    public String getInput(){   
        return input;    
    }
    
    @FXML
    private AnchorPane mainPane;
    private Label label;
    private Button closeButton;
    private Button minimizeButton;
    
    @FXML
    private Button btnSelectVar;
    
    @FXML
    private Pane varPane;
    
    @FXML
    private Button btnC;
    
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnIm;
    private String buffer = new String();
    
    ListView<Character> listVar = new ListView<>();
    ObservableList<Character> viewVar =FXCollections.observableArrayList (
            'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','w','z');
     
    ObservableList<String> comboItems = FXCollections.observableArrayList(
            "Value 1",
            "Value 2",
            "Value 3"
            );
        ComboBox comboBox = new ComboBox(comboItems);
    
    
    @FXML
    private TextField inputField;
      
    
    @FXML
    private void diplayVarsAction(ActionEvent event) {
        // TODO
         
    }
    
    @FXML
    private void closeButtonAction(ActionEvent event) {
            Platform.exit();   
    }
    
    @FXML
    private void minimizeButtonAction(ActionEvent event) {
        Stage stage = (Stage)mainPane.getScene().getWindow();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);   
    }
    
    @FXML
    private void btnSelectVarAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPickVar.fxml"));
        
        Scene scene = new Scene(root); 
        Stage stage = new Stage();
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setX(stage.getX()+200);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void btnCAction (ActionEvent event) {
        inputField.clear();
        inputField.requestFocus();
    } 
    
    @FXML
    private void numberButtonAction (ActionEvent event) {        
        Object source = event.getSource();
        buffer = inputField.getText();
	if(source==btn0)
            inputField.setText(buffer+"0");
	if(source==btn1)
            inputField.setText(buffer+"1");
	if(source==btn2)
            inputField.setText(buffer+"2");
	if(source==btn3)
            inputField.setText(buffer+"3");
	if(source==btn4)
            inputField.setText(buffer+"4");
	if(source==btn5)
            inputField.setText(buffer+"5");
	if(source==btn6)
            inputField.setText(buffer+"6");
	if(source==btn7)
            inputField.setText(buffer+"7");
	if(source==btn8)
            inputField.setText(buffer+"8");
	if(source==btn9)
            inputField.setText(buffer+"9");
	if(source==btnDot)
            inputField.setText(buffer+".");
	if(source==btnIm)
            inputField.setText(buffer+"j");
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Autofocus sull'input field
        Platform.runLater(new Runnable() {
        @Override
        public void run() {
            inputField.requestFocus();
        }
        });
        
        // Set default value per le variabili
        

    }    
    
    public void displayTabView() {
        
    }
    
    public void displayOutputView() {
        
    }
    
    public void displayStackView() {
        
    }
    
    public void displayKeyboard() {
        
    }
    
    public void displayVariables() {
        
    }
    
    public void displayOperations() {
        
    }
}
