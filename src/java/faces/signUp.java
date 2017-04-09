/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
/**
 *
 * @author bellahuang
 */
@ManagedBean
@SessionScoped
public class signUp {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    
    public signUp(){
        
    }
    
    public String signUp(String email, String firstName, String lastName, String password){
        String nextPage = "SignUp";
        Date today1 = new Date();
        java.sql.Date today2 = new java.sql.Date(today1.getTime());
        if (email != null && firstName != null && lastName != null && password != null){
            try {
                Connection conn = DBUtils.getConnection();
                String query = "INSERT INTO users (user_name, email, password, user_type, date_created, first_name, last_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, email);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setInt(4, 1);
                pstmt.setDate(5, today2);
                pstmt.setString(6, firstName);
                pstmt.setString(7, lastName);
                pstmt.executeUpdate();
                
                userController.getUserFromDB();
                nextPage = "LogIn";
            } catch (SQLException ex) {
                Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nextPage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
