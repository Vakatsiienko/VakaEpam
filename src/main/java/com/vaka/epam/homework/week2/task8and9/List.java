package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/8/2016.
 */
public interface List<T> {

    int size();

    boolean isEmpty();

    boolean contains(T t);

    Iterator<T> iterator();

    boolean add(T t);

    boolean remove(T t);

    void addOnIndex(int index, T t);

    T get(int index);

    void removeOnIndex(int index);

    int indexOf(T t);

    void clear();

}
