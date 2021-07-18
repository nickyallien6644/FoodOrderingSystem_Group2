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
public class OrderWeek {

    private int count;
    private Date dayOfWeek;

    /**
     * Constructor
     */
    public OrderWeek() {
    }

    /**
     *
     * @param dayOfWeek
     * @param count
     */
    public OrderWeek(Date dayOfWeek, int count) {
        this.dayOfWeek = dayOfWeek;
        this.count = count;
    }

    /**
     *
     * @return dayOfWeek
     */
    public Date getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     *
     * @param dayOfWeek
     */
    public void setDayOfWeek(Date dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
