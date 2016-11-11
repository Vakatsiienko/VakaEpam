package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;

/**
 * Created by Iaroslav on 11/11/2016.
 */
@Getter
class ICEEngine extends Engine {

    private int cylinders;


    ICEEngine(String serialNumber, int cylinders, int horsepower, int rpm) {
        super(serialNumber, horsepower, rpm);
        this.cylinders = cylinders;
    }
}
