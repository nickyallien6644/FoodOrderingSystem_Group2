package com.example.foodorderingsystem.Model;

public class OrderDetail {
    private int oID;
    private int pID;
    private int oQuantity;
    private int oPrice;


    public OrderDetail() {
    }

    public OrderDetail(int oID, int pID, int oQuantity, int oPrice) {
        this.oID = oID;
        this.pID = pID;
        this.oQuantity = oQuantity;
        this.oPrice = oPrice;
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
}
