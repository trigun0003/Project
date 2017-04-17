/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.math.BigDecimal;
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
 * @author bellahuang
 */
public class tagsTest {
    
    public tagsTest() {
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
     * Test of toJson method, of class tags.
     */
    @Test
    public void testToJson() {
        tags instance = new tags();
        instance.setTag_id(1);
        instance.setTag_name("toys");
        JsonObject expResult = Json.createObjectBuilder().add("tag_id", 1).add("tag_name", "toys").build();
        JsonObject result = instance.toJson();
        assertEquals(expResult, result);
    }
    
}
