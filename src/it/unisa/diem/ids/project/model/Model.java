/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;
import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import java.util.Map;
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
    
    public ModelStack getModelStack(){
        return stack;
    }
    
    public ComplexNumber modelAdd() throws InsufficientElementException{ 
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() < 2){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c1= s.pop();
        ComplexNumber c2= s.pop();
        s.push(c1.add(c2));
        return c1.add(c2);
    }
    
    public ComplexNumber modelSub() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() < 2){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c1= s.pop();
        ComplexNumber c2= s.pop();
        s.push(c1.sub(c2));
        return c1.sub(c2);
    }
    
    public ComplexNumber modelMultiply() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() < 2){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c1= s.pop();
        ComplexNumber c2= s.pop();
        s.push(c1.multiply(c2));
        return c1.multiply(c2);
    }
    
    public ComplexNumber modelDiv() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.size() < 2){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c1= s.pop();
        ComplexNumber c2= s.pop();
        s.push(c1.div(c2));
        return c1.div(c2);
    }
    
    public ComplexNumber modelSqrt() throws InsufficientElementException{ 
        Stack<ComplexNumber> s= stack.getStack();
        if (s.isEmpty()){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c= s.pop();
        s.push(c.sqrt());
        return c.sqrt();
    }
    
    public ComplexNumber modelReverseSign() throws InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.isEmpty()){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c= s.pop();
        s.push(c.reverseSign());
        return c.reverseSign();
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
        if (s.isEmpty()){
            throw new InsufficientElementException("Invalid number of elements in Stack");
            
        }
        ComplexNumber c= s.pop();
        variables.allocation(c, v);
    }
    
    public void modelPushVar(Character v) throws VariableNotInitializedException{
        Stack<ComplexNumber> s= stack.getStack();
        ComplexNumber c= variables.pushVar(v);
        s.push(c);
    }
    
    public ComplexNumber modelAddVar(Character v) throws VariableNotInitializedException, InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.isEmpty()){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c= s.pop();
        ComplexNumber addVar= variables.addVar(c, v);
        return addVar;
    }
    
    public ComplexNumber modelSubVar(Character v) throws VariableNotInitializedException, InsufficientElementException{
        Stack<ComplexNumber> s= stack.getStack();
        if (s.isEmpty()){
            throw new InsufficientElementException("Invalid number of elements in Stack");
        }
        ComplexNumber c= s.pop();
        ComplexNumber subVar= variables.subVar(c, v);
        return subVar;
    }

    public ModelVariables getModelVariables(){
        return variables;
    }
}
