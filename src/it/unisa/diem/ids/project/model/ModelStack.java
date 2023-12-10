/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import java.util.Stack;

/**
 *
 * @author Gigi
 */
public class ModelStack implements StackOperation {
    private Stack<ComplexNumber> stack;
    
    // COSTRUTTORE
    public ModelStack(){
        
    }
    
    // GETTER STACK
    public Stack<ComplexNumber> getStack() {
        return stack;
    }    
    
    // TO STRING
    @Override
    public String toString() {
        return "ModelStack{" + "stack=" + stack + '}';
    }
    
    
    // METODI DELL'INTERFACCIA
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void over() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
