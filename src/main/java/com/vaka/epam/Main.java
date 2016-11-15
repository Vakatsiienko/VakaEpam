package com.vaka.epam;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by iaroslav on 14.11.16.
 */
public class Main<T> {
    public static void main(String[] args) {
        List list = new LinkedList<>();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(null);
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        Object object = new Object();
        list.add(object);
        int index = list.indexOf(object);
        System.out.println(index);
    }
}
