package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Order {
    @SerializedName("oID")
    @Expose
    private int oID;
    @SerializedName("aID")
    @Expose
    private int aID;
    @SerializedName("rID")
    @Expose
    private int rID;
    @SerializedName("oAmountTotal")
    @Expose
    private int oAmountTotal;
    @SerializedName("oDateCreate")
    @Expose
    private String oDateCreate;
    @SerializedName("oNote")
    @Expose
    private String oNote;
    @SerializedName("oCode")
    @Expose
    private String oCode;
    @SerializedName("oStatus")
    @Expose
    private int oStatus;

    public Order() {
    }

    public Order(int oID, int aID, int rID, int oAmountTotal, String oDateCreate, int oStatus, String oNote, String oCode) {
        this.oID = oID;
        this.aID = aID;
        this.rID = rID;
        this.oAmountTotal = oAmountTotal;
        this.oDateCreate = oDateCreate;
        this.oNote = oNote;
        this.oCode = oCode;
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

    public int getoAmountTotal() {
        return oAmountTotal;
    }

    public void setoAmountTotal(int oAmountTotal) {
        this.oAmountTotal = oAmountTotal;
    }

    public String getoDateCreate() {
        return oDateCreate;
    }

    public void setoDateCreate(String oDateCreate) {
        this.oDateCreate = oDateCreate;
    }

    public int getoStatus() {
        return oStatus;
    }

    public void setoStatus(int oStatus) {
        this.oStatus = oStatus;
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
