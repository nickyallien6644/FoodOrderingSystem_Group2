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

    public Order() {
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
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

    public String getoNote() {
        return oNote;
    }

    public void setoNote(String oNote) {
        this.oNote = oNote;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode;
    }
    
    
    
    
}
