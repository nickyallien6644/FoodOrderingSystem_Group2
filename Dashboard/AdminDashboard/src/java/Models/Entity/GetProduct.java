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
    private int cId;
    private String iURL;
    

    public GetProduct() {
    }

    public GetProduct(int pID, String pName, int category, int price, String pDescription, int cId, String iURL) {
        this.pID = pID;
        this.pName = pName;
        this.category = category;
        this.price = price;
        this.pDescription = pDescription;
        this.cId = cId;
        this.iURL =iURL;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
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

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getiURL() {
        return iURL;
    }

    public void setiURL(String iURL) {
        this.iURL = iURL;
    }

}
