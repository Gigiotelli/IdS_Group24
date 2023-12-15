/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
import java.util.Stack;
import javafx.collections.ObservableList;
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
public class ModelStackTest {
    
    private double delta= 0.001;
    
    public ModelStackTest() {
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
     * Test of clear method, of class ModelStack.
     */
    @Test // Test Case 1: Eliminazione di tutti gli elementi dallo stack
    public void testClear() {
        System.out.println("clear");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(0, 1));
        modelStack.getStack().push(new ComplexNumber(1.2, -2.5));
        modelStack.getStack().push(new ComplexNumber(-1.456, 257.3));
        modelStack.getStack().push(new ComplexNumber(-3.35, 0));
        modelStack.clear();
        assertTrue(modelStack.getStack().isEmpty());
    }

    /**
     * Test of drop method, of class ModelStack.
     */
    @Test // Test Case 1: Rimozione dell'elemento in cima allo stack(contiene un solo elemento)
    public void testDrop1() throws Exception {
        System.out.println("drop");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        
        modelStack.drop();
        
        assertTrue(modelStack.getStack().isEmpty()); //Verifica che lo stack sia vuoto
    }
    
    @Test // Test Case 2: Rimozione dell'elemento in cima allo stack(contiene più di un elemento)
    public void testDrop2() throws Exception {
        System.out.println("drop");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        modelStack.getStack().push(new ComplexNumber(0.3, -4));
        
        modelStack.drop();

        assertEquals(1, modelStack.getStack().size(), delta); //Verifica che ora la dimesione dello stack sia 1

        ComplexNumber expResult = new ComplexNumber(1, 1); //Il risultato atteso è il valore rimasto nello stack
        
        ComplexNumber result = modelStack.getStack().peek(); //Legge il valore rimasto nello stack

        assertEquals(expResult.getRe(), result.getRe(), delta); 
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 3: Exception quando lo stack è vuoto
    public void testDrop3() throws Exception{
        System.out.println("drop");
        ModelStack modelStack = new ModelStack();

        assertThrows(InsufficientElementException.class, () -> {
            modelStack.drop();
        });
    }
    
    /**
     * Test of dup method, of class ModelStack.
     */
    @Test // Test Case 1: Duplicazione dell'elemento in cima allo stack(contiene un solo elemento)
    public void testDup1() throws Exception {
        System.out.println("dup");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        
        modelStack.dup();
        
        assertEquals(2, modelStack.getStack().size()); //Verifica che ora la dimesione dello stack sia 2
        
        // Verifica che l'elemento in cima allo stack sia duplicato correttamente
        ComplexNumber expResult = new ComplexNumber(1, 1);
        ComplexNumber result = modelStack.getStack().peek();
        
        assertEquals(expResult.getRe(), result.getRe(), delta); 
        assertEquals(expResult.getIm(), result.getIm(), delta);
        
        //Nessun controllo sul valore presente nella penultima posizione poiché il metodo controlla il valore pushato attraverso la peek() della classe Stack
    }
    
    @Test // Test Case 2: Duplicazione dell'elemento in cima allo stack(contiene più di un elemento)
    public void testDup2() throws Exception {
        System.out.println("dup");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        modelStack.getStack().push(new ComplexNumber(0.3, -4));

        modelStack.dup();

        assertEquals(3, modelStack.getStack().size()); // Verifica che ora la dimensione dello stack sia 3

        // Verifica che l'elemento in cima allo stack sia duplicato correttamente
        ComplexNumber expResult = new ComplexNumber(0.3, -4);
        ComplexNumber result = modelStack.getStack().peek();

        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 3: exception quando lo stack è vuoto
    public void testDup3() throws Exception{
        System.out.println("dup");
        ModelStack modelStack = new ModelStack();

        assertThrows(InsufficientElementException.class, () -> {
            modelStack.dup();
        });
    }

    /**
     * Test of swap method, of class ModelStack.
     */
    @Test // Test Case 1: Scambio dei due elementi in cima allo stack(contiene almeno due elementi)
    public void testSwap1() throws Exception {
        System.out.println("swap");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        modelStack.getStack().push(new ComplexNumber(0.3, -4));

        modelStack.swap();

        // Verifica che la dimensione dello stack sia rimasta invariata
        assertEquals(2, modelStack.getStack().size());

        // Verifica che gli elementi in cima allo stack siano stati scambiati correttamente
        ComplexNumber expResultTop = new ComplexNumber(1, 1);
        ComplexNumber expResultSec = new ComplexNumber(0.3, -4);
        
        ComplexNumber topElem = modelStack.getStack().pop();
        ComplexNumber secElem = modelStack.getStack().pop();
        
        assertEquals(expResultTop.getRe(), topElem.getRe(), delta);
        assertEquals(expResultTop.getIm(), topElem.getIm(), delta);
        assertEquals(expResultSec.getRe(), secElem.getRe(), delta);
        assertEquals(expResultSec.getIm(), secElem.getIm(), delta);   
    }

    @Test // Test Case 2: Exception quando lo stack è vuoto
    public void testSwap2() {
        System.out.println("swap");
        ModelStack modelStack = new ModelStack();
        
        assertThrows(InsufficientElementException.class, () -> {
            modelStack.swap();
        });
    }

    @Test // Test Case 3: Exception quando lo stack contiene meno di 2 elementi
    public void testSwap3() {
        System.out.println("swap");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        
        assertThrows(InsufficientElementException.class, () -> {
            modelStack.swap();
        });
    }
    
    /**
     * Test of over method, of class ModelStack.
     */
    @Test // Test Case 1: Inserimento di una copia del penultimo elemento in cima allo stack (contiene almeno due elementi)
    public void testOver1() throws Exception {
        System.out.println("over");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));
        modelStack.getStack().push(new ComplexNumber(0.3, -4));

        modelStack.over();

        // Verifica che la dimensione dello stack sia aumentata di uno
        assertEquals(3, modelStack.getStack().size());

        // Verifica che la copia del penultimo elemento sia stata inserita correttamente in cima allo stack
        ComplexNumber expResultTop = new ComplexNumber(1, 1);
        ComplexNumber topElem = modelStack.getStack().pop();
        assertEquals(expResultTop.getRe(), topElem.getRe(), delta);
        assertEquals(expResultTop.getIm(), topElem.getIm(), delta);
    }

    @Test // Test Case 2: Exception quando lo stack è vuoto
    public void testOver2() {
        System.out.println("over");
        ModelStack modelStack = new ModelStack();

        assertThrows(InsufficientElementException.class, () -> {
            modelStack.over();
        });
    }

    @Test // Test Case 3: Exception quando lo stack contiene meno di 2 elementi
    public void testOver3() {
        System.out.println("over");
        ModelStack modelStack = new ModelStack();
        modelStack.getStack().push(new ComplexNumber(1, 1));

        assertThrows(InsufficientElementException.class, () -> {
            modelStack.over();
        });
    }
}
    
