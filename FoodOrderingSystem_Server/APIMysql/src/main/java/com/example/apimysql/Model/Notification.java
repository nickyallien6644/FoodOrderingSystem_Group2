package com.example.apimysql.Model;

public class Notification {
    private int noID;
    private int aID;
    private int rID;
    private String noContent;
    private int noStatus;

    public Notification() {
    }

    public Notification(int noID, int aID, int rID, String noContent, int noStatus) {
        this.noID = noID;
        this.aID = aID;
        this.rID = rID;
        this.noContent = noContent;
        this.noStatus = noStatus;
    }

    public int getNoID() {
        return noID;
    }

    public void setNoID(int noID) {
        this.noID = noID;
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

    public String getNoContent() {
        return noContent;
    }

    public void setNoContent(String noContent) {
        this.noContent = noContent;
    }

    public int getNoStatus() {
        return noStatus;
    }

    public void setNoStatus(int noStatus) {
        this.noStatus = noStatus;
    }
}
