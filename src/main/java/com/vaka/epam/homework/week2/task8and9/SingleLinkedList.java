package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements List<T> {

    private int size;
    private Node first;
    private Node last;

    private void unlink(Node element) {
        Node previous = first;
        if (first == element) {
            first = first.next;
            size--;
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.next == element) {
                previous = x;
                break;
            }
        }
        if (previous.next.next != null)
            previous.next = previous.next.next;
            //if our element is last node
        else previous.next = null;
        size--;
    }

    @Override
    public boolean add(T t) {
        if (size == 0) {
            first = new Node(t);
            last = first;
        } else {
            Node node = new Node(t);
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    private void linkFirst(T t) {
        first = new Node(t, first);
        size++;
    }

    private void linkAfter(Node node, T item) {
        Node next = node.next;
        node.next = new Node(item, next);
        size++;
    }

    @Override
    public void addOnIndex(int index, T t) {
        checkIndexForAdd(index);
        Node element = first;
        if (size == index) {
            add(t);
            return;
        } else if (index == 0) {
            linkFirst(t);
            return;
        } else for (int i = 0; i < index - 1; i++) {
            element = element.next;
        }
        linkAfter(element, t);
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkLIter();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkIndexForGet(index);
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    }

    @Override
    public void removeOnIndex(int index) {
        checkIndexForGet(index);
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        unlink(x);
    }

    private class Node {
        private T item;
        private Node next;


        private Node(T item) {
            this.item = item;
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    private class SingleLinkLIter implements Iterator<T> {

        private SingleLinkedList<T> list;

        private Node pointer;

        private SingleLinkLIter() {
            this.list = SingleLinkedList.this;
        }

        @Override
        public T next() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.next;
            return pointer.item;
        }

        @Override
        public boolean remove() {
            unlink(pointer);
            return true;
        }

        @Override
        public T set(T item) {
            T previous = pointer.item;
            pointer.item = item;
            return previous;
        }

        @Override
        public void toFirst() {
            pointer = first;
        }

        @Override
        public boolean hasNext() {
            if (pointer == null) return first == null;
            return pointer.next != null;
        }


    }

}
