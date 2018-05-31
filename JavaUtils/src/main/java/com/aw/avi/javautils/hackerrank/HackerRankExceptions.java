package com.aw.avi.javautils.hackerrank;

import java.util.Scanner;

/**
 * Created by avinash.verma on 2/15/2018.
 */

public class HackerRankExceptions {

    static int B;
    static int H;
    static boolean flag = false;

    static {
        areaBlock();
    }

    //    private static void areaBlock() throws ExceptionInInitializerError {
//        Scanner scanner = new Scanner(System.in);
//        B = scanner.nextInt();
//        H = scanner.nextInt();
//
//        if (B < 0 || H < 0) {
//            flag = false;
//            throw new ExceptionInInitializerError("java.lang.Exception: Breadth and height must be positive");
//        } else {
//            flag = true;
//        }
//    }
    private static void areaBlock() {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();

        if (B < 0 || H < 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }


}


class MyCustomException extends Exception {

    public MyCustomException(String message) {
        super(message);
    }
}