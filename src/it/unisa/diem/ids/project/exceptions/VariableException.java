/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.ids.project.exceptions;

/**
 *
 * @author andre
 */
public class VariableException extends CalculatorException {

    /**
     * Creates a new instance of <code>VariableException</code> without detail
     * message.
     */
    public VariableException() {
    }

    /**
     * Constructs an instance of <code>VariableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VariableException(String msg) {
        super(msg);
    }
}
