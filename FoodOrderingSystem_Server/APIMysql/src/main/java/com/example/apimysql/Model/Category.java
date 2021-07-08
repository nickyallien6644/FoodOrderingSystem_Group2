package com.example.apimysql.Model;

public class Category {
    private int cID;
    private String cName;
    private String cURL;

    public Category() {
    }

    public Category(int cID, String cName, String cURL) {
        this.cID = cID;
        this.cName = cName;
        this.cURL = cURL;
    }

    public String getcURL() {
        return cURL;
    }

    public void setcURL(String cURL) {
        this.cURL = cURL;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
