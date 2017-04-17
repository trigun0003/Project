/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
public class itemController {
    

    private List<items> itemdata;
    private items itemobj;
    //private items item;

    public List<items> getItemdata() {
        return itemdata;
    }

    public void setItemdata(List<items> itemdata) {
        this.itemdata = itemdata;
    }
    
    public items getItemobj(){
        return itemobj;
    }
    
    public itemController() {
           getItems();
           itemobj = new items(0,"","",0,0,0);
    }

    private void getItems() {
        itemobj = new items();
        
        try {itemdata = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, USER_ID, TAG_ID from items");
            
            while(rs.next()){
               items us = new items(
                       rs.getInt("ITEM_ID"),
                       rs.getString("ITEM_NAME"),
                       rs.getString("ITEM_DESCRIPTION"),
                       rs.getInt("ITEM_PRICE"),
                       rs.getInt("USER_ID"),
                       rs.getInt("TAG_ID")
               );
                itemdata.add(us);
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
            itemdata = new ArrayList<>();
        }
    }

    public void persistToDB(items i) {
        try {
            String sql = "";
            Connection conn = DBUtils.getConnection();
            //File image = new File(i.getPicture().getPath());
            if (i.getItem_id() <= 0) {
                sql = "INSERT INTO items (ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, TAG_ID) VALUES (? ,?, ?, ?)";
            } else {
                sql = "UPDATE items SET ITEM_NAME = ?, ITEM_DESCRIPTION = ?,  ITEM_PRICE = ? WHERE ITEM_ID = ?";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, i.getItem_name());
            pstmt.setString(2, i.getDescription());
            pstmt.setInt(3, i.getItem_price());
            //pstmt.setInt(4, i.getUser_id());
            //pstmt.setBlob(5, null);

            if (i.getItem_id() > 0) {
                pstmt.setInt(4, i.getItem_id());
            }
            else{
                pstmt.setInt(4, 1);
            }
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
        itemobj = new items(0,"","",0,0,0);
        getItems();

    }

    public void removeFromDB(items i) {
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM items WHERE ITEM_ID = ?");
            pstmt.setInt(1, i.getItem_id());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }

    public JsonArray getAllJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (items i : itemdata) {
            json.add(i.toJson());
        }
        return json.build();
    }

    public items getById(int id) {
        for (items i : itemdata) {
            if (i.getItem_id() == id) {
                return i;
            }
        }
        return null;
    }
    
    

    public JsonObject getByIdJason(int id) {
        items i = getById(id);
        if (i != null) {
            return getById(id).toJson();
        } else {
            return null;
        }

    }
    
    public JsonObject addJson(JsonObject json) {
        items i = new items(json);
        persistToDB(i);
        itemdata.add(i);
        return i.toJson();
    }
    
    public JsonObject editJson(int id, JsonObject json)
    {
        items i = getById(id);
        i.setUser_id(json.getInt("USER_ID", 0));
        i.setItem_name(json.getString("ITEM_NAME", ""));
        i.setItem_price(json.getInt("ITEM_PRICE", 0));
        i.setTag_id(json.getInt("TAG_ID"));
        persistToDB(i);
        return i.toJson();
    }

   
    public boolean deleteById(int id)
    {
        items i = getById(id);
        if(i != null)
        {
            removeFromDB(i);
            itemdata.remove(i);
            return true;
        }else
        {
            return false;
        }
    }

}
