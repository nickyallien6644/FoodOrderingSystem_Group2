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
    String SESSION_EmailForgot = "session_Emailforgot";
    String SESSION_CodeForgot = "session_CodeForgot";
    String SESSION_USER_FIRSTNAME = "session_user_fistname";
    String SESSION_USER_LASTNAME = "session_user_lastname";
    String SESSION_USER_ADDRESSNAME = "session_user_addressname";
    String SESSION_USER_EMAIL = "session_user_email";
    String SESSION_USER_PHONE = "session_user_email";
    String SESSION_CartList = "session_Cartlist";

    private static final String PRODUCT_TAG = "MyCart";


    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences (SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit ();
        this.context = context;
    }

    public void save(String emailforgot , String code){
        editor.putString (SESSION_EmailForgot,emailforgot).commit ();
        editor.putString (SESSION_CodeForgot,code).commit ();
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
    public String getEmailforgot(){return sharedPreferences.getString (SESSION_EmailForgot, "");}
    public String getCodeforgot(){return sharedPreferences.getString (SESSION_CodeForgot, "");}
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
        editor.putString(SESSION_EmailForgot,"").commit();
        editor.putString(SESSION_CodeForgot,"").commit();
        editor.putString(PRODUCT_TAG,"").commit();

    }
    public List<Cart> getDataFromSharedPreferences(){
        Gson gson = new Gson();
        List<Cart> productFromShared = new ArrayList<>();
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString(PRODUCT_TAG, "");

        Type type = new TypeToken<List<Cart>>() {}.getType();
        productFromShared = gson.fromJson(jsonPreferences, type);

        return productFromShared;
    }

    public void setDataFromSharedPreferences(Cart curProduct){
        Gson gson = new Gson();
        String jsonCurProduct = gson.toJson(curProduct);

        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(PRODUCT_TAG, jsonCurProduct);
        editor.commit();
    }

    public void addInJSONArray(Cart productToAdd){

        Gson gson = new Gson();
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String jsonSaved = sharedPref.getString(PRODUCT_TAG, "");
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
        editor.putString(PRODUCT_TAG, String.valueOf(jsonArrayProduct));
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
//                    addInJSONArray(cart);
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
                        editor.putString(PRODUCT_TAG,String.valueOf(jsonArrayProduct));
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

    public int increase(int idSale){
        Gson gson = new Gson();
        int quantity=0;
        List<Cart> list= getDataFromSharedPreferences();
        JSONArray jsonArrayProduct= new JSONArray();
        for(Cart i :list) {
            if (i.getCartID() == idSale&& i.getaID()==getSession()) {
                int index = list.indexOf(i);
                Cart cart1 = i;
                quantity=i.getCartQuantity() + 1;
                cart1.setCartQuantity(quantity);
                list.set(index, cart1);

                break;
            }
        }
        for(Cart i :list){

            // Type type = new TypeToken<List<Cart>>() {}.getType();
            String add = gson.toJson(i);
            try {
                jsonArrayProduct.put(new JSONObject(add));
                editor.putString(PRODUCT_TAG, String.valueOf(jsonArrayProduct));
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return quantity;
    }
    public int decreaseCart(int idSale){
        Gson gson = new Gson();
        int quantity=0;
        List<Cart> list= getDataFromSharedPreferences();
        JSONArray jsonArrayProduct= new JSONArray();
        for(Cart i :list) {
            if (i.getCartID() == idSale&& i.getaID()==getSession()) {
                int index = list.indexOf(i);
                Cart cart1 = i;
                quantity=i.getCartQuantity()-1;
                if(quantity<0){
                    quantity=0;
                    cart1.setCartQuantity(quantity);
                    list.set(index, cart1);
                }else{
                    cart1.setCartQuantity(quantity);
                    list.set(index, cart1);
                }


                break;
            }
        }
        for(Cart i :list){

            // Type type = new TypeToken<List<Cart>>() {}.getType();
            String add = gson.toJson(i);
            try {
                jsonArrayProduct.put(new JSONObject(add));
                editor.putString(PRODUCT_TAG, String.valueOf(jsonArrayProduct));
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return quantity;
    }
//    public void deleteCart(int idSale){
//        Gson gson = new Gson();
//        List<Cart> list= getDataFromSharedPreferences();
//        JSONArray jsonArrayProduct= new JSONArray();
//        for(Cart i :list) {
//            System.out.println(idSale+"heeeeeeeeeeee"+i.getIdSale());
//            if (i.getIdSale() == idSale&& i.getIdUser()==getIdSession()) {
//                int index = list.indexOf(i);
//                list.remove(index);
//                System.out.println(list.size()+"kkkkkkkkkk");
//                break;
//            }
//        }
//        if(list.size()==0){
//            editor.putString(SESSION_CART, null);
//            editor.commit();
//        }else{
//            for(Cart i :list){
//
//                // Type type = new TypeToken<List<Cart>>() {}.getType();
//                String add = gson.toJson(i);
//                try {
//                    jsonArrayProduct.put(new JSONObject(add));
//                    editor.putString(SESSION_CART, String.valueOf(jsonArrayProduct));
//                    editor.commit();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }




}
