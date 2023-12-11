/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.ids.project.exceptions;

/**
 *
 * @author andre
 */
public class InsufficientElementException extends CalculatorException {

    /**
     * Creates a new instance of <code>InsufficientElementException</code>
     * without detail message.
     */
    public InsufficientElementException() {
    }

    /**
     * Constructs an instance of <code>InsufficientElementException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InsufficientElementException(String msg) {
        super(msg);
    }
}
