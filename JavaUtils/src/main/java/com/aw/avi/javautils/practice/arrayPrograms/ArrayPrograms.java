package com.aw.avi.javautils.practice.arrayPrograms;

import java.util.Arrays;

/**
 * Created by avinash.verma on 2/5/2018.
 */

public class ArrayPrograms {


    public static void main(String[] args) {
        int[] value = {1, 4, 6, 7, 9, 9, 3, 4, 5, 6};

        findElementInArrayLinear(value, 5);

        System.out.println("findOddNumberInBetweenRange : " + Arrays.toString(findOddNumberInBetweenRange(50, 110)));
    }


    private static void findElementInArrayLinear(int[] ints, int value) {

        for (int number : ints) {
            if (value == number) {
                break;
            }
        }

    }

    private static int[] findOddNumberInBetweenRange(int l, int r) {

//        ArrayList<Integer> value = new ArrayList<>();
        int length = ((r - l) / 2);
        int[] oddList = new int[length];

        int totalvalues = 0;
        for (int i = l; i <= r; i++) {
            if (i % 2 == 1) {
                oddList[totalvalues] = i;
                totalvalues++;
            }
        }
//        Integer[] oddnumberList = value.toArray(new Integer[value.size()]);

        return oddList;
    }



}
