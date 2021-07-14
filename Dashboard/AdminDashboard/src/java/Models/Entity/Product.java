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
    private  int pID;
    private int cID;
    private int rID;
    private String pName;
    private int pPrice;
    private String pDescription;

    public Product(int pID, int cID, int rID, String pName, int pPrice, String pDescription) {
        this.pID = pID;
        this.cID = cID;
        this.rID = rID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
    }

    public Product() {
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
    
    
}
