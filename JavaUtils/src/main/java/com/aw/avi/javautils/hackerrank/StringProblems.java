package com.aw.avi.javautils.hackerrank;

/**
 * Created by avinash.verma on 2/20/2018.
 */

public class StringProblems {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String A = sc.next();
//        String B = sc.next();

//        System.out.println(A.length() + B.length());
//
//        if (A.compareTo(B) > 0) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//
//        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1));

        String word = "He is a very. very! good -boy, isn't he?";
        splitMyString(word);

    }


    //Split String
    private static void splitMyString(String word) {

//        String[] splitedWord = word.split("\\s!,|\\.- _ |'");
        String[] splitedWord = word.split("[\\s@!,'.?_]+");
        System.out.println(splitedWord.length);

        for (String splitword : splitedWord) {
            System.out.println(splitword);
        }

    }
}
