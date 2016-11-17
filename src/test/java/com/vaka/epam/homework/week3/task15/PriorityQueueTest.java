package com.vaka.epam.homework.week3.task15;

import org.junit.Assert;
import org.junit.Test;


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
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(priorities);
        Assert.assertTrue(queue.numberOfPriorities() == priorities);
    }

    @Test
    public void testSize() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                queue.insert(i, j);
           }
        }
        Assert.assertTrue(queue.size() == 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePriorityQueue() throws Exception {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(10);
        Assert.assertTrue(queue.size() == 0);
        Assert.assertTrue(queue.numberOfPriorities() == 10);
        Assert.assertTrue(queue.extractMinimum() == null);
        PriorityQueueImpl.createPriorityQueue(-10);
    }

    public PriorityQueue<Integer> createFullPQueue() {
        PriorityQueue<Integer> queue = PriorityQueueImpl.createPriorityQueue(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                queue.insert(i, j);
            }
        }
        return queue;
    }

}
