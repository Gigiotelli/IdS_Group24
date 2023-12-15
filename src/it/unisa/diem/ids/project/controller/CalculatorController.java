/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.controller;

import it.unisa.diem.ids.project.view.FXMLPickVarController;
import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.SyntaxException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import it.unisa.diem.ids.project.model.ComplexNumber;
import it.unisa.diem.ids.project.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Gigi
 */
public class CalculatorController implements Initializable {
 
    final private Model model;
    @FXML
    private AnchorPane buttonPane;
    @FXML
    private Button btnTopCalc;
    @FXML
    private Button btnTopVar;
    @FXML
    private Pane tabVarPane;  
    
        public CalculatorController() {
            this.model = new Model();    
        }
       
    int i;
    private String buffer = new String();
    
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
    private TextField fieldA;
    @FXML
    private TextField fieldB;
    @FXML
    private TextField fieldC;
    @FXML
    private TextField fieldD;
    @FXML
    private TextField fieldE;
    @FXML
    private TextField fieldF;
    @FXML
    private TextField fieldG;
    @FXML
    private TextField fieldH;
    @FXML
    private TextField fieldI;
    @FXML
    private TextField fieldJ;
    @FXML
    private TextField fieldK;
    @FXML
    private TextField fieldL;
    @FXML
    private TextField fieldM;
    @FXML
    private TextField fieldN;
    @FXML
    private TextField fieldO;
    @FXML
    private TextField fieldP;
    @FXML
    private TextField fieldQ;
    @FXML
    private TextField fieldR;
    @FXML
    private TextField fieldS;
    @FXML
    private TextField fieldT;
    @FXML
    private TextField fieldU;
    @FXML
    private TextField fieldV;
    @FXML
    private TextField fieldX;
    @FXML
    private TextField fieldY;
    @FXML
    private TextField fieldW;
    @FXML
    private TextField fieldZ;
    
    @FXML
    private ListView<String> stackList;  
    
    private List<ComplexNumber> varList;
    
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
                    
                } else if (input.matches("[-+]j")) {
                    immaginary = input.startsWith("-") ? -1.0 : 1.0;
                } 
        
        re = real;
        im = immaginary;
        return new ComplexNumber(re, im);
    }
    
    
    private boolean isComplexNumber(String input) {
        
        return (input.matches("[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?[+-]?\\d*\\.?\\d*[jJ]?"));
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
    
        
        FXMLPickVarController controller2;
    
    @FXML
    private void btnSelectVarAction(ActionEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/it/unisa/diem/ids/project/view/FXMLPickVar.fxml"));
        Parent root2 = loader2.load();
        FXMLPickVarController pickVar = loader2.getController();        
        
        Scene scene = new Scene(root2); 
        Stage stage = new Stage();
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.WINDOW_MODAL);
        scene.setFill(Color.TRANSPARENT);
        
        stage.setScene(scene);
        
        // inizializzo il controller che passo a 
        pickVar.initController1(this);
        
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
        outputLabel.setText(clear());
               
        displayTabView();
        
        displayStackView();
        
        tabVarPane.setVisible(false);
        
    }    
    
    public void displayTabView() {
     
        for (char lettera = 'a'; lettera <= 'z'; lettera++) {
            String nomeCampo = "field" + Character.toUpperCase(lettera);

            try {
                TextField campo = (TextField) CalculatorController.class.getDeclaredField(nomeCampo).get(this);
                if (model.getModelVariables().elementFromChar(lettera) != null) {
                    campo.setText(model.getModelVariables().elementFromChar(lettera).toString());
                } else {
                    campo.setText("");
                }
            } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace(); 
            }
        }       
    }
    
    public void displayOutputView(ComplexNumber c) {
        outputLabel.setText(c.toString());
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


//Funzioni sulle variabili 
    @FXML
    private void btnAssignVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                model.modelAllocation(input.charAt(0));
                displayStackView();
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
        
        displayTabView();
    }
 
    @FXML
    private void btnPushVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                model.modelPushVar(input.charAt(0));
                displayStackView();
            } catch (VariableNotInitializedException ex) {
                showException("Error: " + ex.getMessage());
            }
        }else
            try {
                throw new SyntaxException("String not valid as a variable");
        } catch (SyntaxException ex) {
            showException("Error : " + ex.getMessage());
        }
        
        displayTabView();
    }

    @FXML
    private void btnAddVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                displayOutputView(model.modelAddVar(input.charAt(0)));
                displayStackView();
            } catch (InsufficientElementException ex) {
                showException("Error: " + ex.getMessage());
            } catch (VariableNotInitializedException ex){
                showException("Error: " + ex.getMessage());
            }
        }else
            try {
                throw new SyntaxException("String not valid as a variable");
        } catch (SyntaxException ex) {
            showException("Error : " + ex.getMessage());
        }
        displayTabView();
    }

    @FXML
    private void btnSubVarAction(ActionEvent event) {
        
        String input = getInput();
        if(input.matches("[a-z]")){
            try {
                displayOutputView(model.modelSubVar(input.charAt(0)));
                displayStackView();
            } catch (InsufficientElementException ex) {
                showException("Error: " + ex.getMessage());
            } catch (VariableNotInitializedException ex){
                showException("Error: " + ex.getMessage());
            }
        }else
            try {
                throw new SyntaxException("String not valid as a variable");
        } catch (SyntaxException ex) {
            showException("Error : " + ex.getMessage());
        }
        displayTabView();
    }

    
 //
    
    
    @FXML
    private void btnSwapAction(ActionEvent event) throws InsufficientElementException {
        try{
            model.modelSwap();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnDupAction(ActionEvent event) throws InsufficientElementException {
        try{
            model.modelDup();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnOverAction(ActionEvent event) throws InsufficientElementException {
        try{
            model.modelOver();
            displayStackView();
        }catch(InsufficientElementException e){
            showException("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnClearAction(ActionEvent event) {
        model.modelClear();
        displayStackView();
    }

    @FXML
    private void btnDropAction(ActionEvent event) throws InsufficientElementException{
        try {
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
                            displayOutputView(model.modelAdd());
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "-":
                        try{
                            displayOutputView(model.modelSub());
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "×":
                        try{
                            displayOutputView(model.modelMultiply());
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "÷":
                        try{
                            displayOutputView(model.modelDiv());
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }catch(ArithmeticException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "±":
                        try{
                            displayOutputView(model.modelReverseSign());
                            displayStackView();
                        }catch(InsufficientElementException e){
                            showException("Error: " + e.getMessage());
                        }
                        break;
                    case "√":
                        try{
                            displayOutputView(model.modelSqrt());
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
    
    public void insertVar(String var) {
        setInput(clear());
        setInput(var);
    }

    @FXML
    private void btnTopCalcAction(ActionEvent event) {
        // nascondo il pannello delle var
        tabVarPane.setVisible(false);
        
        // rendo attivo il bottone var e disattivo quello della calcolatrice
        btnTopVar.setStyle("-fx-background-color:  #898989; -fx-background-radius: 0 0 18 18;");
        btnTopCalc.setStyle("-fx-background-color: #f5faff; -fx-background-radius: 0 0 18 18;");
    }

    @FXML
    private void btnTopVarAction(ActionEvent event) {
        
        // mostro il pannello delle var
        tabVarPane.setVisible(true);
        
        // rendo attivo il bottone var e disattivo quello della calcolatrice
        btnTopCalc.setStyle("-fx-background-color:  #898989; -fx-background-radius: 0 0 18 18;");
        btnTopVar.setStyle("-fx-background-color: #f5faff; -fx-background-radius: 0 0 18 18;");
    }
    
}