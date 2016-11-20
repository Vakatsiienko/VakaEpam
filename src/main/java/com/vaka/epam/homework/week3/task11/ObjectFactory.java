package com.vaka.epam.homework.week3.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by iaroslav on 18.11.16.
 */
public class ObjectFactory<T> {

    T t;
    ReferenceQueue<T> queue = new ReferenceQueue<>();
    PhantomReference<T> ref = new PhantomReference<>(t, queue);

    public static void main(String[] args) {
        ObjectFactory<Object> factory = new ObjectFactory<>();
    }



}
