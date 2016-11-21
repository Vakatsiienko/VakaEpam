package com.vaka.epam.homework.accomplished.week2.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

/**
 * Created by Iaroslav on 11/6/2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class Parallelogram extends Shape {
    private double a;
    private double b;

    @Override
    public double area() {
        return Precision.round(a * b, 2);
    }
}
