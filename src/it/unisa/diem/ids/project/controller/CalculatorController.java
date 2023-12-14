/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.SyntaxException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import it.unisa.diem.ids.project.model.ComplexNumber;
import it.unisa.diem.ids.project.model.Model;
import it.unisa.diem.ids.project.view.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Gigi
 */
public class CalculatorController implements Initializable {
 
    final private Model model;
        public CalculatorController() {
            this.model = new Model();    
        }
       
    private String input; //= null;
    int i;
    private String buffer = new String();
    private Character selectedVar = 'x';
    
    //  -----   Inizio Dichiarazione elementi interfaccia
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Label inputLabel;
    @FXML
    private Button closeButton;
    @FXML
    private Button minimizeButton;
    @FXML
    private Button btnSelectVar;
    @FXML
    private Button btnC;
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnIm;
    @FXML
    private Button btnAss;
    @FXML
    private Button btnAssignVar;
    @FXML
    private Button btnPushVar;
    @FXML
    private Button btnAddVar;
    @FXML
    private Button btnSubVar;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnMul;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnSqrt;
    @FXML
    private Button btnRevSign;
    @FXML
    private Button btnSwap;
    @FXML
    private Button btnDup;
    @FXML
    private Button btnOver;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDrop;
    @FXML
    private Button btnBackSpace;
    @FXML
    private Label outputLabel;   
    @FXML
    private Button btnEnter;
    
    
    @FXML
    private ListView<String> stackList; 
    
    private int iVar = 0;
    private GridPane varGrid;        
    
    
  
    //  -----   Fine Dichiarazione elementi interfaccia
    
    
    // metodo per ottenere la stringa inserita in input
    public String getInput(){   
        return inputLabel.getText();    
    }
    
    public void setInput(String string){   
        inputLabel.setText(string);    
    }
    
    public String clear() {
        return "";
    }
    ComplexNumber c = new ComplexNumber(4,6);
    
    public void showException(String e) {
        Alert alert = new Alert(AlertType.ERROR, e, ButtonType.OK);
        alert.showAndWait();
    }
    
    private ComplexNumber parseComplexNumber(String input) {
        String doubleRegex = "[-+]?(\\d+(\\.\\d*)?|\\.\\d+)";
        Pattern doublePattern = Pattern.compile(doubleRegex);
        
        double re, im;
        double real = 0.0;
        double immaginary = 0.0;
        
        Matcher m = doublePattern.matcher(input);
        if (m.lookingAt()) {
            real = Double.parseDouble(m.group());
            input = input.substring(m.end());
            m = doublePattern.matcher(input);
            System.out.println("INPUT: "+input);
            if(input.equals("j")) {
                immaginary = real;
                real = 0.0;
            }
            
            if (input.matches("[-+].*") && m.lookingAt()) {
                immaginary = Double.parseDouble(m.group());
                input = input.substring(m.end());
                if (!input.equals("j")) {
                    System.out.println("Eccez.");
                    throw new NumberFormatException();
                }
            } else if (input.matches("[-+]j")) {
                immaginary = input.startsWith("-") ? -1.0 : 1.0;
            }
                    else {
                        //throw new NumberFormatException();
                    }
                } else if (input.matches("[-+]j")) {
                    immaginary = input.startsWith("-") ? -1.0 : 1.0;
                } 
        
        re = real;
        im = immaginary;
        System.out.println("RE: "+re+"\tIM: "+im);
        return new ComplexNumber(re, im);
    }
    
    
    private boolean isComplexNumber(String input) {
        
        return (input.matches("[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?[+-]?\\d*\\.?\\d*[jJ]?"));
    }
    
    
    
    
    ListView<Character> listVar = new ListView<>();
    ObservableList<Character> viewVar =FXCollections.observableArrayList (
            'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','w','z');
      
    
    
      
    
    
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
        Parent root = FXMLLoader.load(getClass().getResource("/it/unisa/diem/ids/project/view/FXMLPickVar.fxml"));
        
        Scene scene = new Scene(root); 
        Stage stage = new Stage();
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
         
        stage.initModality(Modality.WINDOW_MODAL);
        
        scene.setFill(Color.TRANSPARENT);
        
        /*while(iVar<3){
            iVar++;
            final Button temp = new Button("Button " + iVar);
            final int numButton= iVar;
            temp.setId("" + iVar);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                System.out.println("id(" + temp.getId()  + ") =  " + numButton);
                }
            });
            varGrid.add(temp, iVar, 1);
        }*/
        
        stage.setScene(scene);
        
