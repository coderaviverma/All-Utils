package com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.hetrorecy.models;

/**
 * Created by avinash.verma on 3/14/2018.
 */

public class Users {

    private String name;

    private String location;


    public Users(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
