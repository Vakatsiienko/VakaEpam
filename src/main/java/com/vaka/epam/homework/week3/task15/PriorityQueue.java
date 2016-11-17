package com.vaka.epam.homework.week3.task15;

/**
 * Created by Iaroslav on 11/17/2016.
 */
public interface PriorityQueue<T> {
    /**
     * @param priority starts from 0 and end with given number in instantiate constructor
     * @throws IllegalArgumentException if priority is greater than max priority or lower than 0 or if value == null.
     */
    void insert(int priority, T value) throws IllegalArgumentException;

    /**
     * @return element with top priority or null if PriorityQueue is empty.
     */
    T extractMinimum();

    int numberOfPriorities();

    int size();

}
