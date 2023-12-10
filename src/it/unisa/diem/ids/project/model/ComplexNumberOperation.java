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
public interface ComplexNumberOperation {
    
    public ComplexNumber add(ComplexNumber c);
    public ComplexNumber sub(ComplexNumber c);  
    public ComplexNumber multiply(ComplexNumber c);
    public ComplexNumber div(ComplexNumber c);
    public ComplexNumber sqrt();
    public ComplexNumber reverseSign();
}
