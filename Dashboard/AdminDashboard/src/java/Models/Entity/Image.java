/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entity;

/**
 *
 * @author MSI
 */
public class Image {

    private int iID;
    private int pID;
    private String iURL;

    /**
     * Constructor
     */
    public Image() {
    }

    /**
     *
     * @param iID
     * @param pID
     * @param iURL
     */
    public Image(int iID, int pID, String iURL) {
        this.iID = iID;
        this.pID = pID;
        this.iURL = iURL;
    }

    /**
     *
     * @return iID
     */
    public int getiID() {
        return iID;
    }

    /**
     *
     * @param iID
     */
    public void setiID(int iID) {
        this.iID = iID;
    }

    /**
     *
     * @return pID
     */
    public int getpID() {
        return pID;
    }

    /**
     *
     * @param pID
     */
    public void setpID(int pID) {
        this.pID = pID;
    }

    /**
     *
     * @return iURL
     */
    public String getiURL() {
        return iURL;
    }

    /**
     *
     * @param iURL
     */
    public void setiURL(String iURL) {
        this.iURL = iURL;
    }

}
