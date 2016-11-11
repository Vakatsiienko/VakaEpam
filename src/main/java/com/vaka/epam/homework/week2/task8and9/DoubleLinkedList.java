package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//9.	Реализовать двухсвязанный список.
// Реализация должна предусматривать наличие элемента header,
// в котором есть ссылка на первй и последний элемент списка(DoubleLinkedList).
public class DoubleLinkedList<T> extends SingleLinkedList<T> implements List<T> {

    private int size;

    private Node first;
    private Node last;

    @Override
    public T add(T t) {
        return super.add(t);
    }

    @Override
    public T addOnIndex(int index, T t) {
        return super.addOnIndex(index, t);
    }

    @Override
    public boolean remove(T o) {
        return super.remove(o);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public DoubleLinkLIter iterator() {
        return new DoubleLinkLIter();
    }

    @Override
    public boolean contains(T t) {
        return super.contains(t);
    }

    @Override
    public T get(int index) {
        return super.get(index);
    }

    @Override
    public boolean removeOnIndex(int index) {
        return super.removeOnIndex(index);
    }

    private class Node {
        private final T thisElement;
        private Node next;
        private Node previous;

        Node(T t) {
            thisElement = t;
        }

    }

    protected class DoubleLinkLIter extends SingleLinkLIter implements BothWayIterator<T> {

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


}
