package com.example.apimysql.Model;

public class Account {
    private int aID;
    private int rID;
    private int roleID;
    private String aEmail;
    private String aPassword;
    private int aCoins;
    private String aFirstname;
    private String aLastname;
    private String aPhone;
    private String aAddress;
    private int aStatus;

    public Account(int aID, int rID, int roleID, String aEmail, String aPassword, int aCoins, String aFirstname, String aLastname, String aPhone, String aAddress, int aStatus) {
        this.aID = aID;
        this.rID = rID;
        this.roleID = roleID;
        this.aEmail = aEmail;
        this.aPassword = aPassword;
        this.aCoins = aCoins;
        this.aFirstname = aFirstname;
        this.aLastname = aLastname;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.aStatus = aStatus;
    }

    public Account() {
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

    public double getaCoins() {
        return aCoins;
    }

    public void setaCoins(int aCoins) {
        this.aCoins = aCoins;
    }

    public String getaFirstname() {
        return aFirstname;
    }

    public void setaFirstname(String aFirstname) {
        this.aFirstname = aFirstname;
    }

    public String getaLastname() {
        return aLastname;
    }

    public void setaLastname(String aLastname) {
        this.aLastname = aLastname;
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
}
