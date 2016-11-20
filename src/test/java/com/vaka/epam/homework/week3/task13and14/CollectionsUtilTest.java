package com.vaka.epam.homework.week3.task13and14;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Iaroslav on 11/16/2016.
 */
public class CollectionsUtilTest {

    @Test
    public void testUnionAndSortWithComparator() throws Exception {
        List<Integer> result = CollectionsUtil.unionAndSort(createList(), createList(), (v1, v2) -> v1.compareTo(v2) * -1, ArrayList::new);
        for (int i = 0; i < result.size(); i++) {
            if (i + 1 != result.size())
                Assert.assertTrue(
                        String.format("%s element = %s, next element = %s", i, result.get(i), result.get(i + 1)),
                        result.get(i) >= result.get(i + 1));

        }
    }

    @Test
    public void testQSort() throws Exception {
        List<Integer> result = CollectionsUtil.qSort(createList(), Integer::compareTo);
        for (int i = 0; i < result.size(); i++) {
            if (i + 1 != result.size())
                Assert.assertTrue(
                        String.format("%s element = %s, next element = %s", i, result.get(i), result.get(i + 1)),
                        result.get(i) <= result.get(i + 1));

        }
    }

    public List<Integer> createList() {
        List<Integer> list = new ArrayList<>(10000);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}
