package com.vaka.epam.homework.accomplished.week2.task8and9;


/**
 * Created by iaroslav on 14.11.16.
 */
public class SingleLinkedListIteratorTest extends IteratorTest {


    @Override
    public List<Integer> createList() {
        List<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }
}
