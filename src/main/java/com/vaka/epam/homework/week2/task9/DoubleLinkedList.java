package com.vaka.epam.homework.week2.task9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//9.	Реализовать двухсвязанный список.
// Реализация должна предусматривать наличие элемента header,
// в котором есть ссылка на первй и последний элемент списка(DoubleLinkedList).
public class DoubleLinkedList<T> {

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
        node.previous = last;
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
        return false;
    }
    public Iterator iterator(){
        return new Iterator();
    }


    private class Node<T> {
        private final T thisElement;
        private Node<T> next;
        private Node<T> previous;

        Node(T t) {
            thisElement = t;
        }

    }

    public class Iterator {

        private DoubleLinkedList<T> list;

        private Node<T> pointer;

        private int index;

        private Iterator() {
            this.list = DoubleLinkedList.this;
        }

        public T next() {
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.next;
            T result = pointer.thisElement;
            index++;
            return result;
        }

        public T previous(){
            if (pointer == null)
                pointer = list.first;
            else pointer = pointer.previous;
            T result = pointer.thisElement;
            index--;
            return result;
        }

        public boolean hasNext() {
            return index < list.size;
        }


    }

    public static void main(String[] args) {
        System.out.println(012);
    }

}
