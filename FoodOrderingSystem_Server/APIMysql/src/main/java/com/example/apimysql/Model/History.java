package com.example.apimysql.Model;

import java.sql.Date;

public class History {
    private int hID;
    private int oID;
    private int aID;
    private Date hDate;

    public History(int hID, int oID, int aID, Date hDate) {
        this.hID = hID;
        this.oID = oID;
        this.aID = aID;
        this.hDate = hDate;
    }

    public History() {
    }

    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
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

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }
}
