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
public class ComplexNumber implements ComplexNumberOperation{
    
    private double re;
    private double im;
    
    // COSTRUTTORE
    public ComplexNumber(){
        
    }
    
    // TO STRING
    @Override
    public String toString() {
        return "ComplexNumber{" + "re=" + re + ", im=" + im + '}';
    }
    
    // GETTERS AND SETTERS
    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
    
    // METODI DELL'INTERFACCIA
    @Override
    public ComplexNumber add(ComplexNumber c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexNumber sub(ComplexNumber c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexNumber multiply(ComplexNumber c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexNumber div(ComplexNumber c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexNumber sqrt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexNumber reverseSign() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
