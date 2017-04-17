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
import java.util.Date;
import java.util.logging.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
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
public class orderController {

    private List<orders> orderdata;
    private orders currentOrder;

    public orderController() {
        getOrders();
        currentOrder = new orders(0, 0, "", 0);
    }

    private void getOrders() {
        orderdata = new ArrayList<>();

        try {
            if (orderdata == null) {
                orderdata = new ArrayList<>();
            }
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select ORDER_NUMBER,ITEM_ID,ORDER_DATE, QUANTITY from orders");
            while (rs.next()) {
                orders or = new orders();
                or.setOrder_number(rs.getInt("ORDER_NUMBER"));
                or.setItem_id(rs.getInt("ITEM_ID"));
                or.setOrder_date(rs.getDate("ORDER_DATE"));
                or.setQuantity(rs.getInt("QUANTITY"));
                orderdata.add(or);
            }

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }

    public void persistToDB(orders o) {
        Date today = new Date();
        try {
            String sql = "";
            Connection conn = DBUtils.getConnection();
            if (o.getOrder_number() <= 0) {
                sql = "INSERT INTO orders (ITEM_ID, ORDER_DATE, QUANTITY) VALUES (?, ?, ?)";
            } else {
                sql = "UPDATE orders SET ITEM_ID = ?, ORDER_DATE = ?, QUANTITY = ? WHERE ORDER_NUMBER = ?";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, o.getItem_id());
            pstmt.setDate(2, new java.sql.Date(today.getTime()));
            pstmt.setInt(3, o.getQuantity());

            if (o.getOrder_number() > 0) {
                pstmt.setInt(4, o.getOrder_number());
            }
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
        getOrders();

    }

    public void removeFromDB(orders o) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "DELETE FROM orders WHERE order_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, o.getOrder_number());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
        getOrders();
    }

    public List<orders> getOrderdata() {
        return orderdata;
    }

    public JsonArray getAllJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (orders o : orderdata) {
            json.add(o.toJson());
        }
        return json.build();
    }

    public orders getById(int id) {
        for (orders o : orderdata) {
            if (o.getItem_id() == id) {
                return o;
            }
        }
        return null;
    }

    public JsonObject addJson(JsonObject json) {
        orders o = new orders(json);
        persistToDB(o);
        orderdata.add(o);
        return o.toJson();
    }

    public JsonObject getByIdJason(int id) {
        orders o = getById(id);
        if (o != null) {
            return getById(id).toJson();
        } else {
            return null;
        }

    }

    public JsonObject editJson(int id, JsonObject json) {
        orders o = getById(id);
        o.setItem_id(json.getInt("ITEM_ID", 0));
        persistToDB(o);
        return o.toJson();
    }

    public boolean deleteById(int id) {
        orders o = getById(id);
        if (o != null) {
            removeFromDB(o);
            orderdata.remove(o);
            return true;
        } else {
            return false;
        }
    }

    public orders getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(orders currentOrder) {
        this.currentOrder = currentOrder;
    }

    public String cancel() {
        currentOrder = new orders(0, 0, "", 0);

        return "AllOrder.xhtml";
    }

    public String edit(orders o) {
        currentOrder = o;
        return "ManageOrderEdit";
    }

    public String save() {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE orders SET ITEM_ID = ?, QUANTITY = ? WHERE ORDER_NUMBER = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, currentOrder.getItem_id());
            pstmt.setInt(2, currentOrder.getQuantity());
            pstmt.setInt(3, currentOrder.getOrder_number());
            pstmt.executeUpdate();
            getOrders();
            currentOrder = new orders();
        } catch (SQLException ex) {
            Logger.getLogger(orderController.class.getName()).log(Level.SEVERE, null, ex);
            currentOrder = new orders();
        }
        return "ManageOrder";
    }

}
