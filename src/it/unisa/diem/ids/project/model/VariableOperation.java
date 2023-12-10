/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

/**
 *
 * @author Gigi
 */
public interface VariableOperation {
    
    public ComplexNumber allocation(ComplexNumber c);
    
    public void pushVar();
    
    public ComplexNumber addVar(ComplexNumber c);
    
    public ComplexNumber subVar(ComplexNumber c);
}
