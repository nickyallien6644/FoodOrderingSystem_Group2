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
public class RestaurantName {
    private int rId;
    private String rName;

    /**
     *Constructor
     */
    public RestaurantName() {
    }

    /**
     *
     * @param rId
     * @param rName
     */
    public RestaurantName(int rId, String rName) {
        this.rId = rId;
        this.rName = rName;
    }

    /**
     *
     * @return rId
     */
    public int getrId() {
        return rId;
    }

    /**
     *
     * @param rId
     */
    public void setrId(int rId) {
        this.rId = rId;
    }

    /**
     *
     * @return rName
     */
    public String getrName() {
        return rName;
    }

    /**
     *
     * @param rName
     */
    public void setrName(String rName) {
        this.rName = rName;
    }
    
    
}
