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

    public Image() {
    }

    public Image(int iID, int pID, String iURL) {
        this.iID = iID;
        this.pID = pID;
        this.iURL = iURL;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getiURL() {
        return iURL;
    }

    public void setiURL(String iURL) {
        this.iURL = iURL;
    }
    
    
}