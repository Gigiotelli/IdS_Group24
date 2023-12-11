/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;

/**
 *
 * @author Gigi
 */
public interface StackOperation {
    
    public void clear();
    public void drop();
    public void dup();
    public void swap() throws InsufficientElementException;
    public void over()throws InsufficientElementException;
}
