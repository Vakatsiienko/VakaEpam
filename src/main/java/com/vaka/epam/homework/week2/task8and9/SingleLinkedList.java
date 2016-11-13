package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
public class SingleLinkedList<T> implements List<T> {

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
            last = node;
        }
        size++;
    }


    @Override
    public void addOnIndex(int index, T t) {
        Node element = first;
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException(
                    String.format("Index must be lower or equal size, size - %s, index - %s", size, index));
        else if (size == index) {
            add(t);
            return;
        } else for (int i = 0; i < index - 1; i++) {
            element = element.next;
        }
        Node previous = element;
        Node next = element.next;
        Node thisElement = new Node(t);
        previous.next = thisElement;
        thisElement.next = next;
    }

    @Override
    public boolean remove(T o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    size--;
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node element) {
        Node previous = first;
        if (first == element) {
            first = first.next;
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
    public SingleLinkLIter iterator() {
        return new SingleLinkLIter();
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public void clear() {
        while (first != null)
            unlink(first);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.format("Size: %s, index^ %s", size, index));
    }

    @Override
    public void removeOnIndex(int index) {
        checkIndex(index);
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        unlink(x);
    }

    private class Node {
        private final T item;
        private Node next;


        private Node(T t) {
            item = t;
        }

    }

    protected class SingleLinkLIter implements SingleWayIterator<T> {

        private SingleLinkedList<T> list;

        private Node pointer;

        private int index;

        protected SingleLinkLIter() {
            this.list = SingleLinkedList.this;
            pointer = list.first;
        }

        @Override
        public T next() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.next;
            T result = pointer.item;
            index++;
            return result;
        }

        @Override
        public boolean hasNext() {
            return index < list.size;
        }


    }

}
