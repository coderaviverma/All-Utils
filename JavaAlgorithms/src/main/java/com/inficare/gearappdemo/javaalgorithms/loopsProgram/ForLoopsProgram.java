package com.inficare.gearappdemo.javaalgorithms.loopsProgram;

import java.util.Scanner;

/**
 * Created by avinash.verma on 2/13/2018.
 */

public class ForLoopsProgram {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int sumOfB = 0;

            for (int j = 0; j < n; j++) {
                sumOfB += (Math.pow(2, j) * b);

                System.out.print(a + sumOfB + " ");
            }
//            int totalSum = a + sumOfB;

//            System.out.print(totalSum + " ");
        }
        System.out.println("");


        in.close();

    }
}
