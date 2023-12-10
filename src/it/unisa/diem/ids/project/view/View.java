/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Gigi
 */
public class View implements Initializable {
    
    private String input = null;
    
    @FXML
    private AnchorPane mainPane;
    private Label label;
    private Button closeButton;
    private Button minimizeButton;
    ChoiceBox choiceVar = new ChoiceBox<>(
                FXCollections.observableArrayList(
                        'a','b','c'
                ));
    
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
