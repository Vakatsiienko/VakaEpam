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
public class Triangle extends Shape {

    private double h;

    private double c;

    @Override
    public double area() {
        return Precision.round(h * c, 2);
    }
}
