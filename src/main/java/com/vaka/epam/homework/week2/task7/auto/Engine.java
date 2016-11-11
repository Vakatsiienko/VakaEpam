package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;

/**
 * Created by Iaroslav on 11/11/2016.
 */
@Getter
public abstract class Engine {

    private String serialNumber;

    private int horsepower;

    private int rpm;

    public Engine(String serialNumber, int horsepower, int rpm) {
        this.serialNumber = serialNumber;
        this.horsepower = horsepower;
        this.rpm = rpm;
    }
}
