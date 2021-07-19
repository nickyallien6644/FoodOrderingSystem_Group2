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
public class User implements Cloneable {

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

    /**
     *
     * @param aID
     * @param roleID
     * @param aEmail
     * @param aPassword
     * @param aCoins
     * @param aFirstname
     * @param aLastname
     * @param aPhone
     * @param aAddress
     * @param aStatus
     * @param rID
     */
    public User(int aID, int roleID, String aEmail, String aPassword, double aCoins, String aFirstname, String aLastname, String aPhone, String aAddress, String aStatus, int rID) {
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

    /**
     * Constructor
     */
    public User() {

    }

    /**
     *
     * @return rID
     */
    public int getrID() {
        return rID;
    }

    /**
     *
     * @param rID
     */
    public void setrID(int rID) {
        this.rID = rID;
    }

    /**
     *
     * @return aID
     */
    public int getaID() {
        return aID;
    }

    /**
     *
     * @param aID
     */
    public void setaID(int aID) {
        this.aID = aID;
    }

    /**
     *
     * @return roleID
     */
    public int getRoleID() {
        return roleID;
    }

    /**
     *
     * @param roleID
     */
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    /**
     *
     * @return aEmail
     */
    public String getaEmail() {
        return aEmail;
    }

    /**
     *
     * @param aEmail
     */
    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    /**
     *
     * @return aPassword
     */
    public String getaPassword() {
        return aPassword;
    }

    /**
     *
     * @param aPassword
     */
    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    /**
     *
     * @return aCoins
     */
    public double getaCoins() {
        return aCoins;
    }

    /**
     *
     * @param aCoins
     */
    public void setaCoins(double aCoins) {
        this.aCoins = aCoins;
    }

    /**
     *
     * @return aFirstname
     */
    public String getaFirstname() {
        return aFirstname;
    }

    /**
     *
     * @param aFirstname
     */
    public void setaFirstname(String aFirstname) {
        this.aFirstname = aFirstname;
    }

    /**
     *
     * @return aLastname
     */
    public String getaLastname() {
        return aLastname;
    }

    /**
     *
     * @param aLastname
     */
    public void setaLastname(String aLastname) {
        this.aLastname = aLastname;
    }

    /**
     *
     * @return aPhone
     */
    public String getaPhone() {
        return aPhone;
    }

    /**
     *
     * @param aPhone
     */
    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    /**
     *
     * @return aAddress
     */
    public String getaAddress() {
        return aAddress;
    }

    /**
     *
     * @param aAddress
     */
    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    /**
     *
     * @return aStatus
     */
    public String getaStatus() {
        return aStatus;
    }

    /**
     *
     * @param aStatus
     */
    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
    }

    @Override
    public String toString() {
        return "User{" + "aID=" + aID + ", roleID=" + roleID + ", aEmail=" + aEmail + ", aPassword=" + aPassword + ", aCoins=" + aCoins + ", aFirstname=" + aFirstname + ", aLastname=" + aLastname + ", aPhone=" + aPhone + ", aAddress=" + aAddress + ", aStatus=" + aStatus + '}';
    }

}
