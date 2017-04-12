/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;


/**
 *
 * @author Heber
 */

@ManagedBean
@ApplicationScoped
public class userController {
    private static List<user> users = new ArrayList<>();
    private static userController instance;
    
    public userController(){
        getUserFromDB();
        instance = this;
    }
    
    public static void getUserFromDB(){
        users = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            String query = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
            user u = new user(
                    rs.getInt("user_id"), 
                    rs.getString("user_name"), 
                    rs.getString("email"), 
                    rs.getString("password"), 
                    rs.getDate("date_created"), 
                    rs.getInt("user_type"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
            users.add(u);
        }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void persistToDb(user u) {
        try {
            String sql = "";
            Connection conn = DBUtils.getConnection();
            if (u.getUser_id() <= 0) {
                sql = "INSERT INTO users (USER_NAME, EMAIL, PASSWORD, USER_TYPE, DATE_CREATED, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?, ?, ?, ?, ?)";
            } else {
                sql = "UPDATE users SET USER_NAME = ?, EMAIL= ?, PASSWORD = ?, USER_TYPE = ?, DATE_CREATED = ?, FIRST_NAME = ?, LAST_NAME = ?  WHERE USER_ID = ?";
            }
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,u.getUser_name() );
            pstmt.setString(2, u.getEmail() );
            pstmt.setString(3, u.getPassword());
            pstmt.setInt(4, u.getUser_type());
            pstmt.setDate(5, u.getDate_created());
            pstmt.setString(6, u.getFirst_name() );
            pstmt.setString(7, u.getLast_name() );
            if (u.getUser_id() > 0) {
                pstmt.setInt(8, u.getUser_id());
            }
            pstmt.executeUpdate();
   
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeFromDB(user u) {
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE USER_ID = ?");
            pstmt.setInt(1, u.getUser_id());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getClass().toString()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public JsonArray getAllJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (user u : users) {
            json.add(u.toJson());
        }
        return json.build();
    }
    
    public user getById(int id) {
        for (user u : users) {
            if (u.getUser_id() == id) {
                return u;
            }
        }
        return null;
    }
    
    public JsonObject getByIdJason(int id) {
        user u = getById(id);
        if (u != null) {
            return getById(id).toJson();
        } else {
            return null;
        }

    }
    
    
    public JsonObject addJson(JsonObject json) {
        user u = new user(json);
        persistToDb(u);
        users.add(u);
        return u.toJson();
    }
    
    public JsonObject editJson(int id, JsonObject json)
    {
        user u = getById(id);
            u.setUser_name(json.getString("USER_NAME") );
            u.setEmail(json.getString("EMAIL") );
            u.setPassword(json.getString("PASSWORD"));
            u.setUser_type(json.getInt("USER_TYPE"));
            u.setFirst_name(json.getString("FIRST_NAME"));
            u.setLast_name(json.getString("LAST_NAME"));
        persistToDb(u);
        return u.toJson();
    }
    
    public boolean deleteById(int id)
    {
        user u = getById(id);
        if(u != null)
        {
            removeFromDB(u);
            users.remove(u);
            return true;
        }else
        {
            return false;
        }
    }
    
    

    public static List<user> getUsers() {
        return users;
    }

    public static userController getInstance() {
        return instance;
    }
    
    public user getUserById(int id){
        for (user u : users){
            if (u.getUser_id() == id){
                return u;
            }
        }
        return null;
    }
    
    

    
}
