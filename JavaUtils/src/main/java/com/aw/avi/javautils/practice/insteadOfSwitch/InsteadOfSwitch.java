package com.aw.avi.javautils.practice.insteadOfSwitch;

import com.aw.avi.javautils.practice.insteadOfSwitch.polyexample.Cheeta;
import com.aw.avi.javautils.practice.insteadOfSwitch.polyexample.PolyBird;

/**
 * Created by avinash.verma on 1/16/2018.
 */

public class InsteadOfSwitch {

    public static void main(String[] args) {

        PolyBird polyBird = new Cheeta();
        printData(polyBird.getSpeed());
        printData(polyBird.noReturnMethod());
    }

    private static void printData(Object data) {
        System.out.println(data);
    }
}