        stage.show();
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = 695 + bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.3;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.7 - 100;
        stage.setX(x);
        stage.setY(y);
        
    }
    
    @FXML
    private void btnCAction (ActionEvent event) {
        setInput(clear());
        outputLabel.setText(clear());
    } 
    
    @FXML
    private void numberButtonAction (ActionEvent event) {        
        Object source = event.getSource();
        buffer = getInput();
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
        setInput(clear());
        outputLabel.setText("");
        
        stackList.setItems(model.getModelStack().toStringList());
        
        // Set default value per le variabili
        

    }    
    
    public void displayTabView() {
        
    }
    
    public void displayOutputView() {
        
    }
    
    public void displayStackView(){
        
        stackList.setItems(model.getModelStack().toStringList());
    }
    
    public void displayKeyboard() {
        //Insieme dei bottoni che permettono la visualizzazione dei numeri
    }
    
    public void displayVariables() {
        //Insieme dei bottoni che permettono la visualizzazione il menù delle variabili
    }
    
    public void displayOperations() {
        //Insieme dei bottoni che permettono visualizzazione delle operazioni eseguibili sulla calcolatrice
    }


////////////RIGHE CHE STA MODIFICANDO ANDREA DONT TOUCH SI SFANCULA GIT!!!
    @FXML
    private void btnAssignVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                model.modelAllocation(input.charAt(0));
                //model.getModelStack().getStack().lastElement()
            } catch (InsufficientElementException ex) {
                showException("Error: " + ex.getMessage());
            }
        }else
            try {
                throw new SyntaxException("String not valid as a variable");
        } catch (SyntaxException ex) {
            showException("Error : " + ex.getMessage());
        }
        
        
    }
 
    @FXML
    private void btnPushVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                model.modelPushVar(input.charAt(0));
                
            } catch (VariableNotInitializedException ex) {
                showException("Error: " + ex.getMessage());
            }
        }else
            try {
                throw new SyntaxException("String not valid as a variable");
        } catch (SyntaxException ex) {
            showException("Error : " + ex.getMessage());
        }
        
        
    }

    @FXML
    private void btnAddVarAction(ActionEvent event) {
    }

    @FXML
    private void btnSubVarAction(ActionEvent event) {
    }

    
 /////////////////////////////////////////////////LEGGI SOPRA!!!
    
    
    @FXML
    private void btnSwapAction(ActionEvent event) throws InsufficientElementException {
        try{
            /*ComplexNumber c1 = model.getModelStack().getStack().pop();
            ComplexNumber c2 = model.getModelStack().getStack().pop();
            model.getModelStack().getStack().push(c1);
            model.getModelStack().getStack().push(c2);*/
            model.modelSwap();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnDupAction(ActionEvent event) throws InsufficientElementException {
        try{
            /*ComplexNumber c1 = model.getModelStack().getStack().pop();
            model.getModelStack().getStack().push(c1);
            model.getModelStack().getStack().push(c1);*/
            model.modelDup();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnOverAction(ActionEvent event) throws InsufficientElementException {
        try{
            /*ComplexNumber c1 = model.getModelStack().getStack().pop();
            ComplexNumber c2 = model.getModelStack().getStack().pop();
            model.getModelStack().getStack().push(c2);
            model.getModelStack().getStack().push(c1);
            model.getModelStack().getStack().push(c2);*/
            model.modelOver();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnClearAction(ActionEvent event) {
        //model.getModelStack().getStack().clear();
        model.modelClear();
        displayStackView();
    }

    @FXML
    private void btnDropAction(ActionEvent event) throws InsufficientElementException{
        try {
            //model.getModelStack().getStack().pop();
            model.modelDrop();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnBackSpaceAction(ActionEvent event) {
        buffer = getInput();
        if(buffer.length() != 0)
            setInput(buffer.substring(0, buffer.length() - 1));
        else setInput("");
    }

    @FXML
    private void btnOperationAction(ActionEvent event) {
        Object source = event.getSource();
        buffer = getInput();
	if(source==btnAdd)
            setInput(buffer+"+");
        if(source==btnSub)
            setInput(buffer+"-");
        if(source==btnMul)
            setInput("×");
        if(source==btnDiv)
            setInput("÷");
        if(source==btnSqrt)
            setInput("√");
        if(source==btnRevSign)
            setInput("±");
    }

    @FXML
    private void btnEnterAction(ActionEvent event) throws InsufficientElementException, SyntaxException {
        if(getInput()!=null && !getInput().isEmpty()){
            try {
                switch (getInput()) {
                    case "+":
                        try{
                            model.modelAdd();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "-":
                        try{
                            model.modelSub();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "×":
                        try{
                            model.modelMultiply();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "÷":
                        try{
                            model.modelDiv();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }catch(ArithmeticException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "±":
                        try{
                            model.modelReverseSign();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "√":
                        try{
                            model.modelSqrt();
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        if (isComplexNumber(getInput())) {
                            ComplexNumber num = parseComplexNumber(getInput());
                            model.getModelStack().getStack().push(num);
                            displayStackView();
                        } else {
                            throw new SyntaxException("Invalid input");
                        }
                }
            } catch (SyntaxException e) {
                showException("Error: " + e.getMessage());
            } finally {
                setInput(clear());
            }
        }
    }
    
}