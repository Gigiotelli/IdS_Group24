/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.ids.project.exceptions;

/**
 *
 * @author andre
 */
public class SyntaxException extends CalculatorException{

    /**
     * Creates a new instance of <code>SyntaxException</code> without detail
     * message.
     */
    public SyntaxException() {
    }

    /**
     * Constructs an instance of <code>SyntaxException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SyntaxException(String msg) {
        super(msg);
    }
}
