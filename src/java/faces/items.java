/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.io.File;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0690651
 */
public class items {

   private int item_id;
   private String item_name;
   private String description;
   private int item_price;
   private int user_id;
   private File picture;

   
     /**
     * Default constructor
     */
    public items() {

    }

    public items(int item_id, String item_name, String description, int item_price, int user_id) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.description = description;
        this.item_price = item_price;
        this.user_id = user_id;
    }
    
    public items(int item_id, String item_name, String description, int item_price, int user_id, File picture) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.description = description;
        this.item_price = item_price;
        this.user_id = user_id;
        this.picture = picture;
    }
    
    

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
     public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }
  
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("item_id", item_id)
                .add("item_name", item_name)
                .add("description", description)
                .add("item_price", item_price)
                .add("user_id", user_id)
                .add("picture", picture.toString())
                .build();
    }
    
   

}
