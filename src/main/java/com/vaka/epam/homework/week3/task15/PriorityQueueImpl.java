package com.vaka.epam.homework.week3.task15;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Iaroslav on 11/17/2016.
 */
public class PriorityQueueImpl<T> implements PriorityQueue<T> {
    //TODO add own realization of heap
    private Map<Integer, Queue<T>> repository;
    private final Class queueRealization;
    private final int priorities;

    private PriorityQueueImpl(int priorities, Supplier<? extends Queue<T>> supplier) {
        repository = new HashMap<>();
        this.priorities = priorities;
        for (int i = 0; i < priorities; i++) {
            repository.put(i, supplier.get());
        }
        queueRealization = repository.get(0).getClass();
    }

    @Override
    public void insert(int priority, T value) {
        if (!repository.containsKey(priority) || value == null)
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

    @Override
    public Class queueRealization() {
        return queueRealization;
    }

    /**
     * @param prioritiesCount count of priorities starts from 0 and end with given number.
     * @throws IllegalArgumentException if given number < 0
     */
    public static <E> PriorityQueue<E> createPriorityQueue(int prioritiesCount, Supplier<? extends Queue<E>> supplier) {
        if (prioritiesCount < 0)
            throw new IllegalArgumentException();
        return new PriorityQueueImpl<>(prioritiesCount, supplier);
    }

    /**
     * @return PriorityQueue with 10 priorities(0-9) and Supplier with LinkedList as Queue realisation
     */
    public static <E> PriorityQueue<E> createDefaultPriorityQueue() {
        return new PriorityQueueImpl<>(10, LinkedList::new);
    }

    /**
     * @param prioritiesCount count of priorities starts from 0 and end with given number.
     * @param comparator      will compare elements in each priority queue
     * @throws IllegalArgumentException if given number < 0
     */
    public static <E> PriorityQueue<E> createInnerSortedPriorityQueue(int prioritiesCount, Comparator<E> comparator) {
        if (prioritiesCount < 0)
            throw new IllegalArgumentException();
        Supplier<java.util.PriorityQueue<E>> supplier = () -> new java.util.PriorityQueue(comparator);
        return new PriorityQueueImpl<E>(prioritiesCount, supplier);
    }
}
