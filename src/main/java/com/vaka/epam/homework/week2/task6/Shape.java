package com.vaka.epam.homework.week2.task6;

import org.apache.commons.math3.util.Precision;

import java.util.List;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//6. Допустимыми фигурами являются круг Ring, треугольник Triangle,
//      параллелограмм Parallelogram и трапеция Trapezium.
//      В классе допустимых фигур Shape определить операцию сложения,
//      если суммой фигур служит сумма их площадей.
//
@FunctionalInterface
public interface Shape {

    double area();

    default double additionShape(List<Shape> list) {
        return Precision.round(list.stream().mapToDouble(Shape::area).sum(), 2);
    }


}
