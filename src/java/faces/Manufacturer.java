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
public class Manufacturer {

    private int manufacturerId;
    private String name;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String fax;
    private String email;
    private String rep;

    /**
     * Default constructor
     */
    public Manufacturer() {

    }

    /**
     *
     * @param manufacturerId
     * @param name
     * @param addressline1
     * @param addressline2
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param fax
     * @param email
     * @param rep
     */
    public Manufacturer(int manufacturerId, String name, String addressline1, String addressline2, String city, String state, String zip, String phone, String fax, String email, String rep) {
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.rep = rep;
    }

    /**
     * Retrieve the Manufacturer Id
     *
     * @return the Manufacturer Id
     */
    public int getManufacturerId() {
        return manufacturerId;
    }

    /**
     * Set the Manufacturer Id
     *
     * @param manufacturerId
     */
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
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
     * Set the Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the address
     *
     * @return the address
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
     * Retrieve the Rep
     *
     * @return the Rep
     */
    public String getRep() {
        return rep;
    }

    /**
     * Set the Rep
     *
     * @param rep
     */
    public void setRep(String rep) {
        this.rep = rep;
    }

}
