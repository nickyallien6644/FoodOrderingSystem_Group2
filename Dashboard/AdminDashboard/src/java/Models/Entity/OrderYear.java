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
public class OrderYear {

    private Date year;
    private int count;

    /**
     * Constructor
     */
    public OrderYear() {
    }

    /**
     *
     * @param year
     * @param count
     */
    public OrderYear(Date year, int count) {
        this.year = year;
        this.count = count;
    }

    /**
     *
     * @return year
     */
    public Date getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

}
