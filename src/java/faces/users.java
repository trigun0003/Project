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
public class users {

    private int customerId;
    private String discountCode;
    private String zip;
    private String name;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private int creditLimit;

    /**
     * Default constructor
     */
    public users() {

    }

    /**
     *
     * @param customerId
     * @param discountCode
     * @param zip
     * @param name
     * @param addressline1
     * @param addressline2
     * @param city
     * @param state
     * @param phone
     * @param fax
     * @param email
     * @param creditLimit
     */
    public users(int customerId, String discountCode, String zip, String name, String addressline1, String addressline2, String city, String state, String phone, String fax, String email, int creditLimit) {
        this.customerId = customerId;
        this.discountCode = discountCode;
        this.zip = zip;
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    /**
     * Retrieve the Customer Id
     *
     * @return the Customer Id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the Customer Id
     *
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieve the Discount Code
     *
     * @return the Discount Code
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * Set the Discount Code
     *
     * @param discountCode
     */
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    /**
     * Retrieve the Zip
     *
     * @return the Zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set the Zip
     *
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Retrieve the Name
     *
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * set the Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the address
     *
     * @return address
     */
    public String getAddressline1() {
        return addressline1;
    }

    /**
     * Set the address
     *
     * @param addressline1
     */
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    /**
     * Retrieve the address
     *
     * @return the address
     */
    public String getAddressline2() {
        return addressline2;
    }

    /**
     * Set the address
     *
     * @param addressline2
     */
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    /**
     * Retrieve the City
     *
     * @return the City
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the City
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieve the State
     *
     * @return the State
     */
    public String getState() {
        return state;
    }

    /**
     * Set the State
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieve the Phone
     *
     * @return the Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the Phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieve the Fax
     *
     * @return the Fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set the Fax
     *
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Retrieve the Email
     *
     * @return the Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the Email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieve the Credit Limit
     *
     * @return the Credit Limit
     */
    public int getCreditLimit() {
        return creditLimit;
    }

    /**
     * Set the Credit Limit
     *
     * @param creditLimit
     */
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

}
