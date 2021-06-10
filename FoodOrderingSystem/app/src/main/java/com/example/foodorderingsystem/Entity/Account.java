package com.example.foodorderingsystem.Entity;

public class Account {

    public Account() {
    }

    public Account(int aID, int roleID, String aEmail, String aPassword, Double aCoins, String aFirstname, String aLastName, String aPhone, String aAddress, int aStatus) {
        this.aID = aID;
        this.roleID = roleID;
        this.aEmail = aEmail;
        this.aPassword = aPassword;
        this.aCoins = aCoins;
        this.aFirstname = aFirstname;
        this.aLastName = aLastName;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.aStatus = aStatus;
    }

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

    public Double getaCoins() {
        return aCoins;
    }

    public void setaCoins(Double aCoins) {
        this.aCoins = aCoins;
    }

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

    private int aID;
    private int roleID;
    private String aEmail;
    private String aPassword;
    private Double aCoins;
    private String aFirstname;
    private String aLastName;
    private String aPhone;
    private String aAddress;
    private int aStatus;


}
