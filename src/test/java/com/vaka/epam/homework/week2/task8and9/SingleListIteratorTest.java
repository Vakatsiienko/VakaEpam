package com.vaka.epam.homework.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iaroslav on 14.11.16.
 */
public class SingleListIteratorTest {
    @Test
    public void testNext() throws Exception {
        Iterator<Integer> iterator = createList().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertTrue(iterator.next() == i);
            i++;
        }
    }

    @Test
    public void testHasNext() throws Exception {
        List<Integer> list = createList();
        Iterator<Integer> iterator = list.iterator();
        list.add(60000);
        while (iterator.next() != 60000) {
        }
        Assert.assertFalse(iterator.hasNext());
    }


    public List<Integer> createList() {
            List<Integer> list = new SingleLinkedList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
            return list;
        }
}
