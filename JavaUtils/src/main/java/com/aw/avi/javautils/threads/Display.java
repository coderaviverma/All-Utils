package com.aw.avi.javautils.threads;

/**
 * Created by avinash.verma on 3/27/2018.
 */

public class Display {


    public static synchronized void wish(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("wish ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" " + name);

        }
    }

    public static synchronized void wish1(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Wish 1 ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" " + name);

        }
    }

    public static synchronized void wish6(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Wish 6 ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" " + name);

        }
    }

    public static void wish3(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Wish 3 ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" " + name);

        }
    }

    public synchronized void wish4(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Wish 4 ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" " + name);

        }
    }

    public void wish5(String name) {


        synchronized (this) {
            for (int i = 0; i < 10; i++) {

                System.out.print("Wish 5 ");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(" " + name);

            }
        }

    }
}
