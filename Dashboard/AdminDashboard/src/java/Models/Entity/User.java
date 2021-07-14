/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

/**
 *
 * @author TuNNACE140381
 */
public class User implements Cloneable{

    public User(int aID, int rID, int roleID, String aEmail, String aPassword, double aCoins, String aFirstname, String aLastname, String aPhone, String aAddress, String aStatus) {
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

    public User() {
       
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
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

    public double getaCoins() {
        return aCoins;
    }

    public void setaCoins(double aCoins) {
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

    public String getaStatus() {
        return aStatus;
    }

    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
    }

    @Override
    public String toString() {
        return "User{" + "aID=" + aID + ", roleID=" + roleID + ", aEmail=" + aEmail + ", aPassword=" + aPassword + ", aCoins=" + aCoins + ", aFirstname=" + aFirstname + ", aLastname=" + aLastname + ", aPhone=" + aPhone + ", aAddress=" + aAddress + ", aStatus=" + aStatus + '}';
    }
    private int aID;
    private int rID;
    private int roleID;
    private String aEmail;
    private String aPassword;
    private double aCoins;
    private String aFirstname;
    private String aLastname;
    private String aPhone;
    private String aAddress;
    private String aStatus;
    
    
}
