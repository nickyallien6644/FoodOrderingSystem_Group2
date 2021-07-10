package com.example.foodorderingsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Account {


    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public int getaCoins() { return aCoins; }

    public void setaCoins(int aCoins) { this.aCoins = aCoins; }

    public String getaFirstname() {
        return aFirstname;
    }

    public void setaFirstname(String aFirstname) {
        this.aFirstname = aFirstname;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public int getaStatus() {
        return aStatus;
    }

    public void setaStatus(int aStatus) {
        this.aStatus = aStatus;
    }
    @SerializedName("aID")
    @Expose
    private int aID;
    @SerializedName("roleID")
    @Expose
    private int roleID;
    @SerializedName("aEmail")
    @Expose
    private String aEmail;
    @SerializedName("aPassword")
    @Expose
    private String aPassword;
    @SerializedName("aCoins")
    @Expose
    private int aCoins;
    @SerializedName("aFirstname")
    @Expose
    private String aFirstname;
    @SerializedName("aLastname")
    @Expose
    private String aLastName;
    @SerializedName("aPhone")
    @Expose
    private String aPhone;
    @SerializedName("aAddress")
    @Expose
    private String aAddress;
    @SerializedName("aStatus")
    @Expose
    private int aStatus;


}
