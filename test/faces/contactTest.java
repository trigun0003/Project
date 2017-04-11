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
public class contactTest {
    
    public contactTest() {
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
     * Test of submit method, of class contact.
     */
    @Test
    public void testSubmit() {
        System.out.println("submit");
        contact instance = new contact();
        instance.submit();
        
    }
    
    @Test
    public void testClear() {
        contact instance = new contact();
        instance.setEmail("");
        instance.setFirstName("");
        instance.setLastName("");
        instance.setMessage("");
        instance.setPhone("");
        String expResult = "ContactUs";
        String result = instance.clear();
        assertEquals(expResult, result);
        
    }
    
}
