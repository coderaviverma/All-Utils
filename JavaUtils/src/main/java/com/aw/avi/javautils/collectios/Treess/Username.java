package com.aw.avi.javautils.collectios.Treess;

/**
 * Created by avinash.verma on 3/15/2018.
 */

public class Username implements Comparable {

    private String name;

    private String location;


    public Username(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {

        Username u1 = (Username) o;

        return -this.name.compareTo(u1.getName());
    }
}
