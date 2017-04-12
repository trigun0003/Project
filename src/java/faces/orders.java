/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
public class orders {
    private int order_number;
    private int item_id;
    private String order_date;
    
    public orders()
    {
        
    }

    public orders(int order_number, int item_id, String order_date) {
        this.order_number = order_number;
        this.item_id = item_id;
        this.order_date = order_date;
    }
    
    public orders(JsonObject json) {        
        item_id = json.getInt("ITEM_ID", 0);
        order_number = json.getInt("ORDER_NUMBER", 0);
        order_date = json.getString("ORDER_DATE", "");
    }
    

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.order_date = dateFormat.format(order_date);
    }
    
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("order_number", order_number)
                .add("item_id", item_id)
                .add("order_date", order_date)
                .build();
    }
    
}
