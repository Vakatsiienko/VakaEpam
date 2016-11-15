package com.vaka.epam.homework.week2.task8and9;


/**
 * Created by Iaroslav on 11/10/2016.
 */
public class SingleLinkedListTest extends ListTest {

    @Override
    public List<Integer> createList() {
        List<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }
}
