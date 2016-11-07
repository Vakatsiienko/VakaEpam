package com.vaka.epam.homework.week2.task8;

/**
 * Created by Iaroslav on 11/6/2016.
 */
public class SingleLinkedList<T> {

    private int size;

    private Node<T> first;
    private Node<T> last;

    public T add(T t) {
        if (size == 0) {
            first = new Node<>(t);
            last = first;
        }
        Node<T> node = new Node<>(t);
        last.next = node;
        last = node;
        size++;
        return t;
    }


    public boolean remove(Object o) {
        if (first.thisElement.equals(o)) {
            first = first.next;
            size--;
            return true;
        }
        for (Node<T> x = first; x != null; x = x.next) {
            if (o.equals(x.next)) {
                Node<T> removing = x.next;
                x.next = removing.next;
                size--;
                return true;
            }
        }
        size--;
        return false;
    }

    public Iterator iterator(){
        return new Iterator();
    }


    private class Node<T> {
        private final T thisElement;
        private Node<T> next;

        Node(T t) {
            thisElement = t;
        }

    }

    private class Iterator {

        private SingleLinkedList<T> list;

        private Node<T> pointer;

        private int index;

        private Iterator() {
            this.list = SingleLinkedList.this;
            pointer = list.first;
        }

        public T next() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.next;
            T result = pointer.thisElement;
            index++;
            return result;
//            T result = pointer.thisElement;
//            pointer = pointer.next;
//            index++;
//            return result;
        }

        public boolean hasNext() {
            return index < list.size;
        }


    }

}
