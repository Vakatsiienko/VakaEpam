package com.vaka.epam.homework.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iaroslav on 14.11.16.
 */
public class DoubleLinkedListIteratorTest extends IteratorTest {

    @Test(expected = NullPointerException.class)
    public void testPrevious() throws Exception {
        DoubleLinkedList<Integer> list = createList();
        BothWayIterator<Integer> iterator = list.iterator();
        int i = list.size() - 1;
        while (iterator.hasPrevious()) {
            Assert.assertTrue(iterator.previous() == i);
            i--;
        }
        System.out.println(iterator.previous());
    }


    @Test
    public void testInsertBefore() throws Exception {
        DoubleLinkedList<Integer> list = createList();
        BothWayIterator<Integer> iterator = list.iterator();
        iterator.next();

        iterator.insertBefore(-1);
        Assert.assertTrue(iterator.previous() == -1);

        iterator = list.iterator();
        iterator.previous();
        iterator.insertBefore(-2);
        Assert.assertTrue(iterator.previous() == -2);

        iterator.previous();
        iterator.previous();
        iterator.insertBefore(-3);
        Assert.assertTrue(iterator.previous() == -3);

    }

    @Test
    public void testInsertAfter() throws Exception {
        DoubleLinkedList<Integer> list = createList();
        BothWayIterator<Integer> iterator = list.iterator();
        iterator.previous();
        iterator.insertAfter(-1);
        Assert.assertTrue(iterator.next() == -1);

        iterator = list.iterator();
        iterator.next();
        iterator.insertAfter(-2);
        Assert.assertTrue(iterator.next() == -2);

        iterator.next();
        iterator.next();

        iterator.insertAfter(-3);
        Assert.assertTrue(iterator.next() == -3);

    }

    @Override
    public DoubleLinkedList<Integer> createList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }
}
