/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ED;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class StackTest {
    
    public StackTest() {
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
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        Stack<Integer> instance = new Stack<Integer>();
        Integer expResult = 18;
        instance.push(20);
        instance.push(18);
        Integer result = instance.top();
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Double e = 2.41;
        Stack<Double> instance = new Stack<Double>();
        instance.push(e);
        assertEquals(instance.size(),  1);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack<String> instance = new Stack<String>();
        instance.push("hola");
        instance.push("juan");
        String expResult = "juan";
        String result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Stack instance = new Stack();
        for(int i = 0; i < 20; i++) {
            instance.push(i+1*5);
        }
        int expResult = 20;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack instance = new Stack();
        instance.push(52);
        instance.pop();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testNotIsEmpty() {
        System.out.println("isEmpty");
        Stack instance = new Stack();
        instance.push(20);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
}
