package com.vaka.epam.homework.week2.task7.auto;

import java.util.List;

/**
 * Created by Iaroslav on 11/11/2016.
 */
class Auto {

    private String brand;

    private String model;

    private String serialID;

    private Engine engine;

    private List<Wheel> wheels;

    private Drive drive;

    Auto(String brand, String model, String serialID, Engine engine, List<Wheel> wheels, Drive drive) {
        this.brand = brand;
        this.model = model;
        this.serialID = serialID;
        this.engine = engine;
        this.wheels = wheels;
        this.drive = drive;
    }
}
