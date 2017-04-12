/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
@Named
@ApplicationScoped
public class payments {
    private int payment_id;
    private String payment_date;
    private String payment_info;
    private String payment_message;
    private int order_user;
    
    public payments()
    {
        
    }

    public payments(int payment_id, String payment_date, String payment_info, String payment_message, int order_user) {
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.payment_info = payment_info;
        this.payment_message = payment_message;
        this.order_user = order_user;
    }
    
     public payments(JsonObject json) {        
        payment_id = json.getInt("PAYMENT_ID", 0);
        payment_date = json.getString("PAYMENT_DATE", "");
        payment_info = json.getString("PAYMENT_INFO", "");
        payment_message = json.getString("PAYMENT_MESSAGE","");
        order_user = json.getInt("ORDER_USER", 0);
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }

    public String getPayment_message() {
        return payment_message;
    }

    public void setPayment_message(String payment_message) {
        this.payment_message = payment_message;
    }

    public int getOrder_user() {
        return order_user;
    }

    public void setOrder_user(int order_user) {
        this.order_user = order_user;
    }
    
     public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("payment_id", payment_id)
                .add("payment_date", payment_date)
                .add("payment_info", payment_info)
                .add("payment_message", payment_message)
                .add("order_user", order_user)
                .build();
    } 
}
