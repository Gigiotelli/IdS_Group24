/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;



import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import java.util.Map;


/**
 *
 * @author Gigi
 */
public class ModelVariables implements VariableOperation {
    private Map<Character, ComplexNumber> variables;
    
    // COSTRUTTORE
    public ModelVariables() {
        
    }
    
    
    // TO STRING
    @Override
    public String toString() {
        return "ModelVariables{" + "variables=" + variables + '}';
    }
    
    
    // METODI DELL'INTERFACCIA
    @Override
    public ComplexNumber allocation(ComplexNumber c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pushVar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public ComplexNumber addVar(ComplexNumber c, Character v) throws VariableNotInitializedException{
        ComplexNumber x = variables.get(v);                 //prelevo il numero dalla mappa
        if(x==null)                                          //controllo sull'inizializzazione della variabile
                throw new VariableNotInitializedException();        
        x = x.add(c);
        variables.put(v, x);               
        return x;
    }

    
    public ComplexNumber subVar(ComplexNumber c, Character v) throws VariableNotInitializedException {
        ComplexNumber x = variables.get(v);                 //prelevo il numero dalla mappa
        if(x==null)                                          //controllo sull'inizializzazione della variabile
                throw new VariableNotInitializedException();        
        x = x.sub(c);
        variables.put(v, x);               
        return x;
    }
    
}
