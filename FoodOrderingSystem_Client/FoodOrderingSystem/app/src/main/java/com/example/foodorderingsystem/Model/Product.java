package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product {
    @SerializedName("pID")
    @Expose
    private int pID;

    @SerializedName("pName")
    @Expose
    private String pName;

    @SerializedName("pPrice")
    @Expose
    private int pPrice;

    @SerializedName("pDescription")
    @Expose
    private String pDescription;

    @SerializedName("cID")
    @Expose
    private int cID;

    @SerializedName("iID")
    @Expose
    private int iID;

    @SerializedName("iURL")
    @Expose
    private String iURL;

    @SerializedName("rID")
    @Expose
    private int rID;

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

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }
}
