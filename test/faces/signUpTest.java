/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BHOOMI
 */
public class signUpTest {
    
    public signUpTest() {
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
     * Test of signUp method, of class signUp.
     */
    @Test
    public void testSignUp() {
        signUp instance = new signUp();
        instance.setEmail("a");
        instance.setFirstName("n");
        instance.setLastName("l");
        instance.setPassword("p");
        String expResult = "LogIn";
        String result = instance.signUp();
        assertEquals(expResult, result);
       
    }

      
}
