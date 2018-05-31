package com.aw.avi.javautils.practice.abstractdemo;

/**
 * Created by avinash.verma on 2/12/2018.
 */

public class ExtendedDemo extends MainAbstract {

    public static void main(String[] args) {
        System.out.println("ExtendedDemo Called");

    }

    @Override
    boolean inheritanceMethod(String string) {
        System.out.println("inheritanceMethod Called");

        return false;
    }


}
