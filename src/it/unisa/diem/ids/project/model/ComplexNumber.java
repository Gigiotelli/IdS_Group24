/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import java.util.Locale;

/**
 *
 * @author Gigi
 */
public class ComplexNumber implements ComplexNumberOperation{
    
    private double re;
    private double im;
    
    // COSTRUTTORE
    public ComplexNumber(double re, double im){
        this.re=re;
        this.im=im;
    }
    
    // TO STRING
    @Override
    public String toString() {
        if(im!=0) 
            return re + (im>0 ? "+":"") + im + "j"; 
        return re + ""; 
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
    
    // METODI PER LE FUNZIONALITA ARITMETICHE INDIVIDUALI 
    @Override
    public ComplexNumber add(ComplexNumber c) {
        
        double newRe = this.re + c.re;
        double newIm = this.im + c.im;
        
        return new ComplexNumber(newRe, newIm);
    }

    @Override
    public ComplexNumber sub(ComplexNumber c) {
        
        double newRe = this.re - c.re;
        double newIm = this.im - c.im;
        
        return new ComplexNumber(newRe, newIm);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber c) {
        
        double newRe = this.re * c.re - this.im * c.im;     //moltiplicazione delle parti reali e immaginarie (j^2 è reale)
        double newIm = this.re * c.im + this.im * c.re;     //termini con coefficente immaginario
        
        String formattedRe = String.format(Locale.US, "%.3f", newRe);
        String formattedIm = String.format(Locale.US, "%.3f", newIm);

        return new ComplexNumber(Double.parseDouble(formattedRe), Double.parseDouble(formattedIm));
    }

    @Override
    public ComplexNumber div(ComplexNumber c) {            //   a+bj/c+dj=(ac+bd)/(c^2+d^2)+j⋅(bc−ad)/(c^2+d^2) formula divisione di numeri complessi, entrambi 
      
        double den = c.re * c.re + c.im * c.im;   //denominatore
        
         if (den == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        
        double newRe = (this.re * c.re + this.im * c.im) / den;
        double newIm = (this.im * c.re - this.re * c.im) / den;

        String formattedRe = String.format(Locale.US, "%.3f", newRe);
        String formattedIm = String.format(Locale.US, "%.3f", newIm);

        return new ComplexNumber(Double.parseDouble(formattedRe), Double.parseDouble(formattedIm));
    }

    @Override
    public ComplexNumber sqrt() {
     
        int sign;
        if(im >= 0)
            sign = 1;
        else
            sign = -1;
        
        double r = Math.sqrt(this.re * this.re + this.im * this.im);  //applicazione della formula di De Moivre
        double newRe = Math.sqrt((r + this.re) / 2);
        double newIm = Math.sqrt((r - this.re) / 2) * sign;
        
        String formattedRe = String.format(Locale.US, "%.3f", newRe);
        String formattedIm = String.format(Locale.US, "%.3f", newIm);

        return new ComplexNumber(Double.parseDouble(formattedRe), Double.parseDouble(formattedIm));
    }

    @Override
    public ComplexNumber reverseSign() {
        
        double newRe = this.re * -1;
        double newIm = this.im * -1;
        
        return new ComplexNumber(newRe, newIm);
    }
    
}
