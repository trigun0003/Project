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
public class contact {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String message;
    private Date dateCreated;

    public contact() {
        firstName = null;
        lastName = null;
        email = null;
        phone = null;
        message = null;
        dateCreated = new Date();

    }

    public void submit() {
        dateCreated = new Date();
        java.sql.Date today = new java.sql.Date(dateCreated.getTime());
        if (email != null && message != null) {
            try {
                Connection conn = DBUtils.getConnection();
                String query = "INSERT INTO contact (first_name, last_name, email, phone, message, date_created) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, email);
                pstmt.setString(4, phone);
                pstmt.setString(5, message);
                pstmt.setDate(6, today);
                pstmt.executeUpdate();
                firstName = null;
                lastName = null;
                email = null;
                phone = null;
                message = null;
            } catch (SQLException ex) {
                Logger.getLogger(contact.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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

    public String clear() {
        
        firstName = null;
        lastName = null;
        email = null;
        phone = null;
        message = null;
        
        return "ContactUs";
    }

}
