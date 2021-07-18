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
public class OrderMostDay {

    private int pId;
    private String pName;
    private String image;
    private double pPrice;
    
    /**
     *Constructor
     */
    public OrderMostDay() {
        
    }

    /**
     *
     * @param pId
     * @param image
     * @param pName
     * @param pPrice
     */
    public OrderMostDay(int pId, String image, String pName, double pPrice) {
        this.pId = pId;
        this.image = image;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    /**
     *
     * @return pId
     */
    public int getpId() {
        return pId;
    }

    /**
     *
     * @param pId
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     *
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
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
    public double getpPrice() {
        return pPrice;
    }

    /**
     *
     * @param pPrice
     */
    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

}
