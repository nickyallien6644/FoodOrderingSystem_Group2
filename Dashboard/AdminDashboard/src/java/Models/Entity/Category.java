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
public class Category {
    private int cID;
    private String cName;
    private String cURL;

    public Category(int cID, String cName, String cURL) {
        this.cID = cID;
        this.cName = cName;
        this.cURL = cURL;
    }
    

    public Category() {
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcURL() {
        return cURL;
    }

    public void setcURL(String cURL) {
        this.cURL = cURL;
    }
    
    
}
