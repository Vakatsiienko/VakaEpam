package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/8/2016.
 */
interface Iterator<T> {
    T next();

    boolean hasNext();

    boolean remove();

    T set(T item);

    void toFirst();

}
