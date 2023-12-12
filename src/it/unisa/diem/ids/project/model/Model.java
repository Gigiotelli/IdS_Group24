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
    private ModelVariables variables;
    private ModelStack stack;
    
    
    public Model(){
        this.variables= new ModelVariables();
        this.stack= new ModelStack();
    }
    
    public ComplexNumber modelAdd(){ 
        Stack s= stack.getStack();
        ComplexNumber c1= (ComplexNumber)s.pop();
        ComplexNumber c2= (ComplexNumber)s.pop();
        ComplexNumber sum= c1.add(c2);
        return sum;
    }
    
    public ComplexNumber modelSub(){
        Stack s= stack.getStack();
        ComplexNumber c1= (ComplexNumber)s.pop();
        ComplexNumber c2= (ComplexNumber)s.pop();
        ComplexNumber sub= c1.sub(c2);
        return sub;
    }
    
    public ComplexNumber modelMultiply(){
        Stack s= stack.getStack();
        ComplexNumber c1= (ComplexNumber)s.pop();
        ComplexNumber c2= (ComplexNumber)s.pop();
        ComplexNumber prod= c1.multiply(c2);
        return prod;
    }
    
    public ComplexNumber modelDiv(){
        Stack s= stack.getStack();
        ComplexNumber c1= (ComplexNumber)s.pop();
        ComplexNumber c2= (ComplexNumber)s.pop();
        ComplexNumber div= c1.div(c2);
        return div;
    }
    
    public ComplexNumber modelSqrt(){ 
        Stack s= stack.getStack();
        ComplexNumber c= (ComplexNumber)s.pop();
        ComplexNumber sqrt= c.sqrt();
        return sqrt;
    }
    
    public ComplexNumber modelReverseSign(){
        Stack s= stack.getStack();
        ComplexNumber c= (ComplexNumber)s.pop();
        ComplexNumber reverseSign= c.reverseSign();
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
    
    public void modelAllocation(Character v){ 
        Stack s= stack.getStack();            
        ComplexNumber c=(ComplexNumber) s.pop();
        variables.allocation(c, v);        
    }
    
    public void modelPushVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        ComplexNumber c= variables.pushVar(v);
        s.push(c);
    }
    
    public ComplexNumber modelAddVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        ComplexNumber c=(ComplexNumber) s.pop();
        ComplexNumber addVar= variables.addVar(c, v);
        return addVar;
    }
    
    public ComplexNumber modelSubVar(Character v) throws VariableNotInitializedException{
        Stack s= stack.getStack();
        ComplexNumber c=(ComplexNumber) s.pop();
        ComplexNumber subVar= variables.subVar(c, v);
        return subVar;
    }
}
