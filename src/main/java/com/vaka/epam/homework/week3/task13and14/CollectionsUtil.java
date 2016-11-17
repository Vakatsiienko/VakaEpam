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

    public static <T extends Comparable<? super T>, E extends Collection<T>, C extends Collection<T>> C unionAndSort
            (E first, E second, Supplier<C> collectionFactory) {
        return Stream.concat(first.stream(), second.stream())
                .sorted()
                .collect(Collectors.toCollection(collectionFactory));
    }

    public static <T, E extends Collection<T>, C extends Collection<T>> C unionAndSort
            (E first, E second, Comparator<? super T> comparator, Supplier<C> collectionFactory) {
        return Stream.concat(first.stream(), second.stream())
                .sorted(comparator)
                .collect(Collectors.toCollection(collectionFactory));
    }


//    public static <T> Collection<T> qSort(List<T> array, Comparator<T> comparator) {
//        int n = array.size();
//        int i = 0;
//        int j = n-1;
//        int x = array.get(rand.nextInt(n));
//        while (i <= j) {
//            while (array.get(i) < x) {
//                i++;
//            }
//            while (array.get(j) > x) {
//                j--;
//            }
//            if (i <= j) {
//                Collections.swap(array,i,j);
//                i++;
//                j--;
//            }
//        }
//        if (j>0){
//            qSort(array.subList(0, j + 1));
//        }
//        if (i<n){
//            qSort(array.subList(i,n));
//        }
//    }
}
