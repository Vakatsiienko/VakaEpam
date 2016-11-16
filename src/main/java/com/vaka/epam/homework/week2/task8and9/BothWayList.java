package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/16/2016.
 */
public interface BothWayList<T> extends List<T> {
    @Override
    BothWayIterator<T> iterator();
}
