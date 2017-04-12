/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.io.File;
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
public class itemsTest {
    
    public itemsTest() {
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
        items instance = new items();
        instance.setItem_id(1);
        instance.setItem_name("n");
        instance.setDescription("d");
        instance.setItem_price(1000);
        instance.setUser_id(1);
        instance.setTag_id(1);
        JsonObject expResult = Json.createObjectBuilder().add("item_id", 1).add("item_name", "n").add("description", "d").add("item_price", 1000).add("user_id", 1).add("tag_id", 1).build();
        JsonObject result = instance.toJson();
        assertEquals(expResult, result);
        
    }
    
}
