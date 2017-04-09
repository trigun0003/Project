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

/**
 *
 * @author Heber
 */
@ManagedBean
@ApplicationScoped
public class userController {
    private static List<user> users = new ArrayList<>();
    
    public userController(){
        getUserFromDB();
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
        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<user> getUsers() {
        return users;
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
