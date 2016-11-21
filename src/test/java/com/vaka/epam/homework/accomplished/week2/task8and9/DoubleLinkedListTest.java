package com.vaka.epam.homework.accomplished.week2.task8and9;


/**
 * Created by Iaroslav on 11/9/2016.
 */
public class DoubleLinkedListTest extends ListTest {

    @Override
    public List<Integer> createCollectedList() {
        List<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public List<Integer> createEmptyList() {
        return new DoubleLinkedList<>();
    }
}
