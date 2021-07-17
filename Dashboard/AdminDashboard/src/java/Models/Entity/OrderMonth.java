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

    public OrderMonth() {
    }

    public OrderMonth(Date date, int count) {
        this.month = date;
        this.count = count;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date date) {
        this.month = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
