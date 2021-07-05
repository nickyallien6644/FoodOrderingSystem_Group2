package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Restaurant {
    @SerializedName("pID")
    @Expose
    private int rID;
    @SerializedName("rName")
    @Expose
    private String rName;
    @SerializedName("rTimeDOpen")
    @Expose
    private String rTimeDOpen;
    @SerializedName("rTimeClose")
    @Expose
    private String rTimeClose;
    @SerializedName("rAddress")
    @Expose
    private String rAddress;
    @SerializedName("rPhone")
    @Expose
    private String rPhone;

    public Restaurant() {
    }

    public Restaurant(int rID, String rName, String rTimeDOpen, String rTimeClose, String rAddress, String rPhone) {
        this.rID = rID;
        this.rName = rName;
        this.rTimeDOpen = rTimeDOpen;
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

    public String getrTimeDOpen() {
        return rTimeDOpen;
    }

    public void setrTimeDOpen(String rTimeDOpen) {
        this.rTimeDOpen = rTimeDOpen;
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
}
