/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

/**
 *
 * @author phuct
 */
public class Account {

    private int aID;
    private int rID;
    private int roleID;
    private String aemail;
    private String aPassword;
    private double aCoins;
    private String aFirstname;
    private String aLastname;
    private String aPhone;
    private String aAddress;
    private int aStatus;
    private int rId;

    /**
     * Constructor Account
     */
    public Account() {
    }

    /**
     *
     * @param aID
     * @param roleID
     * @param aemail
     * @param aPassword
     * @param aCoins
     * @param aFirstname
     * @param aLastname
     * @param aPhone
     * @param aAddress
     * @param aStatus
     * @param rId
     */
    public Account(int aID, int roleID, String aemail, String aPassword, double aCoins, String aFirstname, String aLastname, String aPhone, String aAddress, int aStatus, int rId) {
        this.aID = aID;
        this.roleID = roleID;
        this.aemail = aemail;
        this.aPassword = aPassword;
        this.aCoins = aCoins;
        this.aFirstname = aFirstname;
        this.aLastname = aLastname;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.aStatus = aStatus;
        this.rId = rId;
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
     * @return aemail
     */
    public String getAemail() {
        return aemail;
    }

    /**
     *
     * @param aemail
     */
    public void setAemail(String aemail) {
        this.aemail = aemail;
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
     * @return aFristname
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
    public int getaStatus() {
        return aStatus;
    }

    /**
     *
     * @param aStatus
     */
    public void setaStatus(int aStatus) {
        this.aStatus = aStatus;
    }

    /**
     *
     * @return rId
     */
    public int getrId() {
        return rId;
    }

    /**
     *
     * @param rId
     */
    public void setrId(int rId) {
        this.rId = rId;
    }
}
