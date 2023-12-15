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
public class ModelTest {
    
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
