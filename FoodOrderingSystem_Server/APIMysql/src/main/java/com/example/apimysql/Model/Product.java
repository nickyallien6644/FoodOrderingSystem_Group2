package com.example.apimysql.Model;

public class Product {
   private int pID;
   private String pName;
   private int pPrice;
   private String pDescription;
   private int cID;
    private int rID;
    public Product() {
    }

    public Product(int pID, String pName, int pPrice, String pDescription, int cID, int rID) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
        this.cID = cID;
        this.rID = rID;
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

    public double getpPrice() {
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

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getRID() {
        return rID;
    }

    public void setRID(int rID) {
        this.rID = rID;
    }
}
