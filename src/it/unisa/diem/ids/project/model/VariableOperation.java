/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;

/**
 *
 * @author Gigi
 */
public interface VariableOperation {
    
    public void allocation(ComplexNumber c, Character v);
    
    public ComplexNumber pushVar(Character v) throws VariableNotInitializedException;
    
    public ComplexNumber addVar(ComplexNumber c, Character v) throws VariableNotInitializedException;
    
     public ComplexNumber subVar(ComplexNumber c, Character v) throws VariableNotInitializedException;
}
