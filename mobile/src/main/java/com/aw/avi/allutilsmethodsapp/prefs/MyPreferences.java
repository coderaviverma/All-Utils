package com.aw.avi.allutilsmethodsapp.prefs;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreferences {
    private static MyPreferences instance;
    private static SharedPreferences sharedPreferences;

    public final static String AGREEMENT_KEY = "Agree";

    public static MyPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new MyPreferences();
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return instance;
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void saveFloat(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void saveBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key, String defaulValue) {
        return sharedPreferences.getString(key, defaulValue);
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public void removeData(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
        editor.commit();
    }


    public static boolean clearAllPrefData(){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
        return true;
    }

}
