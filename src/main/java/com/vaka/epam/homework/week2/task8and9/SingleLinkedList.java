package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements List<T> {

    private int size;
    private Node first;
    private Node last;
    private int modCount;

    private void unlink(Node removing) {
        modCount++;
        if (first == removing) {
            unlinkFirst();
            return;
        }
        Node previous = getPrevious(removing);
        if (removing == last)
            last = previous;
        previous.next = removing.next;
        size--;
    }

    private void unlinkFirst() {
        if (first == last) {
            first = null;
            last = null;
        } else first = first.next;
        size--;
    }

    private Node getPrevious(Node node) {
        for (Node previous = first; previous != null; previous = previous.next) {
            if (previous.next == node) {
                return previous;
            }
        }
        return null;
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

        private int modCount;

        private SingleLinkLIter() {
            list = SingleLinkedList.this;
            modCount = list.modCount;
        }

        @Override
        public T next() {
            if (first == null)
                throw new NullPointerException();
            else if (pointer == null) {
                pointer = list.first;
            } else pointer = pointer.next;
            checkModifications();
            return pointer.item;
        }

        @Override
        public T remove() {
            checkModifications();
            if (pointer == null)
                throw new NullPointerException();
            Node next = pointer.next;
            unlink(pointer);
            modCount++;
            T item = pointer.item;
            pointer = next;
            return item;
        }

        @Override
        public T set(T item) {
            checkModifications();
            if (pointer == null)
                throw new NullPointerException();
            T previous = pointer.item;
            pointer.item = item;
            return previous;
        }

        @Override
        public boolean hasNext() {
            checkModifications();
            if (pointer == null)
                return first != null;
            return pointer.next != null;
        }

        private void checkModifications(){
            if (modCount != list.modCount)
                throw new ModificationException();
        }

    }
}
