/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;
import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import java.util.Stack;

/**
 *
 * @author Gigi
 */
public class Model {
    ModelVariables variables;
    ModelStack stack;
    ComplexNumber number;
    
    public Model(){
        this.variables= new ModelVariables();
        this.stack= new ModelStack();
    }
    
    public ComplexNumber modelAdd(ComplexNumber c){ //farei 2 pop e toglierei il valore passato
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber sum= number.add(c);
        return sum;
    }
    
    public ComplexNumber modelSub(ComplexNumber c){
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber sub= number.sub(c);
        return sub;
    }
    
    public ComplexNumber modelMultiply(ComplexNumber c){
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber prod= number.multiply(c);
        return prod;
    }
    
    public ComplexNumber modelDiv(ComplexNumber c){
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber div= number.div(c);
        return div;
    }
    
    public ComplexNumber modelSqrt(){ 
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber sqrt= number.sqrt();
        return sqrt;
    }
    
    public ComplexNumber modelReverseSign(){
        Stack s= stack.getStack();
        number= (ComplexNumber)s.pop();
        ComplexNumber reverseSign= number.reverseSign();
        return reverseSign;
    }
    
    public void modelClear(){
        stack.clear();
    }
    
    public void modelDrop() throws InsufficientElementException{
        stack.drop();
    }
    
    public void modelDup() throws InsufficientElementException{
        stack.dup();
    }
    
    public void modelSwap()throws InsufficientElementException{
        stack.swap();
    }
    
    public void modelOver()throws InsufficientElementException{
        stack.over();
    }
    
    public void modelAllocation(Character v){ //volevo usare la pop per prelevare il ComplexNumber ma qui gielo passiamo già DIOPORCO
        Stack s= stack.getStack();            //l'ho tolto afammocc
        number=(ComplexNumber) s.pop();
        variables.allocation(number, v);        
    }
    
    public void modelPushVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        number= variables.pushVar(v);
        s.push(number);
    }
    
    public ComplexNumber modelAddVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        number=(ComplexNumber) s.pop();
        ComplexNumber addVar= variables.addVar(number, v);
        return addVar;
    }
    
    public ComplexNumber modelSubVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        number=(ComplexNumber) s.pop();
        ComplexNumber subVar= variables.subVar(number, v);
        return subVar;
    }
}
