package com.vaka.epam.homework.week2.task6;

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
public class Ring extends Shape {
    private double r;
    @Override
    public double area() {
        return Precision.round(Math.PI * r, 2);
    }
}
