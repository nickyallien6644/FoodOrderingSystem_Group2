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
public class OrderMonth {

    private Date month;
    private int count;

    /**
     *
     */
    public OrderMonth() {
    }

    /**
     *
     * @param date
     * @param count
     */
    public OrderMonth(Date date, int count) {
        this.month = date;
        this.count = count;
    }

    /**
     *
     * @return month
     */
    public Date getMonth() {
        return month;
    }

    /**
     *
     * @param date
     */
    public void setMonth(Date date) {
        this.month = date;
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
