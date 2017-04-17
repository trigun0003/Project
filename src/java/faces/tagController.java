/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import faces.tags;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
@Named
@ApplicationScoped
public class tagController {
    
    private List<tags> itemtag;
    private tags objtag;
    //private items item;

    public List<tags> getItemtag() {
        return itemtag;
    }

    public tags getObjtag() {
        return objtag;
    }
    
    public tagController() {
           gettags();
           objtag = new tags(0, "");
     
    }

    private void gettags() {
        
        itemtag = new ArrayList<>();
        try {
            
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tags");
            
            while(rs.next()){
               tags us = new tags();
               us.setTag_id(rs.getInt("tag_id"));
               us.setTag_name(rs.getString("tag_name"));        
                itemtag.add(us);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
        objtag = new tags(0, "");
    }

    public void persistToDB(tags t) {
        
        try {
            String sql = "";
            Connection conn = DBUtils.getConnection();
            if (t.getTag_id()<= 0) {
                sql = "INSERT INTO tags (tag_name ) VALUES (?)";
            } else {
                sql = "UPDATE tags SET tag_name = ? WHERE tag_id = ?";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, t.getTag_name());
           

            if (t.getTag_id() > 0) {
                pstmt.setInt(2, t.getTag_id());
            }
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
        gettags();

    }

    public void removeFromDB(tags t) {
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tags WHERE tag_id = ?");
            pstmt.setInt(1, t.getTag_id());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }

    public JsonArray getAllJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (tags i : itemtag) {
            json.add(i.toJson());
        }
        return json.build();
    }

    public tags getById(int id) {
        for (tags t : itemtag) {
            if (t.getTag_id() == id) {
                return t;
            }
        }
        return null;
    }
    
    

    public JsonObject getByIdJason(int id) {
        tags t = getById(id);
        if (t != null) {
            return getById(id).toJson();
        } else {
            return null;
        }

    }
    
    public JsonObject addJson(JsonObject json) {
        tags t = new tags(json);
        persistToDB(t);
        itemtag.add(t);
        return t.toJson();
    }
    
    public JsonObject editJson(int id, JsonObject json)
    {
        tags t = getById(id);
        t.setTag_name(json.getString("TAG_NAME", ""));
        persistToDB(t);
        return t.toJson();
    }

   
    public boolean deleteById(int id)
    {
        tags i = getById(id);
        if(i != null)
        {
            removeFromDB(i);
            itemtag.remove(i);
            return true;
        }else
        {
            return false;
        }
    }

   
    
    
}
