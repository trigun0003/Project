/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    /**
     * Default constructor
     */
    public Login(){
        email = null;
        password = null;
        loggedIn = false;
        currentUser = new user();
        users = new userController();
    }
    
    public String login() {
        String nextPage = "LogIn";
        for(user u : users.getUsers()){
            if((email.equals(u.getEmail()) || email.equals(u.getUser_name())) && password.equals(u.getPassword())){
                loggedIn = true;
                currentUser = u;
                if(u.getUser_type() ==1 || u.getUser_type() == 3){
                    nextPage = "index";
                }
                else if (u.getUser_type() == 2|| u.getUser_type() == 4){
                    nextPage = "AdminHome";
            }
                
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
}
