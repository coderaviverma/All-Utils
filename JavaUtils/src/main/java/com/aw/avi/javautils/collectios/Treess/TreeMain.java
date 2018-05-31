package com.aw.avi.javautils.collectios.Treess;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by avinash.verma on 3/15/2018.
 */

public class TreeMain {


    public static void main(String[] args) {


        TreeSet treeSet = new TreeSet(new MyComparator());
        treeSet.add("A");
        treeSet.add("X");
        treeSet.add("C");
        treeSet.add("V");
        treeSet.add("S");
        treeSet.add("D");
        treeSet.add("D");
        treeSet.add("a");


//        System.out.println(treeSet);

//        TreeSet treeSet2 = new TreeSet(new MyTreeComparator());
        TreeSet treeSet2 = new TreeSet();
        treeSet2.add(new Username("Avi", "punjab"));
        treeSet2.add(new Username("Avi1", "punjab"));
        treeSet2.add(new Username("Avi2", "punjab"));
        treeSet2.add(new Username("Avi3", "punjab"));
        treeSet2.add(new Username("Avi7", "punjab"));
        treeSet2.add(new Username("Avi4", "punjab"));
        treeSet2.add(new Username("Avi6", "punjab"));
        treeSet2.add(new Username("Avi2", "punjab"));
//        System.out.println(treeSet2);


//        String name = "Avi";
//        String res;
//
//        System.out.println("name ----> " + name + " reslocation " + name.hashCode());
//
//
//        res = name.concat("Verma");
//        System.out.println("res ----> " + res + " reslocation " + res.hashCode());
//
//        res =  name.concat("awesome");
//        System.out.println("res ----> " + res + " reslocation " + res.hashCode());
//
//        System.out.println(name);
//        System.out.println("name ----> " + name + " reslocation " + name.hashCode());

        String name = "Avi";

        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.reverse();

//        System.out.println(stringBuilder.toString());

        //Method 2

        char[] vale = name.toCharArray();
        char[] reverse = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            reverse[i] = vale[name.length() - 1 - i];
        }


        System.out.println(vale);
        System.out.println(reverse);

    }
}


class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

//        Integer s1 = (Integer) o1;
//        Integer s2 = (Integer) o2;
//
//        if (s1 < s2) {
//
//            return +1;
//        } else if (s1 > s2) {
//
//            return -1;
//        } else {
//            return 0;
//        }

        String s1 = (String) o1;
        String s2 = (String) o2;

//        if (s1 < s2) {
//
//            return +1;
//        } else if (s1 > s2) {
//
//            return -1;
//        } else {
//            return 0;
//        }

        return -s1.compareTo(s2);
    }
}
