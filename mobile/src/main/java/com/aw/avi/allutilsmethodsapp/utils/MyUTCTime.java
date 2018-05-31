package com.aw.avi.allutilsmethodsapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by akshay.kumar on 3/21/2017.
 */

public class MyUTCTime {


    public static String getUTCTime(String dateTime){
        String formattedDate=null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date date=df.parse(dateTime);
            c.setTime(date);
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            formattedDate = df.format(c.getTime());

        }catch (Exception e){
            e.printStackTrace();
        }

        return formattedDate;
    }

    public static String findCurrentDateYYYY(String dateTime) {
        String formattedDate=null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date=dfIn.parse(dateTime);
            c.setTime(date);
             formattedDate = df.format(c.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

        return formattedDate;
    }
    public static String getCurrentUTCTime(){
        String formattedDate=null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            formattedDate = df.format(c.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

        return formattedDate;
    }

    public static String getLocalTimeFromUTC(String dateTime){
        String formattedDateTime = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = df.parse(dateTime);
            df.setTimeZone(TimeZone.getDefault());
            formattedDateTime = df.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            formattedDateTime = "";
        }

        return formattedDateTime;
    }

}
