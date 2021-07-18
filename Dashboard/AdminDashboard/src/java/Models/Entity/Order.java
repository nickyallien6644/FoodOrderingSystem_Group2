/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

import java.util.Date;


/**
 *
 * @author MSI
 */
public class Order {
    private int oID;
    private int aID;
    private int rID;
    private int oAmountTotal;
    private Date oDateCreate;
    private String oNote;
    private String oCode;

    /**
     *
     * @param oID
     * @param aID
     * @param rID
     * @param oAmountTotal
     * @param oDateCreate
     * @param oNote
     * @param oCode
     * @param oStatus
     */
    public Order(int oID, int aID, int rID, int oAmountTotal, Date oDateCreate, String oNote, String oCode, int oStatus) {
        this.oID = oID;
        this.aID = aID;
        this.rID = rID;
        this.oAmountTotal = oAmountTotal;
        this.oDateCreate = oDateCreate;
        this.oNote = oNote;
        this.oCode = oCode;
        this.oStatus = oStatus;
    }
    private int oStatus;

    /**
     *Constructor
     */
    public Order() {
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

    /**
     *
     * @return oNote
     */
    public String getoNote() {
        return oNote;
    }

    /**
     *
     * @param oNote
     */
    public void setoNote(String oNote) {
        this.oNote = oNote;
    }

    /**
     *
     * @return oCode
     */
    public String getoCode() {
        return oCode;
    }

    /**
     *
     * @param oCode
     */
    public void setoCode(String oCode) {
        this.oCode = oCode;
    }
    
    
    
    
}
