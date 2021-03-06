package com.vaka.epam.homework.accomplished.week2.task8and9;

import java.util.NoSuchElementException;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//9.	Реализовать двухсвязанный список.
// Реализация должна предусматривать наличие элемента header,
// в котором есть ссылка на первй и последний элемент списка(DoubleLinkedList).
public class DoubleLinkedList<T> extends AbstractLinkedList<T> implements BothWayList<T> {

    private int size;

    private Node first;
    private Node last;

    private int modCount;

    private void insertBefore(Node before, Node insertion) {
        Node node = before.previous;
        before.previous = insertion;
        insertion.previous = node;
        insertion.next = before;
        if (before == first)
            first = insertion;
        else node.next = insertion;
        size++;
    }

    private void unlink(Node removing) {
        modCount++;
        if (first == removing) {
            unlinkFirst();
            return;
        }
        if (last == removing) {
            last = last.previous;
            last.next = null;
            size--;
            return;
        }
        removing.previous.next = removing.next;
        removing.next = removing.previous;
        size--;
    }

    private void unlinkFirst() {
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
    }

    private Node getNodeOnIndex(int index) {
        checkIndexForAdd(index);
        Node element;
        if (size / 2 > index) {
            element = first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
        } else {
            element = last;
            for (int i = 1, y = size - index; i < y; i++) {
                element = element.previous;
            }
        }
        return element;
    }


    @Override
    public boolean add(T t) {
        if (size == 0) {
            first = new Node(t);
            last = first;
        } else {
            Node node = new Node(t);
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
        return true;
    }

    @Override
    public void addOnIndex(int index, T t) {
        checkIndexForAdd(index);
        Node element;
        if (size == index) {
            add(t);
            return;
        } else
            element = getNodeOnIndex(index);
        insertBefore(element, new Node(t));
    }

    @Override
    public BothWayIterator<T> iterator() {
        return new DoubleLinkLIter();
    }

    @Override
    public T get(int index) {
        return getNodeOnIndex(index).item;
    }

    @Override
    public void removeOnIndex(int index) {
        unlink(getNodeOnIndex(index));
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        private T item;
        private Node next;
        private Node previous;

        private Node(T t) {
            item = t;
        }

        private Node(Node previous, T item, Node next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private class DoubleLinkLIter implements BothWayIterator<T> {

        private DoubleLinkedList<T> list;

        private Node pointer;
        private int modCount;

        private DoubleLinkLIter() {
            this.list = DoubleLinkedList.this;
            modCount = list.modCount;
        }

        @Override
        public T next() throws NoSuchElementException {
            checkModifications();
            if (first == null)
                throw new NoSuchElementException();
            else if (pointer == null)
                pointer = list.first;
            else if (pointer.next != null)
                pointer = pointer.next;
            else
                throw new NoSuchElementException();
            return pointer.item;
        }

        @Override
        public T previous() {
            checkModifications();
            if (pointer == null) {
                if (list.last == null)
                    throw new NoSuchElementException();
                pointer = list.last;
            } else pointer = pointer.previous;
            return pointer.item;
        }

        @Override
        public void remove() {
            checkModifications();
            if (pointer == null)
                throw new NoSuchElementException();
            unlink(pointer);
            modCount++;
        }

        @Override
        public T set(T item) {
            checkModifications();
            if (pointer == null) {
                throw new NoSuchElementException();
            }
            T previous = pointer.item;
            pointer.item = item;
            return previous;
        }

        @Override
        public void insertBefore(T t) {
            checkModifications();
            if (pointer == null)
                throw new NoSuchElementException();
            Node insertion = new Node(pointer.previous, t, pointer);
            if (pointer != first)
                pointer.previous.next = insertion;
            pointer.previous = insertion;
        }

        @Override
        public void insertAfter(T t) {
            checkModifications();
            if (pointer == null)
                throw new NoSuchElementException();
            Node insertion = new Node(pointer, t, pointer.next);
            if (pointer != last)
                pointer.next.previous = insertion;
            pointer.next = insertion;
        }

        @Override
        public boolean hasNext() {
            checkModifications();
            if (pointer == null)
                return first != null;
            return pointer.next != null;
        }

        @Override
        public boolean hasPrevious() {
            checkModifications();
            if (pointer == null)
                return first != null;
            return pointer.previous != null;
        }

        private void checkModifications() {
            if (modCount != list.modCount)
                throw new ModificationException();
        }
    }


}
