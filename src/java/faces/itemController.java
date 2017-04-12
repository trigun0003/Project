/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import com.sun.istack.internal.logging.Logger;
import faces.DBUtils;
import faces.items;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

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
            Logger.getLogger(itemController.class.getClass()).log(Level.SEVERE, null, ex);
        }
    }
    
}
