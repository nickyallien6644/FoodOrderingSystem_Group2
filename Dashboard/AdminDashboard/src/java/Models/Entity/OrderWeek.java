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

    public OrderWeek() {
    }

    public OrderWeek(Date dayOfWeek, int count) {
        this.dayOfWeek = dayOfWeek;
        this.count = count;
    }

    public Date getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Date dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
