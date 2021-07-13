package com.example.apimysql.Model;

public class Cart {
    private int cartID;
    private int pID;
    private int aID;
    private int cartQuantity;

    public Cart(int cartID, int pID, int aID, int cartQuantity) {
        this.cartID = cartID;
        this.pID = pID;
        this.aID = aID;
        this.cartQuantity = cartQuantity;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
