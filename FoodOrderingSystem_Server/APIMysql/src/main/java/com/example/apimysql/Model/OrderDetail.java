package com.example.apimysql.Model;

public class OrderDetail {
    private int oID;
    private int pID;
    private int oQuantity;
    private double oPrice;
    private String oPaymentMethod;
    private String oNote;
    private String oCode;

    public OrderDetail() {
    }

    public OrderDetail(int oID, int pID, int oQuantity, double oPrice, String oPaymentMethod, String oNote, String oCode) {
        this.oID = oID;
        this.pID = pID;
        this.oQuantity = oQuantity;
        this.oPrice = oPrice;
        this.oPaymentMethod = oPaymentMethod;
        this.oNote = oNote;
        this.oCode = oCode;
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

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public String getoPaymentMethod() {
        return oPaymentMethod;
    }

    public void setoPaymentMethod(String oPaymentMethod) {
        this.oPaymentMethod = oPaymentMethod;
    }

    public String getoNote() {
        return oNote;
    }

    public void setoNote(String oNote) {
        this.oNote = oNote;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode;
    }
}
