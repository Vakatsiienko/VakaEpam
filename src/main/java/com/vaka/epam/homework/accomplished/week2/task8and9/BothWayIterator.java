package com.vaka.epam.homework.accomplished.week2.task8and9;

/**
 * Created by Iaroslav on 11/10/2016.
 */
public interface BothWayIterator<T> extends LLIterator<T> {

    T previous();

    boolean hasPrevious();

    void insertBefore(T t);

    void insertAfter(T t);


}
