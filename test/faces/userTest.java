
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.sql.Date;
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
public class userTest {
    
    public userTest() {
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
     * Test of toJson method, of class user.
     */
    @Test
    public void testToJson() {
        
        java.util.Date today = new java.util.Date();
        user instance = new user();
        instance.setUser_id(1);
        instance.setUser_name("n");
        instance.setEmail("e");
        instance.setPassword("p");
        instance.setUser_type(1);
        instance.setFirst_name("f");
        instance.setLast_name("l");
        instance.setDate_created(new java.sql.Date(today.getTime()));
        JsonObject expResult = Json.createObjectBuilder().add("user_id", 1).add("user_name", "n").add("email", "e").add("password", "p").add("user_type", 1).add("first_name", "f").add("last_name", "l").add("date_created", new java.sql.Date(today.getTime()).toString()).build();
        JsonObject result = instance.toJson();
        assertEquals(expResult, result);    
        
    }
    
}
