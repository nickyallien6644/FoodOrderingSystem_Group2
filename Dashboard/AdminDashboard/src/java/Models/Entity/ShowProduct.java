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

    public ShowProduct() {
    }

    public ShowProduct(int pID, String pName, String category, int price, String pDescription) {
        this.pID = pID;
        this.pName = pName;
        this.category = category;
        this.price = price;
        this.pDescription = pDescription;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
    
    
}
