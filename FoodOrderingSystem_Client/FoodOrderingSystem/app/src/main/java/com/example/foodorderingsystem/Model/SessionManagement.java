package com.example.foodorderingsystem.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.foodorderingsystem.fragment.ProfileFragment;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    private  static  SharedPreferences.Editor editor;
    private Context context;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";
    String SESSION_UBCOINS = "session_userCoins";
    String SESSION_EMAILFORGOT = "session_Emailforgot";
    String SESSION_CODEFORGOT = "session_CodeForgot";
    String SESSION_USER_FIRSTNAME = "session_user_fistname";
    String SESSION_USER_LASTNAME = "session_user_lastname";
    String SESSION_USER_ADDRESSNAME = "session_user_addressname";
    String SESSION_USER_EMAIL = "session_user_email";
    String SESSION_USER_PHONE = "session_user_phone";
    String SESSION_CartList = "session_Cartlist";




    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences (SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit ();
        this.context = context;
    }
    public void save(String emailforgot , String code){
        editor.putString (SESSION_EMAILFORGOT,emailforgot).commit ();
        editor.putString (SESSION_CODEFORGOT,code).commit ();
    }
    public void saveSession(Account account){
        int uId = account.getaID ();
        int uCoins = account.getaCoins();
        editor.putInt (SESSION_KEY,uId).commit ();
        editor.putInt (SESSION_UBCOINS,uCoins).commit ();
        editor.putString (SESSION_USER_ADDRESSNAME,account.getaAddress()).commit();
        editor.putString (SESSION_USER_FIRSTNAME,account.getaFirstname()).commit();
        editor.putString (SESSION_USER_LASTNAME,account.getaLastName()).commit();
        editor.putString (SESSION_USER_EMAIL,account.getaEmail()).commit();
        editor.putString (SESSION_USER_PHONE,account.getaPhone()).commit();
    }
    public int getSession(){ return sharedPreferences.getInt (SESSION_KEY, -1); }
    public int getBcoins(){
        return sharedPreferences.getInt (SESSION_UBCOINS, -1);
    }
    public String getEmailforgot(){return sharedPreferences.getString (SESSION_EMAILFORGOT, "");}
    public String getCodeforgot(){return sharedPreferences.getString (SESSION_CODEFORGOT, "");}
    public String getSessionAddress(){
        return sharedPreferences.getString (SESSION_USER_ADDRESSNAME,null);
    }
    public String getSessionFirstname(){
        return sharedPreferences.getString (SESSION_USER_FIRSTNAME,null);
    }

    public String getSessionLastname(){
        return sharedPreferences.getString (SESSION_USER_LASTNAME,"");
    }
    public String getSessionEmail(){
        return sharedPreferences.getString (SESSION_USER_EMAIL,"");
    }
    public String getSessionPhone(){
        return sharedPreferences.getString (SESSION_USER_PHONE,"");
    }
    public void removeSession(){
        editor.putInt (SESSION_KEY,-1).commit ();
        editor.putInt (SESSION_UBCOINS,-1).commit ();
        editor.putString(SESSION_EMAILFORGOT,"").commit();
        editor.putString(SESSION_CODEFORGOT,"").commit();
        editor.putString(SESSION_CARTLIST,"").commit();

    }
    public void removeSessionCoin(int coin){editor.putInt(SESSION_UBCOINS,coin).commit();}

    public void removeCart(){
        editor.putString(SESSION_CARTLIST,"").commit();
    }
    public List<Cart> getDataFromSharedPreferences(){
        Gson gson = new Gson();
        List<Cart> productFromShared = new ArrayList<>();
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString(SESSION_CARTLIST, "");

        Type type = new TypeToken<List<Cart>>() {}.getType();
        productFromShared = gson.fromJson(jsonPreferences, type);

        return productFromShared;
    }

    public void setDataFromSharedPreferences(Cart curProduct){
        Gson gson = new Gson();
        String jsonCurProduct = gson.toJson(curProduct);

        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(SESSION_CARTLIST, jsonCurProduct);
        editor.commit();
    }

    public void addInJSONArray(Cart productToAdd){

        Gson gson = new Gson();
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String jsonSaved = sharedPref.getString(SESSION_CARTLIST, "");
        String jsonNewproductToAdd = gson.toJson(productToAdd);

        JSONArray jsonArrayProduct= new JSONArray();

        try {
            if(jsonSaved.length()!=0){
                jsonArrayProduct = new JSONArray(jsonSaved);
            }
            jsonArrayProduct.put(new JSONObject(jsonNewproductToAdd));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //SAVE NEW ARRAY
        editor.putString(SESSION_CARTLIST, String.valueOf(jsonArrayProduct));
        editor.commit();
    }
    public void CheckCart(Cart cart){
        Gson gson = new Gson();
        int quantity=0;
        boolean check = true;
        List<Cart> listCart = getDataFromSharedPreferences();
        JSONArray jsonArrayProduct = new JSONArray();
        if(listCart != null){
            for (Cart c : listCart){
                if(c.getpID() == cart.getpID() && c.getaID() == getSession()){
                    check = false;
                    int idx  = listCart.indexOf(c);
                    Cart cart1 = c;
                    quantity= c.getCartQuantity() + cart.getCartQuantity();
                    cart1.setCartQuantity(quantity);
                    listCart.set(idx,cart1);
                    break;
                }else {
                    check =true;
                }
            }
            if (check == true){
                cart.setCartQuantity(cart.getCartQuantity());
                addInJSONArray(cart);
            }else {
                for(Cart c: listCart){
                    String strAdd = gson.toJson(c);
                    try {
                        jsonArrayProduct.put(new JSONObject(strAdd));
                        editor.putString(SESSION_CARTLIST,String.valueOf(jsonArrayProduct));
                        editor.commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            cart.setCartQuantity(cart.getCartQuantity());
            addInJSONArray(cart);
        }
    }

    public void CheckCartForAddOne(Cart cart){
        Gson gson = new Gson();
        int quantity=0;
        boolean check = true;
        List<Cart> listCart = getDataFromSharedPreferences();
        JSONArray jsonArrayProduct = new JSONArray();
        if(listCart != null){
            for (Cart c : listCart){
                if(c.getpID() == cart.getpID() && c.getaID() == getSession()){
                    check = false;
                    int idx  = listCart.indexOf(c);
                    Cart cart1 = c;
                    quantity= c.getCartQuantity() + 1;
                    cart1.setCartQuantity(quantity);
                    listCart.set(idx,cart1);
                    break;
                }else {
                    check =true;
                }
            }
            if (check == true){
                cart.setCartQuantity(cart.getCartQuantity());
                addInJSONArray(cart);
            }else {
                for(Cart c: listCart){
                    String strAdd = gson.toJson(c);
                    try {
                        jsonArrayProduct.put(new JSONObject(strAdd));
                        editor.putString(SESSION_CARTLIST,String.valueOf(jsonArrayProduct));
                        editor.commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            cart.setCartQuantity(cart.getCartQuantity());
            addInJSONArray(cart);
        }
    }

    public void deleteProductFromCart(int pID){
        Gson gson = new Gson();
        List<Cart> listCards= getDataFromSharedPreferences();
        JSONArray jsonArrayProduct= new JSONArray();
        for(Cart cart : listCards) {
            try{
                if (cart.getpID() == pID && cart.getaID()==getSession() && listCards.size() > 0) {
                    listCards.remove(cart);
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }if(listCards.size() == 0){
            editor.putString(SESSION_CARTLIST, null);
            editor.commit();
        }else {
            for(Cart cart : listCards){
                String add = gson.toJson(cart);
                try {
                    jsonArrayProduct.put(new JSONObject(add));
                    editor.putString(SESSION_CARTLIST, String.valueOf(jsonArrayProduct));
                    editor.commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int increaseQuantity(int pID){
        Gson gson = new Gson();
        int quantity=0;
        List<Cart> listCards= getDataFromSharedPreferences();
        JSONArray jsonArrayProduct= new JSONArray();
        for(Cart cart : listCards) {
            if (cart.getpID() == pID && cart.getaID()==getSession()) {
                int index = listCards.indexOf(cart);
                Cart cart1 = cart;
                quantity=cart.getCartQuantity() + 1;
                cart1.setCartQuantity(quantity);
                listCards.set(index, cart1);

                break;
            }
        }
        for(Cart cart : listCards){

            // Type type = new TypeToken<List<Cart>>() {}.getType();
            String add = gson.toJson(cart);
            try {
                jsonArrayProduct.put(new JSONObject(add));
                editor.putString(SESSION_CARTLIST, String.valueOf(jsonArrayProduct));
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return quantity;
    }
    public int decreaseQuantity(int pID){
        Gson gson = new Gson();
        int quantity = 0;
        List<Cart> listCards= getDataFromSharedPreferences();
        JSONArray jsonArrayProduct= new JSONArray();
        for(Cart cart : listCards) {
            if (cart.getpID() == pID && cart.getaID()==getSession()) {
                int index = listCards.indexOf(cart);
                Cart cart1 = cart;
                quantity = cart.getCartQuantity()-1;
                if(quantity<=0){
                    quantity=1;
                    cart1.setCartQuantity(quantity);
                    listCards.set(index, cart1);
                }else{
                    cart1.setCartQuantity(quantity);
                    listCards.set(index, cart1);
                }
                break;
            }
        }
        for(Cart cart : listCards){

            // Type type = new TypeToken<List<Cart>>() {}.getType();
            String add = gson.toJson(cart);
            try {
                jsonArrayProduct.put(new JSONObject(add));
                editor.putString(SESSION_CARTLIST, String.valueOf(jsonArrayProduct));
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return quantity;
    }
}
