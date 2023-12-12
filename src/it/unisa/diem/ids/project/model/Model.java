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
    
    public ComplexNumber modelAdd() throws InsufficientElementException{ 
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() >= 2){
            ComplexNumber c1= (ComplexNumber)s.pop();
            ComplexNumber c2= (ComplexNumber)s.pop();
            ComplexNumber sum= c1.add(c2);
            return sum;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelSub() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() >= 2){
            ComplexNumber c1= (ComplexNumber)s.pop();
            ComplexNumber c2= (ComplexNumber)s.pop();
            ComplexNumber sub= c1.sub(c2);
            return sub;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelMultiply() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() >= 2){
            ComplexNumber c1= (ComplexNumber)s.pop();
            ComplexNumber c2= (ComplexNumber)s.pop();
            ComplexNumber prod= c1.multiply(c2);
            return prod;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelDiv() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() >= 2){
            ComplexNumber c1= (ComplexNumber)s.pop();
            ComplexNumber c2= (ComplexNumber)s.pop();
            ComplexNumber div= c1.div(c2);
            return div;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelSqrt() throws InsufficientElementException{ 
        Stack<ComplexNumber> s= stack.getStack();
        if (!s.isEmpty()){
            ComplexNumber c= (ComplexNumber)s.pop();
            ComplexNumber sqrt= c.sqrt();
            return sqrt;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelReverseSign() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (!s.isEmpty()){
            ComplexNumber c= (ComplexNumber)s.pop();
            ComplexNumber reverseSign= c.reverseSign();
            return reverseSign;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
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
    
    public void modelAllocation(Character v) throws InsufficientElementException{ 
        Stack<ComplexNumber> s= stack.getStack(); 
        if (!s.isEmpty()){
            ComplexNumber c=(ComplexNumber) s.pop();
            variables.allocation(c, v);
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public void modelPushVar(Character v) throws VariableNotInitializedException{
        Stack<ComplexNumber> s= stack.getStack();
        ComplexNumber c= variables.pushVar(v);
        s.push(c);
    }
    
    public ComplexNumber modelAddVar(Character v) throws VariableNotInitializedException, InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (!s.isEmpty()){
            ComplexNumber c=(ComplexNumber) s.pop();
            ComplexNumber addVar= variables.addVar(c, v);
            return addVar;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
    public ComplexNumber modelSubVar(Character v) throws VariableNotInitializedException, InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (!s.isEmpty()){
            ComplexNumber c=(ComplexNumber) s.pop();
            ComplexNumber subVar= variables.subVar(c, v);
            return subVar;
        }
        throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
}
