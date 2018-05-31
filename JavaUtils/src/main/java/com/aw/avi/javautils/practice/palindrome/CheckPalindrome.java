package com.aw.avi.javautils.practice.palindrome;

/**
 * Created by avinash.verma on 1/19/2018.
 */

public class CheckPalindrome {

    public static void main(String[] args) {
        int n = 545;

        int temp;
        temp = n;
        int sum = 0, r;

        while (n > 0) {

            r = n % 10;

            sum = (sum * 10) + r;

            n = n / 10;

        }

        if (sum == temp) {
            System.out.println("Palindrome");
        }


    }
}
