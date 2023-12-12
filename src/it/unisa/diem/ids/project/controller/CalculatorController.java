/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.controller;

/**
 *
 * @author Gigi
 */
public class CalculatorController {
    private boolean isOperator(String input) {
    switch (input) {
        case "+":
        case "-":
        case "*":
        case "/":
        case "+-":
        case "sqrt":
            return true;
        default:
            return false;
    }
}
