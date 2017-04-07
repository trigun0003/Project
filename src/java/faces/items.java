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
public class items {

    private int productId;
    private int manufacturerId;
    private String productCode;
    private double purchaseCost;
    private int quantityOnHand;
    private double markup;
    private String available;
    private String description;

    /**
     * Default constructor
     */
    public items() {

    }

    /**
     *
     * @param productId
     * @param manufacturerId
     * @param productCode
     * @param purchaseCost
     * @param quantityOnHand
     * @param markup
     * @param available
     * @param description
     */
    public items(int productId, int manufacturerId, String productCode, double purchaseCost, int quantityOnHand, double markup, String available, String description) {
        this.productId = productId;
        this.manufacturerId = manufacturerId;
        this.productCode = productCode;
        this.purchaseCost = purchaseCost;
        this.quantityOnHand = quantityOnHand;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }

    /**
     * Retrieve the Product Id
     *
     * @return the Product Id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set the Product Id
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
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
     * Retrieve the Product Code
     *
     * @return the Product Code
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Set the Product Code
     *
     * @param productCode
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Retrieve the Purchase Cost
     *
     * @return the Purchase Cost
     */
    public double getPurchaseCost() {
        return purchaseCost;
    }

    /**
     * Set the Purchase Cost
     *
     * @param purchaseCost
     */
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    /**
     * Retrieve the Quantity On Hand
     *
     * @return the Quantity On Hand
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * Set the Quantity On Hand
     *
     * @param quantityOnHand
     */
    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * Retrieve the markup
     *
     * @return the markup
     */
    public double getMarkup() {
        return markup;
    }

    /**
     * Set the markup
     *
     * @param markup
     */
    public void setMarkup(double markup) {
        this.markup = markup;
    }

    /**
     * Retrieve the Available
     *
     * @return the Available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * Set the Available
     *
     * @param available
     */
    public void setAvailable(String available) {
        this.available = available;
    }

    /**
     * Retrieve the Description
     *
     * @return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
