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

    public OrderMostBranch() {
    }

    public OrderMostBranch(String rName, String rAddress, double Percentage) {
        this.rName = rName;
        this.rAddress = rAddress;
        this.Percentage = Percentage;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrAddress() {
        return rAddress;
    }

    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double Percentage) {
        this.Percentage = Percentage;
    }
    
    
    
    
}
