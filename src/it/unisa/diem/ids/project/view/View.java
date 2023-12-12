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
import javafx.geometry.Rectangle2D;
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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
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
      
    
    
    @FXML
    private Label inputLabel;
      
    
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
         
        stage.initModality(Modality.APPLICATION_MODAL);
        
        scene.setFill(Color.TRANSPARENT);
        
        
        
        stage.setScene(scene);
        stage.show();
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = 670 + bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.3;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.7 - 100;
        stage.setX(x);
        stage.setY(y);
        
    }
    
    @FXML
    private void btnCAction (ActionEvent event) {
        inputLabel.setText("");
    } 
    
    @FXML
    private void numberButtonAction (ActionEvent event) {        
        Object source = event.getSource();
        buffer = inputLabel.getText();
	if(source==btn0)
            inputLabel.setText(buffer+"0");
	if(source==btn1)
            inputLabel.setText(buffer+"1");
	if(source==btn2)
            inputLabel.setText(buffer+"2");
	if(source==btn3)
            inputLabel.setText(buffer+"3");
	if(source==btn4)
            inputLabel.setText(buffer+"4");
	if(source==btn5)
            inputLabel.setText(buffer+"5");
	if(source==btn6)
            inputLabel.setText(buffer+"6");
	if(source==btn7)
            inputLabel.setText(buffer+"7");
	if(source==btn8)
            inputLabel.setText(buffer+"8");
	if(source==btn9)
            inputLabel.setText(buffer+"9");
	if(source==btnDot)
            inputLabel.setText(buffer+".");
	if(source==btnIm)
            inputLabel.setText(buffer+"j");
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
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
