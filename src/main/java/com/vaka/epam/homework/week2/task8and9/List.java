package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/8/2016.
 */
public interface List<T> {

    T add(T t);

    T addOnIndex(int index, T t);

    T get(int index);

    boolean remove(T t);

    boolean removeOnIndex(int index);

    boolean contains(T t);

    int indexOf(T t);

    SingleWayIterator<T> iterator();

}
