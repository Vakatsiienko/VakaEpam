package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//9.	Реализовать двухсвязанный список.
// Реализация должна предусматривать наличие элемента header,
// в котором есть ссылка на первй и последний элемент списка(DoubleLinkedList).
public class DoubleLinkedList<T> implements List<T> {

    private int size;

    private Node first;
    private Node last;

    @Override
    public void add(T t) {
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
    }

    @Override
    public void addOnIndex(int index, T t) {
        Node element;
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException(
                    String.format("Index must be lower or equal size, size - %s, index - %s", size, index));
        else if (size == index) {
            add(t);
            return;
        } else if (size / 2 > index) {
            element = first;
            for (int i = 0; i < index - 1; i++) {
                element = element.next;
            }
        } else {
            element = last;
            for (int i = 0, y = size - index; i < y; i++) {
                element = element.previous;
            }
        }
        insertAfter(element, new Node(t));
        size++;
    }

    private void insertAfter(Node after, Node insertion) {
        Node node = after.next;
        after.next = insertion;
        insertion.previous = after;
        insertion.next = node;
    }

    @Override
    public boolean remove(T o) {
        for (Node x = first; x != null; x = x.next) {
            if (x.item.equals(o)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    private void unlink(Node element) {
        if (first == element) {
            first = first.next;
            if (first == last) {
                first = null;
                last = null;
            }
            size--;
            return;
        }
        if (last == element) {
            last = last.previous;
            size--;
            return;
        }
        element.previous.next = element.next;
        element.next = element.previous;
        size--;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public DoubleLinkLIter iterator() {
        return new DoubleLinkLIter();
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public T get(int index) {
        return getNodeOnIndex(index).item;
    }

    private Node getNodeOnIndex(int index) {
        checkIndex(index);
        Node element;
        if (size / 2 > index) {
            element = first;
            for (int i = 0; i < index - 1; i++) {
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

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.format("Size: %s, index^ %s", size, index));
    }

    @Override
    public void removeOnIndex(int index) {
        unlink(getNodeOnIndex(index));
    }

    @Override
    public void clear() {
        while (first != null)
            unlink(first);
    }

    private class Node {
        private final T item;
        private Node next;
        private Node previous;

        private Node(T t) {
            item = t;
        }

    }

    protected class DoubleLinkLIter implements BothWayIterator<T> {

        private DoubleLinkedList<T> list;

        private Node pointer;

        private int index;

        private DoubleLinkLIter() {
            this.list = DoubleLinkedList.this;
        }

        public T next() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.next;
            T result = pointer.item;
            index++;
            return result;
        }

        public T previous() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.previous;
            T result = pointer.item;
            index--;
            return result;
        }

        public boolean hasNext() {
            return index < list.size;
        }


    }


}
