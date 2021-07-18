/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

import java.sql.Time;

/**
 *
 * @author phuct
 */
public class Restaurant {

    private int rId;
    private String rName;
    private String rTimeOpen;
    private String rTimeClose;
    private String rAddress;
    private String rPhone;
    private String rImage;

    /**
     * Constructor
     */
    public Restaurant() {
    }

    /**
     *
     * @param rId
     * @param rName
     * @param rTimeOpen
     * @param rTimeClose
     * @param rAddress
     * @param rPhone
     * @param rImage
     */
    public Restaurant(int rId, String rName, String rTimeOpen, String rTimeClose, String rAddress, String rPhone, String rImage) {
        this.rId = rId;
        this.rName = rName;
        this.rTimeOpen = rTimeOpen;
        this.rTimeClose = rTimeClose;
        this.rAddress = rAddress;
        this.rPhone = rPhone;
        this.rImage = rImage;
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

    /**
     *
     * @return rName
     */
    public String getrName() {
        return rName;
    }

    /**
     *
     * @param rName
     */
    public void setrName(String rName) {
        this.rName = rName;
    }

    /**
     *
     * @return rTimeOpen
     */
    public String getrTimeOpen() {
        return rTimeOpen;
    }

    /**
     *
     * @param rTimeOpen
     */
    public void setrTimeOpen(String rTimeOpen) {
        this.rTimeOpen = rTimeOpen;
    }

    /**
     * 
     * @return rTimeClose
     */
    public String getrTimeClose() {
        return rTimeClose;
    }

    /**
     *
     * @param rTimeClose
     */
    public void setrTimeClose(String rTimeClose) {
        this.rTimeClose = rTimeClose;
    }

    /**
     *
     * @return rAddress
     */
    public String getrAddress() {
        return rAddress;
    }

    /**
     *
     * @param rAddress
     */
    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    /**
     *
     * @return rPhone
     */
    public String getrPhone() {
        return rPhone;
    }

    /**
     *
     * @param rPhone
     */
    public void setrPhone(String rPhone) {
        this.rPhone = rPhone;
    }

    /**
     *
     * @return rImage
     */
    public String getrImage() {
        return rImage;
    }

    /**
     *
     * @param rImage
     */
    public void setrImage(String rImage) {
        this.rImage = rImage;
    }

}
