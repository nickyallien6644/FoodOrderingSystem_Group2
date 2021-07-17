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

    public OrderShow() {
    }

    public OrderShow(int oID, String aFirstname, String aPhone, String aAddress, int oAmountTotal, Date oDateCreate, int oStatus) {
        this.oID = oID;
        this.aFirstname = aFirstname;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.oAmountTotal = oAmountTotal;
        this.oDateCreate = oDateCreate;
        this.oStatus = oStatus;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public String getaFirstname() {
        return aFirstname;
    }

    public void setaFirstname(String aFirstname) {
        this.aFirstname = aFirstname;
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

    public int getoAmountTotal() {
        return oAmountTotal;
    }

    public void setoAmountTotal(int oAmountTotal) {
        this.oAmountTotal = oAmountTotal;
    }

    public Date getoDateCreate() {
        return oDateCreate;
    }

    public void setoDateCreate(Date oDateCreate) {
        this.oDateCreate = oDateCreate;
    }

    public int getoStatus() {
        return oStatus;
    }

    public void setoStatus(int oStatus) {
        this.oStatus = oStatus;
    }

}
