package com.vaka.epam.homework.accomplished.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iaroslav on 15.11.16.
 */
public abstract class ListTest {
    @Test
    public void testAdd() throws Exception {
        List<Integer> list = createCollectedList();
        Integer last = 5000;
        list.add(last);
        list.add(null);
        Assert.assertSame(last, list.get(list.size() - 2));
        Assert.assertTrue(null == list.get(list.size() - 1));
        list.remove(null);
    }

    @Test
    public void testAddOnIndex() throws Exception {
        List<Integer> list = createCollectedList();
        Integer elem = -1;
        Integer last = -10;
        Integer middle = -5;
        list.addOnIndex(0, elem);
        list.addOnIndex(500, middle);
        list.addOnIndex(list.size(), last);

        try {
            list.addOnIndex(-4, -16);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }
        try {
            list.addOnIndex(10000, -16);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }

        Assert.assertFalse(list.contains(-16));
        Assert.assertSame(elem, list.get(0));
        Assert.assertSame(middle, list.get(500));
        Assert.assertSame(last, list.get(list.size() - 1));
    }

    @Test
    public void testGet() throws Exception {
        List<Integer> list = createCollectedList();

        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(
                    String.format("Expected %s, actual %s", i, list.get(i)), i == list.get(i));
        }
        try {
            list.get(-10);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }
        try {
            list.get(10000);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }
    }

    @Test
    public void testRemove() throws Exception {
        List<Integer> list = createCollectedList();

        Assert.assertTrue(list.remove(0));
        Assert.assertFalse(list.remove(0));
        Assert.assertTrue(list.get(0) != 0);

        Assert.assertTrue(list.remove(100));
        Assert.assertFalse(list.remove(100));
        Assert.assertFalse(list.contains(100));


        Integer last = list.get(list.size() - 1);
        Assert.assertTrue(list.remove(last));
        Assert.assertFalse(list.remove(last));
        Assert.assertTrue(list.get(list.size() - 1) != last);


        Assert.assertFalse(list.remove(null));
        list.add(5000);
        Assert.assertTrue(list.remove(5000));

        list.add(null);
        Assert.assertTrue(list.remove(null));
        Assert.assertFalse(list.contains(null));
    }

    @Test()
    public void testRemoveOnIndex() throws Exception {
        List<Integer> list = createCollectedList();
        list.add(5000);


        list.removeOnIndex(list.size() - 1);
        Assert.assertFalse(list.contains(5000));

        list.removeOnIndex(500);
        Assert.assertFalse(list.contains(500));

        list.removeOnIndex(0);
        Assert.assertFalse(list.contains(0));

        try {
            list.removeOnIndex(-10);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }
        try {
            list.removeOnIndex(10000);
            Assert.fail();
        } catch (IndexOutOfBoundsException expected) {
        }
    }

    @Test
    public void testIndexOf() throws Exception {
        List<Integer> list = createCollectedList();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(i == list.indexOf(i));
        }
        list.add(null);
        Assert.assertTrue(list.indexOf(null) == list.size() - 1);
        list.remove(null);
        Assert.assertEquals(-1, list.indexOf(null));
        Assert.assertEquals(-1, list.indexOf(5000));
    }

    @Test
    public void testContains() throws Exception {
        List<Integer> list = createEmptyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);

        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(null));
        Assert.assertFalse(list.contains(-1));
        list.remove(null);
        Assert.assertFalse(list.contains(null));
    }

    @Test
    public void testIterator() throws Exception {
        List<Integer> list = createCollectedList();
        Assert.assertNotNull(list.iterator());
    }

    @Test
    public void testClear() throws Exception {
        List<Integer> list = createCollectedList();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(i == list.get(i));
        }
        list.clear();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertFalse(list.contains(i));
        }
        Assert.assertTrue(0 == list.size());
        list.clear();
        Assert.assertTrue(0 == list.size());
    }

    @Test
    public void testSize() throws Exception {
        List<Integer> list = createCollectedList();
        int size = list.size();
        list.add(45);
        size++;
        Assert.assertTrue(size == list.size());
        list.remove(45);
        size--;
        Assert.assertTrue(size == list.size());
        list.clear();
        Assert.assertTrue(0 == list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        List<Integer> full = createCollectedList();
        List<Integer> empty = createEmptyList();

        Assert.assertFalse(full.isEmpty());
        Assert.assertTrue(empty.isEmpty());

        full.clear();
        Assert.assertTrue(full.isEmpty());

        empty.add(34);
        Assert.assertFalse(empty.isEmpty());

    }

    public abstract List<Integer> createCollectedList();

    public abstract List<Integer> createEmptyList();

}
