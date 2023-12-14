/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.ids.project.model;

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
public class ComplexNumberTest {
    
    private double delta= 0.001;
    
    public ComplexNumberTest() {
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
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test //Test Case 1: somma numeri reali
    public void testAdd1() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(-2, 0);
        ComplexNumber instance = new ComplexNumber(7, 0);
        ComplexNumber expResult = new ComplexNumber(5, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 2: somma numeri immaginari puri
    public void testAdd2() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(0, 5);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 3: somma numeri complessi generici
    public void testAdd3() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2.7, -5.03);
        ComplexNumber instance = new ComplexNumber(3.2, 6.91);
        ComplexNumber expResult = new ComplexNumber(5.9, 1.88);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 4: somma numeri complessi coniugati
    public void testAdd4() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(4, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 5: somma numeri complessi molto grandi
    public void testAdd5() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(10555554, -7111111);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 6: somma numero complesso e suo opposto
    public void testAdd6() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 7: somma numero complesso con lo 0
    public void testAdd7() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(0, 0);
        ComplexNumber expResult = new ComplexNumber(2, -5);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    /**
     * Test of sub method, of class ComplexNumber.
     */
    @Test //Test Case 1: differenza numeri reali
    public void testSub1() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-9, 0);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 2: differenza numeri immaginari puri
    public void testSub2() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(0, 9);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);   
    }
    
    @Test //Test Case 3: differenza numeri complessi generici
    public void testSub3() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.2, -6.91);
        ComplexNumber expResult = new ComplexNumber(0.5, -11.94);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);    
    }
    
    @Test //Test Case 4: differenza numeri complessi coniugati
    public void testSub4() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(0, -10);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 5: differenza numeri complessi molto grandi
    public void testSub5() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(-9444444, 8444443);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 6: differenza numero complesso e suo opposto
    public void testSub6() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(-4, 0);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 7: differenza numero complesso con lo 0
    public void testSub7() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(0, 0);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(-2, 5);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test //Test Case 1: moltiplicazione di numeri reali
    public void testMultiply1() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-14, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 2: moltiplicazione di numeri immaginari puri
    public void testMultiply2() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(14, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 3: moltiplicazione di numeri complessi generici
    public void testMultiply3() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.2, -6.91);
        ComplexNumber expResult = new ComplexNumber(43.39, -2.56);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 4: moltiplicazione di numeri complessi coniugati
    public void testMultiply4() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(29, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 5: moltiplicazione di numeri complessi molto grandi
    public void testMultiply5() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(1.0740728925927E13, 2.345676432099E12);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 6: moltiplicazione di un numero complesso per il suo opposto
    public void testMultiply6() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(21, 20);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 7: moltiplicazione di un numero complesso per lo 0
    public void testMultiply7() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(0, 0);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }


    /**
     * Test of div method, of class ComplexNumber.
     */
    @Test //Test Case 1: divisione di numeri reali
    public void testDiv1() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-3.5, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 2: divisione di numeri immaginari puri
    public void testDiv2() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(-3.5, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 3: divisione di numeri complessi generici
    public void testDiv3() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.2, -6.91);
        ComplexNumber expResult = new ComplexNumber(-0.8, -1.07);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 4: divisione di numeri complessi coniugati
    public void testDiv4() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(-0.72, -0.69);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 5: divisione di numeri complessi molto grandi
    public void testDiv5() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(0, 0.07);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 6: divisione di un numero complesso per il suo opposto
    public void testDiv6() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(-1, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 8: divisione di 0 per un numero complesso
    public void testDiv8() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(0, 0);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 9: divisione di un numero complesso per 0
        public void testDiv9() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(0, 0);
        ComplexNumber instance = new ComplexNumber(2, -5);

        // Verifica che la divisione per zero generi un'eccezione di tipo ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            ComplexNumber result = instance.div(c);
        });
    }
    
    
    
    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test // Test Case 1: radice quadrata di un numero reale positivo
    public void testSqrt1() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(4, 0);
        ComplexNumber expResult = new ComplexNumber(2, 0);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: radice quadrata di un numero reale negativo
    public void testSqrt2() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(-4, 0);
        ComplexNumber expResult = new ComplexNumber(0, 2);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 3: radice quadrata di un numero immaginario puro positivo
    public void testSqrt3() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(0, 9);
        ComplexNumber expResult = new ComplexNumber(2.12, 2.12);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 4: radice quadrata di un numero immaginario puro negativo
    public void testSqrt4() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(0, -9);
        ComplexNumber expResult = new ComplexNumber(2.12, -2.12);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 5: radice quadrata di un numero complesso generico
    public void testSqrt5() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(1.23, 4.56);
        ComplexNumber expResult = new ComplexNumber(1.73, 1.32); 
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 6: radice quadrata di zero
    public void testSqrt6() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    /**
     * Test of reverseSign method, of class ComplexNumber.
     */
    @Test // Test Case 1: inversione del segno di un numero reale
    public void testReverseSign1() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(4.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(-4.0, 0.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: inversione del segno di un numero immaginario puro negativo
    public void testReverseSign2() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(0.0, -9.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 9.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 3: inversione del segno di un numero complesso generico
    public void testReverseSign3() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(1.23, 4.56);
        ComplexNumber expResult = new ComplexNumber(-1.23, -4.56);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 4: inversione del segno di zero
    public void testReverseSign4() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
}
