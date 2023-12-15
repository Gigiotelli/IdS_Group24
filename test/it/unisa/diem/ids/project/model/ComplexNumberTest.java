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
    @Test // Test Case 1: Stampa di un numero complesso formattato con parte reale e immaginaria positiva
    public void testToString1() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(2.5, 3.8);
        String expResult = "2.5+3.8j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test // Test Case 2: Stampa di un numero complesso formattato con parte reale e immaginaria negativa
    public void testToString2() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(-1.2, -4.7);
        String expResult = "-1.2-4.7j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test // Test Case 3: Stampa di un numero complesso formattato con solo parte reale
    public void testToString3() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(5.6, 0);
        String expResult = "5.6";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test // Test Case 4: Stampa di un numero complesso formattato con solo parte immaginaria
    public void testToString4() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(0, -2.3);
        String expResult = "0.0-2.3j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test // Test Case 5: Stampa di zero come numero complesso
    public void testToString5() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(0, 0);
        String expResult = "0.0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test //Test Case 1: Somma numeri reali
    public void testAdd1() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(-2, 0);
        ComplexNumber instance = new ComplexNumber(7, 0);
        ComplexNumber expResult = new ComplexNumber(5, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 2: Somma numeri immaginari puri
    public void testAdd2() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(0, 5);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 3: Somma numeri complessi generici
    public void testAdd3() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2.7, -5.03);
        ComplexNumber instance = new ComplexNumber(3.2, 6.91);
        ComplexNumber expResult = new ComplexNumber(5.9, 1.88);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 4: Somma numeri complessi coniugati
    public void testAdd4() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(4, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 5: Somma numeri complessi molto grandi
    public void testAdd5() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(10555554, -7111111);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 6: Somma numero complesso e suo opposto
    public void testAdd6() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 7: Somma numero complesso con lo 0
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
    @Test //Test Case 1: Dfferenza numeri reali
    public void testSub1() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-9, 0);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 2: Differenza numeri immaginari puri
    public void testSub2() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(0, 9);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);   
    }
    
    @Test //Test Case 3: Differenza numeri complessi generici
    public void testSub3() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.2, -6.91);
        ComplexNumber expResult = new ComplexNumber(0.5, -11.94);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);    
    }
    
    @Test //Test Case 4: Differenza numeri complessi coniugati
    public void testSub4() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(0, -10);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 5: Differenza numeri complessi molto grandi
    public void testSub5() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(-9444444, 8444443);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 6: Differenza numero complesso e suo opposto
    public void testSub6() {
        System.out.println("sub");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(-4, 0);
        ComplexNumber result = instance.sub(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);        
    }
    
    @Test //Test Case 7: Differenza numero complesso con lo 0
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
    @Test //Test Case 1: Moltiplicazione di numeri reali
    public void testMultiply1() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-14, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 2: Moltiplicazione di numeri immaginari puri
    public void testMultiply2() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(14, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 3: Moltiplicazione di numeri complessi generici
    public void testMultiply3() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.245, -6.91);
        ComplexNumber expResult = new ComplexNumber(43.519, -2.335);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test //Test Case 4: Moltiplicazione di numeri complessi coniugati
    public void testMultiply4() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(29, 0);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 5: Moltiplicazione di numeri complessi molto grandi
    public void testMultiply5() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(1.0740728925927E13, 2.345676432099E12);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 6: Moltiplicazione di un numero complesso per il suo opposto
    public void testMultiply6() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(21, 20);
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 7: Moltiplicazione di un numero complesso per lo 0
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
    @Test //Test Case 1: Divisione di numeri reali
    public void testDiv1() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, 0);
        ComplexNumber instance = new ComplexNumber(-7, 0);
        ComplexNumber expResult = new ComplexNumber(-3.5, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 2: Divisione di numeri immaginari puri
    public void testDiv2() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(0, -2);
        ComplexNumber instance = new ComplexNumber(0, 7);
        ComplexNumber expResult = new ComplexNumber(-3.5, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 3: Divisione di numeri complessi generici
    public void testDiv3() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2.7, 5.03);
        ComplexNumber instance = new ComplexNumber(3.245, -6.91);
        ComplexNumber expResult = new ComplexNumber(-0.798, -1.073);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 4: Divisione di numeri complessi coniugati
    public void testDiv4() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, 5);
        ComplexNumber instance = new ComplexNumber(2, -5);
        ComplexNumber expResult = new ComplexNumber(-0.72, -0.69);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 5: Divisione di numeri complessi molto grandi
    public void testDiv5() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(9999999, -7777777);
        ComplexNumber instance = new ComplexNumber(555555, 666666);
        ComplexNumber expResult = new ComplexNumber(0, 0.07);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test //Test Case 6: Divisione di un numero complesso per il suo opposto
    public void testDiv6() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(-1, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 8: Divisione di 0 per un numero complesso
    public void testDiv8() {
        System.out.println("div");
        ComplexNumber c = new ComplexNumber(2, -5);
        ComplexNumber instance = new ComplexNumber(0, 0);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = instance.div(c);
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 9: Divisione di un numero complesso per 0
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
    @Test // Test Case 1: Radice quadrata di un numero reale positivo
    public void testSqrt1() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(4, 0);
        ComplexNumber expResult = new ComplexNumber(2, 0);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 2: Radice quadrata di un numero reale negativo
    public void testSqrt2() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(-4, 0);
        ComplexNumber expResult = new ComplexNumber(0, 2);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 3: Radice quadrata di un numero immaginario puro positivo
    public void testSqrt3() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(0, 9);
        ComplexNumber expResult = new ComplexNumber(2.12, 2.12);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 4: Radice quadrata di un numero immaginario puro negativo
    public void testSqrt4() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(0, -9);
        ComplexNumber expResult = new ComplexNumber(2.12, -2.12);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 5: Radice quadrata di un numero complesso generico
    public void testSqrt5() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(1.23, 4.56);
        ComplexNumber expResult = new ComplexNumber(1.73, 1.32); 
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 6: Radice quadrata di un numero complesso molto grande
    public void testSqrt6() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(7124871.462, 872190.2);
        ComplexNumber expResult = new ComplexNumber(2674.222, 163.074);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    
    @Test // Test Case 7: Radice quadrata di zero
    public void testSqrt7() {
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
    @Test // Test Case 1: Inversione del segno di un numero reale
    public void testReverseSign1() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(4.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(-4.0, 0.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 2: Inversione del segno di un numero immaginario puro negativo
    public void testReverseSign2() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(0.0, -9.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 9.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
    
    @Test // Test Case 3: Inversione del segno di un numero complesso generico
    public void testReverseSign3() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(1.23, 4.56);
        ComplexNumber expResult = new ComplexNumber(-1.23, -4.56);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }

    @Test // Test Case 4: Inversione del segno di zero
    public void testReverseSign4() {
        System.out.println("reverseSign");
        ComplexNumber instance = new ComplexNumber(0.0, 0.0);
        ComplexNumber expResult = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = instance.reverseSign();
        assertEquals(expResult.getRe(), result.getRe(), delta);
        assertEquals(expResult.getIm(), result.getIm(), delta);
    }
}
