/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces.entities;

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

  

    

}
