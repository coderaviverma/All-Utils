package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/27/2018.
 */

public class DisplayThread6 extends Thread {

    Display display;

    String name;

    public DisplayThread6(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {

        display.wish6(name);

    }
}
