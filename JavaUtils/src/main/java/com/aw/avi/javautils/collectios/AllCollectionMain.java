package com.aw.avi.javautils.collectios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash.verma on 3/6/2018.
 */

public class AllCollectionMain {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("X");
        strings.add("C");
        strings.add("V");
        strings.add("S");
        strings.add("D");
        strings.add("D");
        strings.add("a");

        List<TestModel> customModel = new ArrayList<>();
        customModel.add(new TestModel("A", "2"));
        customModel.add(new TestModel("B", "46"));
        customModel.add(new TestModel("C", "4"));
        customModel.add(new TestModel("A", "2"));
        customModel.add(new TestModel("H", "2"));
        customModel.add(new TestModel("A", "2"));


//        System.out.println(Collections.frequency(customModel, "A"));


        String s = "Avinash";


//        String s = "foo";
        byte[] bytes = s.getBytes();

        System.out.println("bytes " + bytes);

        StringBuilder binary = new StringBuilder();

        for (byte b : bytes) {
            int val = b;

            System.out.println("val " + val);

            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
                System.out.println("val << " + val);
            }
            binary.append(' ');
        }

        System.out.println("'" + s + "' to binary: " + binary);


        System.out.println("Integer to binary String ---> ");

        String result = "";
        char[] messChar = s.toCharArray();

        for (int i = 0; i < messChar.length; i++) {
            result += Integer.toBinaryString(messChar[i]) + " ";
        }

        System.out.println("result --->>> "+result);
    }


    public static class TestModel {
        private String name;
        private String value;

        public TestModel(String name, String value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return name;
        }


        @Override
        public boolean equals(Object obj) {
            return name.equalsIgnoreCase(obj.toString());
        }
    }

}
