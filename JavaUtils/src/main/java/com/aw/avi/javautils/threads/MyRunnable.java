package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/23/2018.
 */

public class MyRunnable implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable is running....");
        }
    }
}
