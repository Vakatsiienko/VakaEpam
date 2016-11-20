package com.vaka.epam.homework.week3.task13and14;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Iaroslav on 11/16/2016.
 */
public final class CollectionsUtil {
    private CollectionsUtil() {
    }


    public static <T, E extends Collection<T>, C extends Collection<T>> C unionAndSort
            (E first, E second, Comparator<? super T> comparator, Supplier<C> collectionFactory) {
        return Stream.concat(first.stream(), second.stream())
                .sorted(comparator)
                .collect(Collectors.toCollection(collectionFactory));
    }

    // Используя generics написать сортировку списка, в котором могут храниться
// элементы некоторого класса или его наследников методом Quicksort,
// сравнение элементов осуществлять с помощью Comparator
    public static <T> List<T> qSort(List<T> list, Comparator<? super T> comparator) {
        int n = list.size();
        int i = 0;
        int j = n - 1;
        T pivot = getPivot(list, comparator);
        while (i <= j) {
            while (comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }
            while (comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }
        if (j > 0) {
            qSort(list.subList(0, j + 1), comparator);
        }
        if (i < n) {
            qSort(list.subList(i, n), comparator);
        }
        return list;
    }

    private static <T> T getPivot(List<T> list, Comparator<? super T> comparator) {
        Random random = new Random();
        int index1 = random.nextInt(list.size());
        int index2 = random.nextInt(list.size());
        int index3 = random.nextInt(list.size());
        T elem1 = list.get(index1);
        T elem2 = list.get(index2);
        T elem3 = list.get(index3);
        if (comparator.compare(elem1, elem2) >= 0) {
            if (comparator.compare(elem1, elem3) >= 0) {
                if (comparator.compare(elem3, elem2) >= 0)
                    return list.get(index3);
                return list.get(index2);
            }
            return list.get(index1);
        } else if (comparator.compare(elem1, elem3) >= 0)
            return list.get(index1);
        return list.get(index3);
    }
}
