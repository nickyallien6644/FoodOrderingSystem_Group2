package com.example.apimysql.Model;


import java.sql.Time;

public class Restaurant {
    private int rID;
    private String rName;
    private Time rTimeOpen;
    private Time rTimeClose;
    private String rAddress;
    private String rPhone;
    private String rImage;

    public Restaurant() {
    }

    public Restaurant(int rID, String rName, Time rTimeOpen, Time rTimeClose, String rAddress, String rPhone, int pID) {
        this.rID = rID;
        this.rName = rName;
        this.rTimeOpen = rTimeOpen;
        this.rTimeClose = rTimeClose;
        this.rAddress = rAddress;
        this.rPhone = rPhone;
        this.rImage = rImage;
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

    public Time getrTimeOpen() {
        return rTimeOpen;
    }

    public void setrTimeOpen(Time rTimeOpen) {
        this.rTimeOpen = rTimeOpen;
    }

    public Time getrTimeClose() {
        return rTimeClose;
    }

    public void setrTimeClose(Time rTimeClose) {
        this.rTimeClose = rTimeClose;
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

    public String getrImage() {
        return rImage;
    }

    public void setrImage(String rImage) {
        this.rImage = rImage;
    }
}
