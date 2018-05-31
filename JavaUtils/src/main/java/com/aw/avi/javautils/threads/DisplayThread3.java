package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/27/2018.
 */

public class DisplayThread3 extends Thread {

    Display display;

    String name;

    public DisplayThread3(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {

        display.wish3(name);

    }
}
