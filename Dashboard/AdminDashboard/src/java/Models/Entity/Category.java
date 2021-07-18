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
public class Category {

    private int cID;
    private String cName;
    private String iURL;

    /**
     *Constructor
     */
    public Category() {
    }

    /**
     *
     * @param cID
     * @param cName
     * @param iURL
     */
    public Category(int cID, String cName, String iURL) {
        this.cID = cID;
        this.cName = cName;
        this.iURL = iURL;
    }

    /**
     *
     * @return cID
     */
    public int getcID() {
        return cID;
    }

    /**
     *
     * @param cID
     */
    public void setcID(int cID) {
        this.cID = cID;
    }

    /**
     *
     * @return cName
     */
    public String getcName() {
        return cName;
    }

    /**
     *
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
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
