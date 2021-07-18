/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

/**
 *
 * @author phuct
 */
public class ShowProduct {

    private int pID;
    private String pName;
    private String category;
    private int price;
    private String pDescription;

    /**
     * Constructor
     */
    public ShowProduct() {
    }

    /**
     *
     * @param pID
     * @param pName
     * @param category
     * @param price
     * @param pDescription
     */
    public ShowProduct(int pID, String pName, String category, int price, String pDescription) {
        this.pID = pID;
        this.pName = pName;
        this.category = category;
        this.price = price;
        this.pDescription = pDescription;
    }

    /**
     *
     * @return pID
     */
    public int getpID() {
        return pID;
    }

    /**
     *
     * @param pID
     */
    public void setpID(int pID) {
        this.pID = pID;
    }

    /**
     *
     * @return pName
     */
    public String getpName() {
        return pName;
    }

    /**
     *
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return pDescription
     */
    public String getpDescription() {
        return pDescription;
    }

    /**
     *
     * @param pDescription
     */
    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

}
