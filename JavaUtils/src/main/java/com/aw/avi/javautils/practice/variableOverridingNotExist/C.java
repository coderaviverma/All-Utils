package com.aw.avi.javautils.practice.variableOverridingNotExist;

/**
 * Created by avinash.verma on 1/5/2018.
 */

public class C {

    public static void main(String[] args) {
        A objectA = new B();
        objectA.a = 20;
//        System.out.println();
        objectA.avi();
    }
}
