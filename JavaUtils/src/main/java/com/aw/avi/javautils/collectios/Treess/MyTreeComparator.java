package com.aw.avi.javautils.collectios.Treess;

import java.util.Comparator;

/**
 * Created by avinash.verma on 3/15/2018.
 */

public class MyTreeComparator implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        Username u1 = (Username) o1;
        Username u2 = (Username) o2;

        return (u1.getName().toString()).compareTo(u2.getName().toString());
    }
}
