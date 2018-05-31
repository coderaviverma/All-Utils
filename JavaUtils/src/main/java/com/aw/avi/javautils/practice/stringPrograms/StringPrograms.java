package com.aw.avi.javautils.practice.stringPrograms;

/**
 * Created by avinash.verma on 2/5/2018.
 */

public class StringPrograms {

    public static void main(String[] args) {
        String data = "My Name is Avinash";

        reverseAStringUsingBytes(data);

        reverseAStringUsingStringBuilder(data);

        reverseAStringUsingCharAt(data);
    }

    private static void reverseAStringUsingBytes(String data) {

        byte[] bytearray = data.getBytes();
        byte[] result = new byte[bytearray.length];

        for (int i = 0; i < bytearray.length; i++) {
            result[i] = bytearray[bytearray.length - i - 1];
        }

        System.out.println("reverseAStringUsingBytes :" + new String(result));
    }


    private static void reverseAStringUsingStringBuilder(String data) {

        StringBuilder stringBuilder = new StringBuilder(data);

        String result = stringBuilder.reverse().toString();

        System.out.println("reverseAStringUsingStringBuilder :" + result);


        StringBuffer stringBuffer = new StringBuffer(data);
        String result2 = stringBuffer.reverse().toString();
        System.out.println("reverseAStringUsingStringBuffer :" + result2);

    }


    private static void reverseAStringUsingCharAt(String data) {

        char[] charArry = data.toCharArray();

        String result = "";
        for (int i = charArry.length - 1; i >= 0; i--) {
            result += charArry[i];
        }
        System.out.println("reverseAStringUsingCharAt : " + result);

    }
}
