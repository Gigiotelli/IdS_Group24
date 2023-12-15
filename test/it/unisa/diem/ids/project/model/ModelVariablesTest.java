/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gigi
 */
public class ModelVariablesTest {
    
    private double delta= 0.001;
    
    public ModelVariablesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of allocation method, of class ModelVariables.
     */
    @Test // Test Case 1: Allocazione numero complesso associato alla variabile 'a'
    public void testAllocation1() {
        System.out.println("allocation");
        
        ModelVariables instance = new ModelVariables();
        ComplexNumber c = new ComplexNumber(1,1);
        Character v = 'a';
        
        instance.allocation(c, v);
        
        assertTrue(instance.getVariables().containsKey(v));
        assertEquals(c, instance.getVariables().get(v));
    }
    
    @Test // Test Case 2: Allocazione numero complesso associato alla variabile 'x'
    public void testAllocation2() {
        System.out.println("allocation");
        
        ModelVariables instance = new ModelVariables();
        ComplexNumber c = new ComplexNumber(1,1);
        Character v = 'x';
        
        instance.allocation(c, v);
        
        assertTrue(instance.getVariables().containsKey(v));
        assertEquals(c, instance.getVariables().get(v));
    }
    
    @Test // Test Case 3: Allocazione numero complesso associato a una variabile già valorizzata 'z'
    public void testAllocation3() {
        System.out.println("allocation");

        ModelVariables instance = new ModelVariables();
        ComplexNumber initialComplexNumber = new ComplexNumber(1, 1);
        Character v = 'z';

        instance.allocation(initialComplexNumber, v);

        // Nuovo numero complesso associato alla stessa chiave
        ComplexNumber newComplexNumber = new ComplexNumber(3, 3);
        instance.allocation(newComplexNumber, v);

        assertTrue(instance.getVariables().containsKey(v));
        assertEquals(newComplexNumber, instance.getVariables().get(v));
    }
    
    /**
     * Test of pushVar method, of class ModelVariables.
     */
    @Test // Test Case 1: Rimuove il contenuto della variabile 'a', restituendo il valore rimosso
    public void testPushVar1() throws Exception {
        System.out.println("pushVar");
        
        Character v = 'a';
        ComplexNumber c = new ComplexNumber(1,1);
        ModelVariables instance = new ModelVariables();
        instance.getVariables().put(v, c);
        
        ComplexNumber expResult = new ComplexNumber(1,1);
        ComplexNumber result = instance.pushVar(v);
        
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Exception quando il contenuto della variabile è null
    public void testPushVar2() throws Exception {
        System.out.println("pushVar");
        
        Character v = 'a';
        ModelVariables instance = new ModelVariables();
        instance.getVariables().put(v, null);
        
        // Verifica se il contenuto della variabile è null
        assertThrows(VariableNotInitializedException.class, () -> {
            ComplexNumber result = instance.pushVar(v);
        });
    }

    /**
     * Test of addVar method, of class ModelVariables.
     */
    @Test // Test Case 1: Somma il contenuto della variabile 'a' con il numero complesso passato come parametro
    public void testAddVar1() throws Exception {
        System.out.println("addVar");
        
        Character v = 'a';
        ModelVariables instance = new ModelVariables();
        
        // Numero complesso c: parametro
        ComplexNumber c = new ComplexNumber(2,2);
        // Numero complesso x: prelevato dalla variabile 'a'  
        ComplexNumber x = new ComplexNumber(1,1); 
        
        instance.getVariables().put(v, x);
        
        ComplexNumber expResult = new ComplexNumber(3,3);
        ComplexNumber result = instance.addVar(c, v);
        
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Eccezione se la variabile non è inizializzata
    public void testAddVar2() throws Exception {
        System.out.println("addVar");
        
        Character v = 'a';
        ModelVariables instance = new ModelVariables();
        ComplexNumber c = new ComplexNumber(1,1);
                
        // Verifica se la variabile non è stata inizializzata
        assertThrows(VariableNotInitializedException.class, () -> {
            ComplexNumber result = instance.addVar(c, v);
        });
    }
    
    /**
     * Test of subVar method, of class ModelVariables.
     */
    @Test // Test Case 1: Sottrae al contenuto della variabile 'a' il numero complesso passato come parametro
    public void testSubVar1() throws Exception {
        System.out.println("subVar");
        
        Character v = 'a';
        ModelVariables instance = new ModelVariables();
        
        // Numero complesso c: parametro
        ComplexNumber c = new ComplexNumber(2,2);
        // Numero complesso x: prelevato dalla variabile 'a'  
        ComplexNumber x = new ComplexNumber(3,3); 
        
        instance.getVariables().put(v, x);
        
        ComplexNumber expResult = new ComplexNumber(1,1);
        ComplexNumber result = instance.subVar(c, v);
        
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Eccezione se la variabile non è inizializzata
    public void testSubVar2() throws Exception {
        System.out.println("addVar");
        
        Character v = 'a';
        ModelVariables instance = new ModelVariables();
        ComplexNumber c = new ComplexNumber(1,1);
                
        // Verifica se la variabile non è stata inizializzata
        assertThrows(VariableNotInitializedException.class, () -> {
            ComplexNumber result = instance.addVar(c, v);
        });
    }
}
