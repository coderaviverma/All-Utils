package com.aw.avi.javautils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class MyClass {

    public static void main(String[] args) {

//Colletion -> List,Queue,Set
        //        collectionDemo();


        //List
        //List and Array List
//        listMethod();

        //Linked List Methods
        linkedlistMethods();

        //Vector
        vectorDemo();


    }

    /**
     * List and Arraylist Demo Method
     * <p>
     * ArrayLists are not synchronized.
     */
    private static void listMethod() {
        List list = new ArrayList();
//        list.add(100);
//        list.add(14);
//        list.add(56);

        list.add("100");
        list.add("ABC");
        list.add("dgfy123");
        list.add("123");
        list.add("#4fds");


        //add at unknown index
//        list.add(2, 1);

        iteratorLoop(list);

        collectionsSortDemo(list);
    }

    /**
     * Linked List Demo
     * <p>
     * Implemented with double linkedlist
     */
    private static void linkedlistMethods() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("22");


        linkedList.add("3");
        linkedList.add("16");

        linkedList.add(3, 5);


        List list = new ArrayList(linkedList);


        iteratorLoop(linkedList);

    }

    /**
     * Vector Demo
     * <p>
     * Increase capacity by double by default it is 10 capacity.
     * from version 1.0
     */
    private static void vectorDemo() {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(4);
        vector.add(2);


        printData(vector.capacity());

    }


    /**
     * Collection Demo Method
     */
    private static void collectionDemo() {
        Collection collection = new ArrayList();
        collection.add("Avi");
        collection.add(2);

        iteratorLoop(collection);
    }


    /**
     * Iterator Loop for All collection
     *
     * @param collection
     */
    private static void iteratorLoop(Collection collection) {
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            printData(iterator.next());
        }
    }

    /**
     * List Sorting
     *
     * @param list
     */
    private static void collectionsSortDemo(List list) {

        printData("Sorting Data......");
        Collections.sort(list);

        iteratorLoop(list);

    }

    private static void printData(Object data) {
        System.out.println(data);
    }

    private void setCollection() {

        Set<String> value = new TreeSet<>();
    }
}

