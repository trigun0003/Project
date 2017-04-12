/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

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
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
public class paymentController {
    
    private List<payments> paymentData;
    private payments paymentObj;
    //private items item;

    public List<payments> getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(List<payments> paymentData) {
        this.paymentData = paymentData;
    }

    public payments getPaymentObj() {
        return paymentObj;
    }

    public void setPaymentObj(payments paymentObj) {
        this.paymentObj = paymentObj;
    }

   

    private void getPayments() {
        paymentObj = new payments();
        
        try {paymentData = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select PAYMENT_ID, PAYMENT_DATE, PAYMENT_INFO, PAYMENT_MESSAGE, ORDER_USER from payment");
            
            while(rs.next()){
               payments us = new payments(
                       rs.getInt("PAYMENT_ID"),
                       rs.getString("PAYMENT_DATE"),
                       rs.getString("PAYMENT_INFO"),
                       rs.getString("PAYMENT_MESSAGE"),
                       rs.getInt("ORDER_USER")       
               );
                paymentData.add(us);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
            paymentData = new ArrayList<>();
        }
    }

    public void persistToDB(payments i) {
        try {
            String sql = "";
            Connection conn = DBUtils.getConnection();
            if (i.getPayment_id()<= 0) {
                sql = "INSERT INTO PAYMENTS (PAYMENT_DATE, PAYMENT_INFO, PAYMENT_MESSAGE, ORDER_USER) VALUES (? ,?, ?, ?)";
            } else {
                sql = "UPDATE PAYMENTS SET PAYMENT_DATE = ?, PAYMENT_INFO = ?, PAYMENT_MESSAGE = ?, ORDER_USER = ? WHERE PAYMENT_ID = ?";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, i.getPayment_date());
            pstmt.setString(2, i.getPayment_info());
            pstmt.setString(3, i.getPayment_message());
            pstmt.setInt(4, i.getOrder_user());

            if (i.getPayment_id()> 0) {
                pstmt.setInt(5, i.getPayment_id());
            }
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(itemController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeFromDB(payments i) {
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM payments WHERE PAYMENT_ID = ?");
            pstmt.setInt(1, i.getPayment_id());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }

    public JsonArray getAllJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (payments i : paymentData) {
            json.add(i.toJson());
        }
        return json.build();
    }

    public payments getById(int id) {
        for (payments i : paymentData) {
            if (i.getPayment_id()== id) {
                return i;
            }
        }
        return null;
    }
    
    

    public JsonObject getByIdJason(int id) {
        payments i = getById(id);
        if (i != null) {
            return getById(id).toJson();
        } else {
            return null;
        }

    }
    
    public JsonObject addJson(JsonObject json) {
        payments i = new payments(json);
        persistToDB(i);
        paymentData.add(i);
        return i.toJson();
    }
    
    public JsonObject editJson(int id, JsonObject json)
    {
        payments i = getById(id);
        i.setPayment_date(json.getString("PAYMENT_DATE", ""));
        i.setPayment_info(json.getString("PAYMENT_INFO", ""));
        i.setPayment_message(json.getString("PAYMENT_MESSAGE"));
        i.setOrder_user(json.getInt("ORDER_USER"));
        persistToDB(i);
        return i.toJson();
    }

   
    public boolean deleteById(int id)
    {
        payments i = getById(id);
        if(i != null)
        {
            removeFromDB(i);
            paymentData.remove(i);
            return true;
        }else
        {
            return false;
        }
    }

}
