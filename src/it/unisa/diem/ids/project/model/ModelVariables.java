/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;



import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Gigi
 */
public class ModelVariables implements VariableOperation {
    private final Map<Character, ComplexNumber> variables;
    
    // COSTRUTTORE
    public ModelVariables() {
        variables = new HashMap<>();
        for(Character ch = 'a'; ch <= 'z'; ++ch)
            variables.put(ch, null);
    }
    
    
    // TO STRING
    @Override
    public String toString() {
        return variables.toString();                             //richiama il toString di HashMap, che utilizza quello di ComplexNumber iterativamente;
    }
    
    
    // METODI DELL'INTERFACCIA
    @Override
    public void allocation(ComplexNumber c, Character v) {
        variables.put(v, c);                                  //mette il valore dallo stack nella variabile della mappa, da usare in super;
    }

    @Override
    public ComplexNumber pushVar(Character v) throws VariableNotInitializedException {
        ComplexNumber c = variables.remove(v);                //preleva numero dalla mappa e lo restituisce, da utilizzare nella super;
        if(c==null)
            throw new VariableNotInitializedException("Variable is not initialized");
        return c;
    }

  
    @Override
    public ComplexNumber addVar(ComplexNumber c, Character v) throws VariableNotInitializedException{
        ComplexNumber x = variables.remove(v);                 //prelevo il numero dalla mappa
        if(x==null)                                          //controllo sull'inizializzazione della variabile
                throw new VariableNotInitializedException("Variable is not initialized");        
        x = x.add(c);
        variables.put(v, x);               
        return x;
    }

    
    @Override
    public ComplexNumber subVar(ComplexNumber c, Character v) throws VariableNotInitializedException {
        ComplexNumber x = variables.remove(v);                 //prelevo il numero dalla mappa
        if(x==null)                                          //controllo sull'inizializzazione della variabile
                throw new VariableNotInitializedException("Variable is not initialized");        
        x = x.sub(c);
        variables.put(v, x);               
        return x;
    }
    
}
