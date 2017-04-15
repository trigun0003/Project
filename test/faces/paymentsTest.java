/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0690651
 */
public class paymentsTest {
    
    public paymentsTest() {
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
     * Test of toJson method, of class payments.
     */
    @Test
    public void testToJson() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();      
        payments instance = new payments();
        instance.setPayment_id(1);
        instance.setPayment_info("i");
        instance.setPayment_message("m");
        instance.setOrder_user(1);
        instance.setPayment_date(new java.sql.Date(today.getTime()));
        JsonObject expResult = Json.createObjectBuilder().add("payment_id", 1).add("payment_info", "i").add("payment_message", "m").add("order_user", 1).add("payment_date", new java.sql.Date(today.getTime()).toString()).build();
        JsonObject result = instance.toJson();
        assertEquals(expResult, result);
        
    }
    
}
