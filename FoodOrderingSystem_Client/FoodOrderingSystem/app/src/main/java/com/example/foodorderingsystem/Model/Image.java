package com.example.foodorderingsystem.Model;

public class Image {
    private int iID;
    private int pID;
    private String iURL;

    public Image() {
    }

    public Image(int iID, int pID, String iURL) {
        this.iID = iID;
        this.pID = pID;
        this.iURL = iURL;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getiURL() {
        return iURL;
    }

    public void setiURL(String iURL) {
        this.iURL = iURL;
    }
}
