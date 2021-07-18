package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetail {
    @SerializedName("oID")
    @Expose
    private int oID;
    @SerializedName("pID")
    @Expose
    private int pID;
    @SerializedName("oQuantity")
    @Expose
    private int oQuantity;
    @SerializedName("oPrice")
    @Expose
    private int oPrice;
    @SerializedName("oSubTotal")
    @Expose
    private int oSubTotal;


    public OrderDetail() {
    }

    public OrderDetail(int oID, int pID, int oQuantity, int oPrice, int oSubTotal) {
        this.oID = oID;
        this.pID = pID;
        this.oQuantity = oQuantity;
        this.oPrice = oPrice;
        this.oSubTotal = oSubTotal;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(int oQuantity) {
        this.oQuantity = oQuantity;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(int oPrice) {
        this.oPrice = oPrice;
    }

    public int getoSubTotal() {
        return oSubTotal;
    }

    public void setoSubTotal(int oSubTotal) {
        this.oSubTotal = oSubTotal;
    }
}
