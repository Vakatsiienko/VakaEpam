package com.vaka.epam.homework.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by Iaroslav on 11/15/2016.
 */
public abstract class IteratorTest {

    @Test
    public void testNext() throws Exception {
        LLIterator<Integer> iterator = createList().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertTrue(iterator.next() == i);
            i++;
        }
    }

    @Test(expected = ModificationException.class)
    public void testHasNext() throws Exception {
        List<Integer> list = createList();
        LLIterator<Integer> iterator = list.iterator();
        list.add(60000);
        while (iterator.next() != 60000) {
        }
        Assert.assertFalse(iterator.hasNext());

        iterator = list.iterator();
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        list.clear();
        Assert.assertFalse(iterator.hasNext());

    }

    @Test
    public void testRemove() throws Exception {
        List<Integer> list = createList();
        LLIterator<Integer> iterator = list.iterator();
        list.add(12345);

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Assert.assertFalse(list.contains(12345));

        list.addOnIndex(0, 54321);
        iterator = list.iterator();
        iterator.next();
        iterator.remove();
        Assert.assertFalse(list.contains(54321));

        list = createList();
        iterator = list.iterator();
        list.addOnIndex(500, 5544);
        for (int i = 0; i < 501; i++) {
            iterator.next();
        }
        iterator.remove();
        Assert.assertFalse(list.contains(5544));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSet() throws Exception {
        List<Integer> list = createList();
        LLIterator<Integer> iterator = list.iterator();

        iterator.set(6000);
        Assert.assertFalse(list.contains(6000));

        for (int i = 0; i < 10; i++) {
            iterator.next();
        }
        Integer integer = -1000;
        iterator.set(integer);
        Assert.assertSame(integer, list.get(10));
        list.remove(-1000);
        Assert.assertFalse(list.contains(-1000));
    }



    public abstract List<Integer> createList();
}
