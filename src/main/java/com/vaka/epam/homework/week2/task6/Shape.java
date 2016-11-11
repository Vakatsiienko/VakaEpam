package com.vaka.epam.homework.week2.task6;

import org.apache.commons.math3.util.Precision;

/**
 * Created by Iaroslav on 11/6/2016.
 */
//6. Допустимыми фигурами являются круг Ring, треугольник Triangle,
//      параллелограмм Parallelogram и трапеция Trapezium.
//      В классе допустимых фигур Shape определить операцию сложения,
//      если суммой фигур служит сумма их площадей.
//
public abstract class Shape {

    public abstract double area();

    public double sum(Shape shape) {
        return Precision.round(this.area() + shape.area(), 2);
    }


}
