/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.controller;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.SyntaxException;
import it.unisa.diem.ids.project.model.ComplexNumber;
import it.unisa.diem.ids.project.model.Model;
import it.unisa.diem.ids.project.view.View;

/**
 *
 * @author Gigi
 */
public class CalculatorController {
    private Model model;
    private View view;
    private String input;

    public CalculatorController(Model model, View view) {
        this.model = model;
        this.view = view;
        
    }
   
    
    
    
    
    public void enter(){
        
        String input= view.getInput();
        
        if(input!=null && !input.isEmpty()){
            try{
                performOperation(input);
           }catch(InsufficientElementException e){
               
           }catch(VariableNotInitializedException e){
               
           }catch(VariableException e){
               
           }catch(SyntaxException e){
               
           }catch(CalculatorException e){
               
           }catch(Exception e){
               
           }
          
       }
   }
   
    private void performOperation(String input) throws InsufficientElementException, SyntaxException, VariableNotInitializedException {
        switch (input) {
            case "+":
                model.modelAdd();
                break;
            case "-":
                model.modelSub();
                break;
            case "*":
                model.modelMultiply();
                break;
            case "/":
                model.modelDiv();
                break;
            case "+-":
                model.modelReverseSign();
                break;
            case "sqrt":
                model.modelSqrt();
                break;
            case "swap":
                model.modelSwap();
                break;
            case "dup":
                model.modelDup();
                break;
            case "over":
                model.modelOver();
                break;
            case "clear":
                model.modelClear();
                break;
            case "drop":
                model.modelDrop();
                break;
            case ">x":
                model.modelAllocation(/*carattere selezionato nel menu a tendina ricevuto da qualche metodo di view (getVariable per es)*/);
                break;
            case "<x":
                model.modelPushVar(/*come scritto sopra*/);
                break;
            case "+x":
                model.modelAddVar(/**/);
                break;
            case "-x":
                model.modelSubVar(/**/);
                break;
                
            default:
                if(isComplexNumber(input)){
                    ComplexNumber num = parseComplexNumber(input);
                    model.getModelStack().getStack().push(num);
                }
                    
    }

        }
    
    private boolean isComplexNumber(String input) {
        
        return input.matches("-?\\d+(\\.\\d+)?\\s*[-+]\\s*\\d+(\\.\\d+)?j");
}
    
    
    private ComplexNumber parseComplexNumber(String input) {
        
        String[] number = input.split("\\s*[-+]\\s*");
        double realPart = Double.parseDouble(number[0]);
        double imaginaryPart = Double.parseDouble(number[1].replace("j", ""));

        return new ComplexNumber(realPart, imaginaryPart);
    }
    }
    
