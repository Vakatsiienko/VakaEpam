package com.vaka.epam.homework.week3.task15;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by Iaroslav on 11/17/2016.
 */
public class PriorityQueueTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInsert() throws Exception {
        PriorityQueue<Integer> queue = createFullPQueue();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Assert.assertTrue(queue.extractMinimum() == j);
            }
        }
        queue.insert(-1, 100);
        Assert.assertTrue(queue.extractMinimum() == null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertNull() throws Exception {

        PriorityQueue<Integer> queue = createFullPQueue();
        queue.insert(0, null);

    }

    @Test
    public void testExtractMinimum() throws Exception {
        PriorityQueue<Integer> queue = createFullPQueue();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Assert.assertTrue(queue.extractMinimum() == j);
            }
        }
        Assert.assertTrue(queue.extractMinimum() == null);
    }

    @Test
    public void testGetNumberOfPriorities() throws Exception {
        int priorities = 25;
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(priorities, LinkedList::new);
        Assert.assertTrue(queue.numberOfPriorities() == priorities);
        queue = PriorityQueueImpl.createDefaultPriorityQueue();
        Assert.assertTrue(queue.numberOfPriorities() == 10);

    }

    @Test
    public void testSize() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createDefaultPriorityQueue();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                queue.insert(i, j);
            }
        }
        Assert.assertTrue(queue.size() == 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePriorityQueue() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(15, LinkedList::new);
        Assert.assertTrue(queue.size() == 0);
        Assert.assertTrue(queue.numberOfPriorities() == 15);
        Assert.assertTrue(queue.extractMinimum() == null);
        Assert.assertEquals(queue.queueRealization(), LinkedList.class);

        queue = PriorityQueueImpl.createPriorityQueue(20, LinkedBlockingQueue::new);
        Assert.assertEquals(queue.queueRealization(), LinkedBlockingQueue.class);
        Assert.assertTrue(queue.numberOfPriorities() == 20);
        Assert.assertTrue(queue.extractMinimum() == null);
        Assert.assertTrue(queue.size() == 0);


        PriorityQueueImpl.createPriorityQueue(-10, LinkedList::new);

    }

    @Test
    public void testCreateDefaultPriorityQueue() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createDefaultPriorityQueue();
        Assert.assertTrue(queue.size() == 0);
        Assert.assertTrue(queue.numberOfPriorities() == 10);
        Assert.assertTrue(queue.extractMinimum() == null);
        Assert.assertEquals(queue.queueRealization(), LinkedList.class);
    }

    @Test
    public void testCreateInnerSortedPriorityQueue() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createInnerSortedPriorityQueue(42, Integer::compareTo);
        Assert.assertTrue(queue.size() == 0);
        Assert.assertTrue(queue.numberOfPriorities() == 42);
        Assert.assertTrue(queue.extractMinimum() == null);
        Assert.assertEquals(queue.queueRealization(), java.util.PriorityQueue.class);

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                queue.insert(i, r.nextInt());
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                Assert.assertTrue(queue.extractMinimum() <= queue.extractMinimum());
            }
        }
    }




    public PriorityQueue<Integer> createFullPQueue() {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createDefaultPriorityQueue();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                queue.insert(i, j);
            }
        }
        return queue;
    }

}
