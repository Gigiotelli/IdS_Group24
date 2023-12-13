/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.controller;

import it.unisa.diem.ids.project.exceptions.CalculatorException;
import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.SyntaxException;
import it.unisa.diem.ids.project.exceptions.VariableException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import it.unisa.diem.ids.project.model.ComplexNumber;
import it.unisa.diem.ids.project.model.Model;

/**
 *
 * @author Gigi
 */
public class CalculatorControllerOLD {
    private Model model;
    private CalculatorController view;
    private String input;

    public CalculatorControllerOLD(Model model, CalculatorController view) {
        this.model = model;
        this.view = view;
        
        
    }
   
    
    
    
    
    public void enter(String input){
        
        //string extraction
        
        if(input!=null && !input.isEmpty()){
            try{
                performOperation(input);
           }catch(InsufficientElementException e){
               System.err.println("Error: Invalid number of elements in Stack");
           }catch(VariableNotInitializedException e){
               System.err.println("Error: Variable is not initialized");
           }catch(VariableException e){
               System.err.println("Error: Variable error");
           }catch(SyntaxException e){
               System.err.println("Error: Syntax error");
           }catch(CalculatorException e){
               System.err.println("Error: Application");
           }catch(Exception e){
               System.err.println("Error: Application");
           }
          
       }
   }
   
    private void performOperation(String input) throws InsufficientElementException, SyntaxException, VariableNotInitializedException, VariableException, CalculatorException {
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
                //model.modelAllocation(/*carattere selezionato nel menu a tendina ricevuto da qualche metodo di view (getVariable per es)*/);
                break;
            case "<x":
                //model.modelPushVar(/*come scritto sopra*/);
                break;
            case "+x":
                //model.modelAddVar(/**/);
                break;
            case "-x":
                //model.modelSubVar(/**/);
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
        double re = Double.parseDouble(number[0]);
        double im = Double.parseDouble(number[1].replace("j", ""));

        return new ComplexNumber(re, im);
    }
    }
    
