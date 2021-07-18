package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;


public class Restaurant {
    @SerializedName("rID")
    @Expose
    private int rID;
    @SerializedName("rName")
    @Expose
    private String rName;
    @SerializedName("rTimeOpen")
    @Expose
    private String rTimeOpen;
    @SerializedName("rTimeClose")
    @Expose
    private String rTimeClose;
    @SerializedName("rAddress")
    @Expose
    private String rAddress;
    @SerializedName("rPhone")
    @Expose
    private String rPhone;

    @SerializedName("rImage")
    @Expose
    private String rImage;

    public Restaurant() {
    }

    public Restaurant(int rID, String rName, String rTimeOpen, String rTimeClose, String rAddress, String rPhone) {
        this.rID = rID;
        this.rName = rName;
        this.rTimeOpen = rTimeOpen;
        this.rTimeClose = rTimeClose;
        this.rAddress = rAddress;
        this.rPhone = rPhone;
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

    public String getrTimeOpen() {
        return rTimeOpen;
    }

    public void setrTimeDOpen(String rTimeDOpen) {
        this.rTimeOpen = rTimeDOpen;
    }

    public String getrTimeClose() {
        return rTimeClose;
    }

    public void setrTimeClose(String rTimeClose) {
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
