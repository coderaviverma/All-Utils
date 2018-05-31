package com.aw.avi.javautils.hackerrank;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by avinash.verma on 2/15/2018.
 */

public class HackerRank {

    public static void main(String[] args) {
        currecnyFormat(12424141);
    }


    //    Java Currency Formatter
    private static void currecnyFormat(double payment) {
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance().format(payment).replace("$","Rs.");
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        System.out.println("India: " + india);

    }
}
