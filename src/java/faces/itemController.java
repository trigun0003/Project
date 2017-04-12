/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
@Named
@ApplicationScoped
public class itemController {
    private List<items> itemdata;
    private items item;
    
    public itemController(){
        getItems();
    }
    
    private void getItems(){
        item = new items();
        try{
            itemdata = new ArrayList<>();
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("Select * from items");
            while(resultset.next()){
                items us = new items();
                us.setItem_id(resultset.getInt("ITEM_ID"));
                us.setItem_name(resultset.getString("ITEM_NAME"));
                us.setDescription(resultset.getString("ITEM_DESCREPTION"));
                us.setItem_price(resultset.getInt("ITEM_PRICE"));
                us.setUser_id(resultset.getInt("USER_ID"));
            }
        } catch (SQLException ex){
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }

    Object getAllJson() {
        throw new UnsupportedOperationException("HEBR HEBER HEBER HBERH HERBER HEBRHEBRHEBRHEBRH."); //To change body of generated methods, choose Tools | Templates.
    }

    JsonObject getByIdJson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object addJson(JsonObject json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    JsonObject editJson(int id, JsonObject json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
