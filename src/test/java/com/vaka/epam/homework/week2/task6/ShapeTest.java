package com.vaka.epam.homework.week2.task6;

import org.apache.commons.math3.util.Precision;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iaroslav on 11/17/2016.
 */
public class ShapeTest {
    @Test
    public void testSum() throws Exception {
        List<Shape> list = new ArrayList<>();
        list.add(new Parallelogram(12.4d, 321.1d));
        list.add(new Ring(5432.31d));
        list.add(new Trapezium(12.55d, 42.13, 12.33));
        list.add(new Triangle(1.4d, 31.5d));
        double expected = Precision.round(list.stream()
                .mapToDouble(Shape::area)
                .sum(), 2);
        double actual = list.get(0).sum(list.get(1));
        actual += list.get(2).sum(list.get(3));
        Assert.assertEquals(expected, Precision.round(actual, 2), 2);
    }
}
