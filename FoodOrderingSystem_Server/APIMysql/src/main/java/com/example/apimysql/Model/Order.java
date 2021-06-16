package com.example.apimysql.Model;

import java.sql.Date;

public class Order {
    private int oID;
    private int aID;
    private int rID;
    private double oAmountTotal;
    private Date oDateCreate;
    private int oStatus;

    public Order() {
    }

    public Order(int oID, int aID, int rID, double oAmountTotal, Date oDateCreate, int oStatus) {
        this.oID = oID;
        this.aID = aID;
        this.rID = rID;
        this.oAmountTotal = oAmountTotal;
        this.oDateCreate = oDateCreate;
        this.oStatus = oStatus;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public double getoAmountTotal() {
        return oAmountTotal;
    }

    public void setoAmountTotal(double oAmountTotal) {
        this.oAmountTotal = oAmountTotal;
    }

    public Date getoDateCreate() {
        return oDateCreate;
    }

    public void setoDateCreate(Date oDateCreate) {
        this.oDateCreate = oDateCreate;
    }

    public int getoStatus() {
        return oStatus;
    }

    public void setoStatus(int oStatus) {
        this.oStatus = oStatus;
    }
}
