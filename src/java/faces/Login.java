/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

/**
 *
 * @author c0690651
 */
public class Login {

    private String userName;
    private String password;

    /**
     * Default constructor
     */
    public Login() {

    }

    /**
     *
     * @param userName
     * @param password
     */
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Retrieve the User Name
     *
     * @return the User Name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the User Name
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieve the Password
     *
     * @return the Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the Password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
