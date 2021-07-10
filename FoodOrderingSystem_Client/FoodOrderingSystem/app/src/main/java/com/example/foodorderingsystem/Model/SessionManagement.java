package com.example.foodorderingsystem.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";
    String SESSION_UBCOINS = "session_userCoins";
    String SESSION_EmailForgot = "session_Emailforgot";
    String SESSION_CodeForgot = "session_CodeForgot";


    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences (SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit ();
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

    }
    public int getSession(){ return sharedPreferences.getInt (SESSION_KEY, -1); }
    public int getBcoins(){
        return sharedPreferences.getInt (SESSION_UBCOINS, -1);
    }
    public String getEmailforgot(){return sharedPreferences.getString (SESSION_EmailForgot, "");}
    public String getCodeforgot(){return sharedPreferences.getString (SESSION_CodeForgot, "");}
    public void removeSession(){
        editor.putInt (SESSION_KEY,-1).commit ();
        editor.putInt (SESSION_UBCOINS,-1).commit ();
        editor.putString(SESSION_EmailForgot,"").commit();
        editor.putString(SESSION_CodeForgot,"").commit();
    }
}
