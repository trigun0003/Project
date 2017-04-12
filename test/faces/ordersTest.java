/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.math.BigDecimal;
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
public class ordersTest {
    
    public ordersTest() {
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
   
    @Test
    public void testToJson() {       
        Date today = new Date();
        orders instance = new orders();
        instance.setItem_id(1);
        instance.setOrder_date(new java.sql.Date(today.getTime()));
        instance.setOrder_number(1);
        JsonObject expResult = Json.createObjectBuilder().add("order_number", 1).add("item_id", 1).add("order_date", new java.sql.Date(today.getTime()).toString()).build();        
        JsonObject result = instance.toJson();
        assertEquals(expResult, result);
        
    }
    
}
