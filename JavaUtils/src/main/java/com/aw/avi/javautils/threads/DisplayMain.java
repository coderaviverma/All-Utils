package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/27/2018.
 */

public class DisplayMain {

    public static void main(String[] args) {

        Display display = new Display();
//        Display display2 = new Display();
//        Display display3 = new Display();
//        display.wish("name");


        DisplayThread1 thread1 = new DisplayThread1(display, "Avi");
        thread1.start();

        DisplayThread2 thread2 = new DisplayThread2(display, "Kundan");
        thread2.start();

        DisplayThread3 thread3 = new DisplayThread3(display, "Suraj");
        thread3.start();

        DisplayThread4 thread4 = new DisplayThread4(display, "Thread 4");
        thread4.start();


        DisplayThread5 thread5 = new DisplayThread5(display, "Thread 5");
        thread5.start();

        DisplayThread6 thread6 = new DisplayThread6(display, "Thread 6");
        thread6.start();


    }
}
