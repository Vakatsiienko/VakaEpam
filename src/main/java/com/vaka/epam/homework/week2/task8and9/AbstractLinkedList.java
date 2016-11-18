package com.vaka.epam.homework.week2.task8and9;

/**
 * Created by iaroslav on 15.11.16.
 */
public abstract class AbstractLinkedList<T> implements List<T> {


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public int indexOf(T t) {
        if (size() == 0)
            return -1;
        int index = 0;
        LLIterator iterator = iterator();
        if (t == null) {
            do {
                if (iterator.next() == null)
                    return index;
                index++;
            } while (iterator.hasNext());
        } else {
            do {
                if (t.equals(iterator.next()))
                    return index;
                index++;
            } while (iterator.hasNext());
        }
        return -1;
    }

    @Override
    public boolean remove(T removing) {
        if (size() == 0)
            return false;
        LLIterator iterator = iterator();
        Object current;
        if (removing == null) {
            do {
                current = iterator.next();
                if (current == null) {
                    iterator.remove();
                    return true;
                }
            } while (iterator.hasNext());

        } else {
            do {
                current = iterator.next();
                if (removing.equals(current)) {
                    iterator.remove();
                    return true;
                }
            } while (iterator.hasNext());
        }
        return false;

    }

    @Override
    public void clear() {
        LLIterator iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();

        }
    }

    protected void checkIndexForGet(int index) {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException(String.format("Max index: %s, given index: %s", size() - 1, index));
    }

    protected void checkIndexForAdd(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException(String.format("Max index: %s, given index: %s", size(), index));
    }
}
