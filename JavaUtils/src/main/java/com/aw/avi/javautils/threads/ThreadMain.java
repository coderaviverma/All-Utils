package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/23/2018.
 */

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);

        thread1.start(); //Thread will be created.

        thread1.run();//Normal method no thread will be created.

        thread1.interrupt();//To intrerrupt the sleeping or waiting thread.


        Thread.yield();

        Thread.sleep(1000);

        myRunnable.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadMain ....");
        }


        Thread1 thread11 = new Thread1("Avi", "Aurg");



    }
}
