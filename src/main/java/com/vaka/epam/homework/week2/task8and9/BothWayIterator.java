package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/10/2016.
 */
public interface BothWayIterator<T> extends Iterator<T> {

    T previous();

    void toLast();

    void insert(T t);
}
