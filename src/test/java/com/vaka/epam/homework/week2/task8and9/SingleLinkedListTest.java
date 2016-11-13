package com.vaka.epam.homework.week2.task8and9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iaroslav on 11/10/2016.
 */
public class SingleLinkedListTest {
    @Test
    public void testAdd() throws Exception {
        List<String> list = new SingleLinkedList<>();
        String helloWorld = "HelloWorld";
        list.add(helloWorld);
        list.add(null);
        Assert.assertTrue(list.contains(null));

        Assert.assertSame(helloWorld, list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOnIndex() throws Exception {
        List<String> list = new SingleLinkedList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        String elem = "new element";
        String last = "last element";
        String middle = "middle element";
        list.addOnIndex(0, elem);
        list.addOnIndex(4, last);
        list.addOnIndex(2, middle);

        list.addOnIndex(-4, "some elem");

        Assert.assertNotEquals("some elem", list.get(-4));
        Assert.assertSame(elem, list.get(0));
        Assert.assertSame(middle, list.get(2));
        Assert.assertSame(last, list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() throws Exception {
        List<String> list = new SingleLinkedList<>();
        String secondElem = "second element";
        list.add("first element");
        list.add(secondElem);
        list.add("third element");

        Assert.assertSame(secondElem, list.get(1));
        Assert.assertNotEquals(null, list.get(4));
        Assert.assertNotEquals(null, list.get(-10));
    }

    @Test
    public void testRemove() throws Exception {
        List<String> list = new SingleLinkedList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        Assert.assertTrue(list.remove("second element"));
        Assert.assertFalse(list.remove("second element"));
        Assert.assertFalse(list.contains("second element"));
        Assert.assertFalse(list.remove(null));
        list.add(null);
        Assert.assertTrue(list.remove(null));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOnIndex() throws Exception {
        List<String> list = new SingleLinkedList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");

        list.removeOnIndex(1);
        Assert.assertFalse(list.contains("second element"));
        try {
            list.removeOnIndex(-10);

        } catch (IndexOutOfBoundsException expected) {
        }
        try {
            list.removeOnIndex(10);

        } catch (IndexOutOfBoundsException expected) {
        }
    }

    @Test
    public void testIndexOf() throws Exception {
        List<String> list = new SingleLinkedList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        list.add("second element");
        list.add(null);

        Assert.assertEquals(0, list.indexOf("first element"));
        Assert.assertEquals(1, list.indexOf("second element"));
        Assert.assertEquals(2, list.indexOf("third element"));
        Assert.assertEquals(-1, list.indexOf("some element"));
        Assert.assertEquals(4, list.indexOf(null));
        list.remove(null);
        Assert.assertEquals(-1, list.indexOf(null));

    }

    @Test
    public void testContains() throws Exception {
        List<String> list = new SingleLinkedList<>();
        list.add("first element");
        list.add("second element");
        list.add("third element");
        list.add(null);

        Assert.assertTrue(list.contains("first element"));
        Assert.assertTrue(list.contains("second element"));
        Assert.assertTrue(list.contains("third element"));
        Assert.assertTrue(list.contains(null));
        Assert.assertFalse(list.contains("someElement"));
        list.remove(null);
        Assert.assertFalse(list.contains(null));
    }

    @Test
    public void testIterator() throws Exception {
        List<String> list = new SingleLinkedList<>();
        Assert.assertNotNull(list.iterator());
    }

    public static List<Integer> createList(){
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }
}
