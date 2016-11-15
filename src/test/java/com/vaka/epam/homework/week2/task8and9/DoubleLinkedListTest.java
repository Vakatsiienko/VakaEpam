package com.vaka.epam.homework.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iaroslav on 11/9/2016.
 */
public class DoubleLinkedListTest extends ListTest{

    @Override
    public List<Integer> createList() {
        List<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }
}
