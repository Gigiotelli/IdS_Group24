/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.view;

import it.unisa.diem.ids.project.controller.CalculatorController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gigi
 */
public class FXMLPickVarController implements Initializable {
    
    //private final CalculatorController controller1;
    
    @FXML
    private Button closeVarBtn;
    @FXML
    private Pane varPane;
    @FXML
    private GridPane varGrid;
    @FXML
    private Button btnA;
    @FXML
    private Button btnB;
    @FXML
    private Button btnC;
    @FXML
    private Button btnD;
    @FXML
    private Button btnE;
    @FXML
    private Button btnF;
    @FXML
    private Button btnG;
    @FXML
    private Button btnH;
    @FXML
    private Button btnI;
    @FXML
    private Button btnJ;
    @FXML
    private Button btnK;
    @FXML
    private Button btnL;
    @FXML
    private Button btnM;
    @FXML
    private Button btnN;
    @FXML
    private Button btnO;
    @FXML
    private Button btnP;
    @FXML
    private Button btnQ;
    @FXML
    private Button btnR;
    @FXML
    private Button btnS;
    @FXML
    private Button btnT;
    @FXML
    private Button btnU;
    @FXML
    private Button btnV;
    @FXML
    private Button btnX;
    @FXML
    private Button btnY;
    @FXML
    private Button btnW;
    @FXML
    private Button btnZ;
    
    String selectedVar;
    
    
    // Inizializzo il controller per passare la variabile selezionata a CalculatorController
    private CalculatorController controller1;
    
    public void initController1(CalculatorController controller1) {
        this.controller1 = controller1;
    }
     
    @FXML
    public void closeVarBtnAction(ActionEvent event) {
    Stage stage = (Stage) closeVarBtn.getScene().getWindow();
    stage.close();
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
		
    
    private final ReadOnlyObjectWrapper<String> currentCustomer = new ReadOnlyObjectWrapper<>();

    @FXML
    private void charBtnAction(ActionEvent event) {
        Object source = event.getSource();
         
	if(source==btnA)
            selectedVar = "a";
	if(source==btnB)
            selectedVar = "b";
	if(source==btnC)
            selectedVar = "c";
	if(source==btnD)
            selectedVar = "d";
	if(source==btnE)
            selectedVar = "e";
	if(source==btnF)
            selectedVar = "f";
	if(source==btnG)
            selectedVar = "g";
	if(source==btnH)
            selectedVar = "h";
	if(source==btnI)
            selectedVar = "i";
	if(source==btnJ)
            selectedVar = "j";
	if(source==btnK)
            selectedVar = "k";
	if(source==btnL)
            selectedVar = "l";
	if(source==btnM)
            selectedVar = "m";
	if(source==btnN)
            selectedVar = "n";
	if(source==btnO)
            selectedVar = "o";
	if(source==btnP)
            selectedVar = "p";
	if(source==btnQ)
            selectedVar = "q";
	if(source==btnR)
            selectedVar = "r";
	if(source==btnS)
            selectedVar = "s";
	if(source==btnT)
            selectedVar = "t";
	if(source==btnU)
            selectedVar = "u";
	if(source==btnV)
            selectedVar = "v";
	if(source==btnX)
            selectedVar = "x";
	if(source==btnY)
            selectedVar = "y";
	if(source==btnW)
            selectedVar = "w";
	if(source==btnZ)
            selectedVar = "z";
        
        
        if (controller1 != null) {
            controller1.insertVar(selectedVar);
        }
        
    }
     
}
