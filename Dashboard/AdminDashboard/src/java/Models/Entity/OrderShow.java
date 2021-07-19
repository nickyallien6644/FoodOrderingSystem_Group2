/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

import java.sql.Date;

/**
 *
 * @author phuct
 */
public class OrderShow {

    private int oID;
    private String aFirstname;
    private String aPhone;
    private String aAddress;
    private int oAmountTotal;
    private Date oDateCreate;
    private int oStatus;

    /**
     * Constructor
     */
    public OrderShow() {
    }

    /**
     *
     * @param oID
     * @param aFirstname
     * @param aPhone
     * @param aAddress
     * @param oAmountTotal
     * @param oDateCreate
     * @param oStatus
     */
    public OrderShow(int oID, String aFirstname, String aPhone, String aAddress, int oAmountTotal, Date oDateCreate, int oStatus) {
        this.oID = oID;
        this.aFirstname = aFirstname;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.oAmountTotal = oAmountTotal;
        this.oDateCreate = oDateCreate;
        this.oStatus = oStatus;
    }

    /**
     *
     * @return oID
     */
    public int getoID() {
        return oID;
    }

    /**
     *
     * @param oID
     */
    public void setoID(int oID) {
        this.oID = oID;
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
     * @return oAmountTotal
     */
    public int getoAmountTotal() {
        return oAmountTotal;
    }

    /**
     *
     * @param oAmountTotal
     */
    public void setoAmountTotal(int oAmountTotal) {
        this.oAmountTotal = oAmountTotal;
    }

    /**
     *
     * @return oDateCreate
     */
    public Date getoDateCreate() {
        return oDateCreate;
    }

    /**
     *
     * @param oDateCreate
     */
    public void setoDateCreate(Date oDateCreate) {
        this.oDateCreate = oDateCreate;
    }

    /**
     *
     * @return oStatus
     */
    public int getoStatus() {
        return oStatus;
    }

    /**
     *
     * @param oStatus
     */
    public void setoStatus(int oStatus) {
        this.oStatus = oStatus;
    }

}
