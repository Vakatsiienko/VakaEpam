package com.vaka.epam.homework.week2.task7.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Iaroslav on 11/11/2016.
 */
public class AutoFabric {

    public static Auto createTeslaModel3(){
        Engine engine = new ACEngine(UUID.randomUUID().toString(), 350, 16000);
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel("Some Tires", "Some Rims", 16.0f, 0));
        wheels.add(new Wheel("Some Tires", "Some Rims", 16.0f, 0));
        wheels.add(new Wheel("Some Tires", "Some Rims", 16.0f, 0));
        wheels.add(new Wheel("Some Tires", "Some Rims", 16.0f, 0));
        return new Auto("Tesla", "Model3", UUID.randomUUID().toString(), engine, wheels, Drive.AWD);
    }
}
