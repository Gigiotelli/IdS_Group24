/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.ids.project.model;

import it.unisa.diem.ids.project.exceptions.InsufficientElementException;
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
    @Test // Test Case 1: Somma di due elementi in cima allo stack (contiene almeno due elementi)
    public void testModelAdd1() throws Exception {
        System.out.println("modelAdd");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));
        model.getModelStack().getStack().push(new ComplexNumber(0.3, -4));
        int numElemBefore= model.getModelStack().getStack().size();
        
        ComplexNumber result = model.modelAdd();

        int numElemAfter= model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia diminuita di uno
        assertEquals(numElemBefore-1, numElemAfter);

        // Verifica che la somma sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(1.3, -3);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelAdd2() {
        System.out.println("modelAdd");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelAdd();
        });
    }

    @Test // Test Case 3: InsufficientElementException quando lo stack contiene meno di 2 elementi
    public void testModelAdd3() {
        System.out.println("modelAdd");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));

        assertThrows(InsufficientElementException.class, () -> {
            model.modelAdd();
        });
    }

    /**
     * Test of modelSub method, of class Model.
     */
    @Test // Test Case 1: Sottrazione di due elementi in cima allo stack (contiene almeno due elementi)
    public void testModelSub1() throws Exception {
        System.out.println("modelSub");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(2, 3));
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));
        int numElemBefore = model.getModelStack().getStack().size();

        ComplexNumber result = model.modelSub();

        int numElemAfter = model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia diminuita di uno
        assertEquals(numElemBefore - 1, numElemAfter);

        // Verifica che la sottrazione sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(-1, -2);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelSub2() {
        System.out.println("modelSub");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelSub();
        });
    }

    @Test // Test Case 3: InsufficientElementException quando lo stack contiene meno di 2 elementi
    public void testModelSub3() {
        System.out.println("modelSub");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));

        assertThrows(InsufficientElementException.class, () -> {
            model.modelSub();
        });
    }

    /**
     * Test of modelMultiply method, of class Model.
     */
    @Test // Test Case 1: Moltiplicazione di due elementi in cima allo stack (contiene almeno due elementi)
    public void testModelMultiply1() throws Exception {
        System.out.println("modelMultiply");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(2, 3));
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));
        int numElemBefore = model.getModelStack().getStack().size();

        ComplexNumber result = model.modelMultiply();

        int numElemAfter = model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia diminuita di uno
        assertEquals(numElemBefore - 1, numElemAfter);

        // Verifica che la moltiplicazione sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(-1, 5);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelMultiply2() {
        System.out.println("modelMultiply");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelMultiply();
        });
    }

    @Test // Test Case 3: InsufficientElementException quando lo stack contiene meno di 2 elementi
    public void testModelMultiply3() {
        System.out.println("modelMultiply");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));

        assertThrows(InsufficientElementException.class, () -> {
            model.modelMultiply();
        });
    }

    /**
     * Test of modelDiv method, of class Model.
     */
    @Test
    public void testModelDiv1() throws Exception {
        System.out.println("modelDiv");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(2, 3));
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));
        int numElemBefore = model.getModelStack().getStack().size();

        ComplexNumber result = model.modelDiv();

        int numElemAfter = model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia diminuita di uno
        assertEquals(numElemBefore - 1, numElemAfter);

        // Verifica che la divisione sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(0.385, -0.077);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelDiv2() {
        System.out.println("modelDiv");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelDiv();
        });
    }

    @Test // Test Case 3: InsufficientElementException quando lo stack contiene meno di 2 elementi
    public void testModelDiv3() {
        System.out.println("modelDiv");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(1, 1));

        assertThrows(InsufficientElementException.class, () -> {
            model.modelDiv();
        });
    }

    /**
     * Test of modelSqrt method, of class Model.
     */
    @Test // Test Case 1: Calcolo della radice quadrata di un numero complesso in cima allo stack (contiene almeno un elemento)
    public void testModelSqrt1() throws Exception {
        System.out.println("modelSqrt");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(-4, 0));
        int numElemBefore = model.getModelStack().getStack().size();

        ComplexNumber result = model.modelSqrt();

        int numElemAfter = model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia rimasta invariata
        assertEquals(numElemBefore, numElemAfter);

        // Verifica che la radice quadrata sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(0, 2);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelSqrt2() {
        System.out.println("modelSqrt");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelSqrt();
        });
    }

    /**
     * Test of modelReverseSign method, of class Model.
     */
    @Test // Test Case 1: Inversione del segno di un numero complesso in cima allo stack (contiene almeno un elemento)
    public void testModelReverseSign1() throws Exception {
        System.out.println("modelReverseSign");
        Model model = new Model();
        model.getModelStack().getStack().push(new ComplexNumber(2, -3));
        int numElemBefore = model.getModelStack().getStack().size();

        ComplexNumber result = model.modelReverseSign();

        int numElemAfter = model.getModelStack().getStack().size();
        // Verifica che la dimensione dello stack sia rimasta invariata
        assertEquals(numElemBefore, numElemAfter);

        // Verifica che l'inversione del segno sia stata eseguita correttamente
        ComplexNumber expectedResult = new ComplexNumber(-2, 3);
        assertEquals(expectedResult.getRe(), result.getRe(), delta);
        assertEquals(expectedResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: InsufficientElementException quando lo stack è vuoto
    public void testModelReverseSign2() {
        System.out.println("modelReverseSign");
        Model model = new Model();

        assertThrows(InsufficientElementException.class, () -> {
            model.modelReverseSign();
        });
    }

    /**
     * Test of modelAllocation method, of class Model.
     */
    @Test
    public void testModelAllocation() throws Exception {
        System.out.println("modelAllocation");
        Character v = null;
        Model instance = new Model();
        instance.modelAllocation(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelPushVar method, of class Model.
     */
    @Test
    public void testModelPushVar() throws Exception {
        System.out.println("modelPushVar");
        Character v = null;
        Model instance = new Model();
        instance.modelPushVar(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelAddVar method, of class Model.
     */
    @Test
    public void testModelAddVar() throws Exception {
        System.out.println("modelAddVar");
        Character v = null;
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelAddVar(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelSubVar method, of class Model.
     */
    @Test
    public void testModelSubVar() throws Exception {
        System.out.println("modelSubVar");
        Character v = null;
        Model instance = new Model();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.modelSubVar(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
