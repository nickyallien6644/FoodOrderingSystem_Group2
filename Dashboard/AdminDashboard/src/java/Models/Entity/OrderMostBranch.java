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
public class OrderMostBranch {
    private String rName;
    private String rAddress;
    private double Percentage;

    /**
     *Constructor
     */
    public OrderMostBranch() {
    }

    /**
     *
     * @param rName
     * @param rAddress
     * @param Percentage
     */
    public OrderMostBranch(String rName, String rAddress, double Percentage) {
        this.rName = rName;
        this.rAddress = rAddress;
        this.Percentage = Percentage;
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

    /**
     *
     * @return rAddress
     */
    public String getrAddress() {
        return rAddress;
    }

    /**
     *
     * @param rAddress
     */
    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    /**
     *
     * @return Percentage
     */
    public double getPercentage() {
        return Percentage;
    }

    /**
     *
     * @param Percentage
     */
    public void setPercentage(double Percentage) {
        this.Percentage = Percentage;
    }
    
    
    
    
}
