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

    /**
     *Constructor
     */
    public TotalRevenue() {
    }

    /**
     *
     * @param day
     * @param month
     * @param year
     * @param priceDay
     * @param priceMonth
     * @param priceYear
     */
    public TotalRevenue(String day, String month, String year, int priceDay, int priceMonth, int priceYear) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.priceDay = priceDay;
        this.priceMonth = priceMonth;
        this.priceYear = priceYear;
    }

    /**
     *
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     *
     * @return month
     */ 
    public String getMonth() {
        return month;
    }

    /**
     *
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     *
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return priceDay
     */
    public int getPriceDay() {
        return priceDay;
    }

    /**
     *
     * @param priceDay
     */
    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    /**
     *
     * @return priceMonth
     */
    public int getPriceMonth() {
        return priceMonth;
    }

    /**
     *
     * @param priceMonth
     */
    public void setPriceMonth(int priceMonth) {
        this.priceMonth = priceMonth;
    }

    /**
     *
     * @return priceYear
     */
    public int getPriceYear() {
        return priceYear;
    }

    /**
     *
     * @param priceYear
     */
    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }
 


}
