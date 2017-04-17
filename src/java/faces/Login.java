/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0690651
 */
@ManagedBean
@SessionScoped
public class Login {

    private String email;
    private String password;
    private boolean loggedIn;
    private user currentUser;
    private userController users;

    //use for change password page
    private String newPassword1;
    private String newPassword2;

    /**
     * Default constructor
     */
    public Login() {
        email = null;
        password = null;
        loggedIn = false;
        currentUser = new user();
        users = new userController();
    }

    public String login() {
        String nextPage = "LogIn";
        for (user u : users.getUsers()) {
            if ((email.equals(u.getEmail()) || email.equals(u.getUser_name())) && password.equals(u.getPassword())) {
                loggedIn = true;
                currentUser = u;
                if (u.getUser_type() == 1 || u.getUser_type() == 3) {
                    nextPage = "IndexProfile";
                } else if (u.getUser_type() == 2 || u.getUser_type() == 4) {
                    nextPage = "AdminHome";
                }

            }
        }
        password = "";
        return nextPage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public user getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(user currentUser) {
        this.currentUser = currentUser;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String changePassword() {
        if (currentUser != null) {
            if (password.equals(currentUser.getPassword())
                    && newPassword1 != null
                    && newPassword1.equals(newPassword2)) {
                try {
                    Connection conn = DBUtils.getConnection();
                    String query = "UPDATE users SET password = ? WHERE user_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, newPassword1);
                    pstmt.setInt(2, currentUser.getUser_id());
                    pstmt.executeUpdate();
                    userController.getUserFromDB();
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        password = "";
        newPassword1 = "";
        newPassword2 = "";
        
        switch (currentUser.getUser_type()) {
            case 1:
            case 3:
                return "LogIn";
            case 2:
            case 4:
                return "AdminHome";
            default:
                return null;
        }
    }

    public String cancel() {
        password = "";
        newPassword1 = "";
        newPassword2 = "";

        return "AdminHome";
    }

}
