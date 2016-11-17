package com.vaka.epam.homework.week3.task15;

import java.util.*;

/**
 * Created by Iaroslav on 11/17/2016.
 */
public class PriorityQueueImpl<T> implements PriorityQueue<T> {
    private Map<Integer, Queue<T>> repository;
    private final int priorities;

    private PriorityQueueImpl(int priorities) {
        repository = new HashMap<>();
        this.priorities = priorities;
        for (int i = 0; i < priorities; i++) {
            repository.put(i, new LinkedList<>());
        }
    }

    @Override
    public void insert(int priority, T value) {
        if (!repository.containsKey(priority))
            throw new IllegalArgumentException();
        repository.get(priority).offer(value);
    }

    @Override
    public T extractMinimum() {
        for (int i = 0; i < priorities; i++) {
            if (repository.get(i).isEmpty())
                continue;
            return repository.get(i).poll();
        }
        return null;
    }

    @Override
    public int numberOfPriorities() {
        return priorities;
    }

    @Override
    public int size() {
        return repository.values().stream()
                .mapToInt(Queue::size).sum();
    }

    /**
     * @param maxPriority count of priorities starts from 0 and end with given number.
     * @throws IllegalArgumentException if given number < 0
     */
    public static <E> PriorityQueue<E> createPriorityQueue(int maxPriority) {
        if (maxPriority < 0)
            throw new IllegalArgumentException();
        return new PriorityQueueImpl<>(maxPriority);
    }

}
