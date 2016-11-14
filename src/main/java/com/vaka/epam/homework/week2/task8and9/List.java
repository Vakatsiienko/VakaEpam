package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/8/2016.
 */
public interface List<T> {

    void add(T t);

    void addOnIndex(int index, T t);

    T get(int index);

    boolean remove(T t);

    void removeOnIndex(int index);

    boolean contains(T t);

    int indexOf(T t);

    void removeAll();

    int size();

    SingleWayIterator<T> iterator();

}
