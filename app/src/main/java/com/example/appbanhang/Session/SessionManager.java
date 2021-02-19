package com.example.appbanhang.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.appbanhang.Activity.MainActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public int PRIVATE_MODE = 0;
    public Context context;


    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String ID_USER = "ID";
    public static final String ADDRESS = "ADDRESS";
    public static final String PHONE = "PHONE";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LOGIN", PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(int id, String name, String email, String address, String phone) {
        editor.putString(ID_USER, String.valueOf(id));
        editor.putBoolean(LOGIN, true);
        editor.putString(NAME, name);
        editor.putString(EMAIL, email);
        editor.putString(ADDRESS, address);
        editor.putString(PHONE, phone);
        editor.apply();
    }


    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }


    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(ID_USER, sharedPreferences.getString(ID_USER, null));
        user.put(ADDRESS, sharedPreferences.getString(ADDRESS, null));
        user.put(PHONE, sharedPreferences.getString(PHONE, null));
        return user;
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
//        ((MainActivity) context).finish();
    }
}
