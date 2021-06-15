package com.example.foodorderingsystem.Model;

import java.sql.Date;

public class Restaurant {
    private int rID;
    private String rName;
    private Date rDateOpen;
    private Date rDateClose;
    private String rAddress;
    private String rPhone;
    private int pID;

    public Restaurant() {
    }

    public Restaurant(int rID, String rName, Date rDateOpen, Date rDateClose, String rAddress, String rPhone, int pID) {
        this.rID = rID;
        this.rName = rName;
        this.rDateOpen = rDateOpen;
        this.rDateClose = rDateClose;
        this.rAddress = rAddress;
        this.rPhone = rPhone;
        this.pID = pID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Date getrDateOpen() {
        return rDateOpen;
    }

    public void setrDateOpen(Date rDateOpen) {
        this.rDateOpen = rDateOpen;
    }

    public Date getrDateClose() {
        return rDateClose;
    }

    public void setrDateClose(Date rDateClose) {
        this.rDateClose = rDateClose;
    }

    public String getrAddress() {
        return rAddress;
    }

    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }
}
