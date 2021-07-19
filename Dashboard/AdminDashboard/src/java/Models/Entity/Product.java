/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

/**
 *
 * @author MSI
 */
public class Product {

    private int pID;
    private int cID;
    private int rID;
    private String pName;
    private int pPrice;
    private String pDescription;

    /**
     *
     * @param pID
     * @param cID
     * @param rID
     * @param pName
     * @param pPrice
     * @param pDescription
     */
    public Product(int pID, int cID, int rID, String pName, int pPrice, String pDescription) {
        this.pID = pID;
        this.cID = cID;
        this.rID = rID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
    }

    /**
     * Constructor
     */
    public Product() {
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
     * @return cID
     */
    public int getcID() {
        return cID;
    }

    /**
     *
     * @param cID
     */
    public void setcID(int cID) {
        this.cID = cID;
    }

    /**
     *
     * @return rID
     */
    public int getrID() {
        return rID;
    }

    /**
     *
     * @param rID
     */
    public void setrID(int rID) {
        this.rID = rID;
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
     * @return pPrice
     */
    public int getpPrice() {
        return pPrice;
    }

    /**
     *
     * @param pPrice
     */
    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
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
