/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author Gigi
 */
public class ModelStack implements StackOperation {
    private Stack<ComplexNumber> stack;
    
    // COSTRUTTORE
    public ModelStack(){
        this.stack= new Stack();
    }
    
    // GETTER STACK
    public Stack<ComplexNumber> getStack() {
        return stack;
    }    
    
    // TO STRING
    @Override
    public String toString() {
        return stack.toString();
    }
    
    public ObservableList<String> toStringList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        
        for(int i=0;i<stack.size();i++)
            list.add(stack.get(i).toString());
        
        return list;
    }
    
    
    // METODI DELL'INTERFACCIA
    @Override
    public void clear() {  //richiama il metodo clear della classe Vector<E> estesa da Stack<E>
        stack.clear();
    }

    @Override
    public void drop() throws InsufficientElementException{  
        if (!stack.isEmpty())
            stack.pop();
        else
             throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }

    @Override
    public void dup() throws InsufficientElementException{  
        if (!stack.isEmpty())
            stack.push(stack.peek());  //il metodo peek guarda all'elemento in cima allo stack senza rimuoverlo
        else
             throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }

    @Override
    public void swap() throws InsufficientElementException{
        if (stack.size() >= 2){
            ComplexNumber lastElem = stack.pop();
            ComplexNumber secondLastElem = stack.pop();
            stack.push(lastElem);
            stack.push(secondLastElem);
        }
        else
            throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }

    @Override
    public void over() throws InsufficientElementException{  //inserisce una copia del penultimo elemento presente nello stack in cima allo stack
        if (stack.size() >= 2) {
            ComplexNumber secondLastElem = stack.get(stack.size() - 2);
            stack.push(secondLastElem);
        }
        else
            throw new InsufficientElementException("Errore: numero elementi insufficiente");
    }
    
}
