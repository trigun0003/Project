/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces.entities;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
public class contacts {
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String message;
    private String date_created;
    
    public contacts()
    {
        
    }

    public contacts(String first_name, String last_name, String email, String phone, String message, String date_created) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.date_created = date_created;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
    
    
     public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("first_name", first_name)
                .add("last_name", last_name)
                .add("email", email)
                .add("phone", phone)
                .add("message", message)
                .add("date_created", date_created)
                .build();
    }
   
    
    
}
