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
public class TotalRevenue {

    private String day;
    private String month;
    private String year;

    private int priceDay;
    private int priceMonth;
    private int priceYear;

    public TotalRevenue() {
    }

    public TotalRevenue(String day, String month, String year, int priceDay, int priceMonth, int priceYear) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.priceDay = priceDay;
        this.priceMonth = priceMonth;
        this.priceYear = priceYear;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(int priceMonth) {
        this.priceMonth = priceMonth;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }
 


}
