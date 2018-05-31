package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/23/2018.
 */

public class Thread1 extends Thread {

    String name, data;

    public Thread1(String name, String data) {
        this.name = name;
        this.data = data;

    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 1 running " + name);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
