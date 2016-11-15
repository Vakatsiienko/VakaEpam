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
        int index = 0;
        Iterator<T> iterator = iterator();
        if (t == null) {
            for (T item = iterator.next(); iterator.hasNext(); item = iterator.next()) {
                if (item == null)
                    return index;
                index++;
            }
        } else {
            for (T item = iterator.next(); iterator.hasNext(); item = iterator.next()) {
                if (t.equals(item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(T removing) {
        if (size() == 0) return false;
        Iterator iterator = iterator();
        Object current;
        if (removing == null) {
            do {
                current = iterator.next();
                if (current == null || current.equals(998)) {
                    System.out.println("null");
                }
                if (current == null) {
                    iterator.remove();
                    return true;
                }
            } while (iterator.hasNext());

        } else {
            do{
                current = iterator.next();
                if (removing.equals(current)) {
                    iterator.remove();
                    return true;
                }
            }while (iterator.hasNext());
        }
        return false;

    }

    @Override
    public void clear() {
        Iterator iterator = iterator();
        while (iterator.hasNext())
            iterator.remove();
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
