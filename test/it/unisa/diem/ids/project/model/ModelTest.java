/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import it.unisa.diem.ids.project.exceptions.VariableNotInitializedException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffi
 */
public class ModelTest {
    
    private double delta= 0.001;
    
    public ModelTest() {
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
     * Test of modelAdd method, of class Model.
     */
    @Test
    public void testModelAdd() throws Exception {
        System.out.println("modelAdd");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelAdd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelSub method, of class Model.
     */
    @Test
    public void testModelSub() throws Exception {
        System.out.println("modelSub");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelSub();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelMultiply method, of class Model.
     */
    @Test
    public void testModelMultiply() throws Exception {
        System.out.println("modelMultiply");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelMultiply();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelDiv method, of class Model.
     */
    @Test
    public void testModelDiv() throws Exception {
        System.out.println("modelDiv");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelDiv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelSqrt method, of class Model.
     */
    @Test
    public void testModelSqrt() throws Exception {
        System.out.println("modelSqrt");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelSqrt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelReverseSign method, of class Model.
     */
    @Test
    public void testModelReverseSign() throws Exception {
        System.out.println("modelReverseSign");
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelReverseSign();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelAllocation method, of class Model.
     */
    @Test // Test Case 1: Preleva l'ultimo elemento dello stack e lo carica nella mappa delle variabili
    public void testModelAllocation1() throws Exception {
        System.out.println("modelAllocation");
        
        Character v = 'a';
        ComplexNumber c = new ComplexNumber(1,1);
        Model instance = new Model();
        
        ComplexNumber expResult = new ComplexNumber(1,1);        
                
        instance.getModelStack().getStack().push(c); 
        
        int numElemBefore = instance.getModelStack().getStack().size();
        instance.modelAllocation(v);
        int numElemAfter = instance.getModelStack().getStack().size();
        
        ComplexNumber result = instance.getModelVariables().getVariables().get(v);
        
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
        assertEquals(numElemBefore - 1, numElemAfter);
    }

    @Test // Test Case 2: Eccezione elementi nello stack insufficienti
    public void testModelAllocation2() throws Exception {
        System.out.println("modelAllocation");
        
        Character v = 'a';
        Model instance = new Model();
        
        // Verifica se sono presenti sufficienti elementi nello stack
        assertThrows(InsufficientElementException.class, () -> {
            instance.modelAllocation(v);
        });
    }
    
    /**
     * Test of modelPushVar method, of class Model.
     */
    @Test // Test Case 1: Pusha il contenuto della variabile 'a' nello stack
    public void testModelPushVar1() throws Exception {
        System.out.println("modelPushVar");
        
        Character v = 'a';
        ComplexNumber c = new ComplexNumber(1,1);
        Model instance = new Model();
        instance.getModelVariables().getVariables().put(v, c);
        
        int numElemBefore = instance.getModelStack().getStack().size(); 
        
        instance.modelPushVar(v);
        
        int numElemAfter = instance.getModelStack().getStack().size();
        
        assertEquals(instance.getModelVariables().getVariables().get(c), null);
        assertEquals(numElemBefore + 1, numElemAfter);
    }
    
    @Test // Test Case 2: Eccezione push di una variabile con valore null
    public void testModelPushVar2() throws Exception {
        System.out.println("modelPushVar");
        
        Character v = 'a';
        Model instance = new Model();
          
        // Verifica se la variabile non è stata inizializzata
        assertThrows(VariableNotInitializedException.class, () -> {
            instance.modelPushVar(v);
        });
    }

    /**
     * Test of modelAddVar method, of class Model.
     */
    @Test // Test Case 1: Somma il primo elemento dello stack alla variabile 'a'
    public void testModelAddVar1() throws Exception {
        System.out.println("modelAddVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        // Numero complesso x: elemento presente nella variabile 'a'
        ComplexNumber x = new ComplexNumber(3,3);
        Model instance = new Model();
        instance.getModelStack().getStack().push(x);
        instance.getModelVariables().getVariables().put(v, c);
        ComplexNumber expResult = new ComplexNumber(4,4);
        
        int numElemBefore = instance.getModelStack().getStack().size(); 
        
        ComplexNumber result = instance.modelAddVar(v);
        
        int numElemAfter = instance.getModelStack().getStack().size();
        
        assertEquals(numElemBefore - 1,numElemAfter);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Eccezione variabile non inizializzata
    public void testModelAddVar2() throws Exception {
        System.out.println("modelAddVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        Model instance = new Model();
        instance.getModelStack().getStack().push(c);
             
        // Verifica se la variabile non è stata inizializzata
        assertThrows(VariableNotInitializedException.class, () -> {
            ComplexNumber result = instance.modelAddVar(v);
        });
    }
    
    
    @Test // Test Case 3: Eccezione elementi nello stack insufficienti
    public void testModelAddVar3() throws Exception {
        System.out.println("modelAddVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        Model instance = new Model();
        instance.getModelVariables().getVariables().put(v, c);
             
        // Verifica se sono presenti sufficienti elementi nello stack
        assertThrows(InsufficientElementException.class, () -> {
            ComplexNumber result = instance.modelAddVar(v);
        });
    }

    /**
     * Test of modelSubVar method, of class Model.
     */
    @Test // Test Case 1: Sottrae il primo elemento dello stack dalla variabile 'a'
    public void testModelSubVar1() throws Exception {
        System.out.println("modelSubVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        // Numero complesso x: elemento presente nella variabile 'a'
        ComplexNumber x = new ComplexNumber(3,3);
        Model instance = new Model();
        instance.getModelStack().getStack().push(x);
        instance.getModelVariables().getVariables().put(v, c);
        
        ComplexNumber expResult = new ComplexNumber(-2,-2);
        
        int numElemBefore = instance.getModelStack().getStack().size(); 
            
        ComplexNumber result = instance.modelSubVar(v);
        
        int numElemAfter = instance.getModelStack().getStack().size();
        
        assertEquals(numElemBefore - 1,numElemAfter);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Eccezione variabile non inizializzata
    public void testModelSubVar2() throws Exception {
        System.out.println("modelSubVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        Model instance = new Model();
        instance.getModelStack().getStack().push(c);
             
        // Verifica se la variabile non è stata inizializzata
        assertThrows(VariableNotInitializedException.class, () -> {
            ComplexNumber result = instance.modelSubVar(v);
        });
    }
    
    
    @Test // Test Case 3: Eccezione elementi nello stack insufficienti
    public void testModelSubVar3() throws Exception {
        System.out.println("modelSubVar");
        
        Character v = 'a';
        
        // Numero complesso c: elemento presente nell'ultima posizione dello stack
        ComplexNumber c = new ComplexNumber(1,1);
        
        Model instance = new Model();
        instance.getModelVariables().getVariables().put(v, c);
             
        // Verifica se sono presenti sufficienti elementi nello stack
        assertThrows(InsufficientElementException.class, () -> {
            ComplexNumber result = instance.modelSubVar(v);
        });
    }
}
