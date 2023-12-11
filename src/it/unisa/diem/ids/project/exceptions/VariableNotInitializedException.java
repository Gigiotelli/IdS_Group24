/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.ids.project.exceptions;

/**
 *
 * @author andre
 */
public class VariableNotInitializedException extends VariableException {

    /**
     * Creates a new instance of <code>VariableNotInitializedException</code>
     * without detail message.
     */
    public VariableNotInitializedException() {
    }

    /**
     * Constructs an instance of <code>VariableNotInitializedException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public VariableNotInitializedException(String msg) {
        super(msg);
    }
}
