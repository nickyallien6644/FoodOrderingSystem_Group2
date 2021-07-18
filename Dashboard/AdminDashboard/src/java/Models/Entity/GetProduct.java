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
public class GetProduct {

    private int pID;
    private String pName;
    private int category;
    private int price;
    private String pDescription;
    private String iURL;
    
    /**
     *Constructor
     */
    public GetProduct() {
    }

    /**
     *
     * @param pID
     * @param pName
     * @param category
     * @param price
     * @param pDescription
     * @param iURL
     */
    public GetProduct(int pID, String pName, int category, int price, String pDescription, String iURL) {
        this.pID = pID;
        this.pName = pName;
        this.category = category;
        this.price = price;
        this.pDescription = pDescription;
        this.iURL =iURL;
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
    public int getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(int category) {
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

    /**
     *
     * @return iURL
     */
    public String getiURL() {
        return iURL;
    }

    /**
     *
     * @param iURL
     */
    public void setiURL(String iURL) {
        this.iURL = iURL;
    }

}
