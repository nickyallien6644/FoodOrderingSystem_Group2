package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cart {
    @SerializedName("cartID")
    @Expose
    private int cartID;

    @SerializedName("cartQuantity")
    @Expose
    private int cartQuantity;

    @SerializedName("pID")
    @Expose
    private int pID;

    @SerializedName("pName")
    @Expose
    private String pName;

    @SerializedName("pPrice")
    @Expose
    private int pPrice;

    @SerializedName("iID")
    @Expose
    private int iID;

    @SerializedName("iURL")
    @Expose
    private String iURL;

    @SerializedName("aID")
    @Expose
    private int aID;

    public Cart(int cartID, int cartQuantity, int pID, String pName, int pPrice, int iID, String iURL, int aID) {
        this.cartID = cartID;
        this.cartQuantity = cartQuantity;
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.iID = iID;
        this.iURL = iURL;
        this.aID = aID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
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

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getiURL() {
        return iURL;
    }

    public void setiURL(String iURL) {
        this.iURL = iURL;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }
}
