package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by Iaroslav on 11/11/2016.
 */
@Getter
public class Engine {

    private String serialUID = UUID.randomUUID().toString();

    private int horsepower;

    private int rpm;

    private @Setter Status status;

    public Engine(int horsepower, int rpm, Status status) {
        this.horsepower = horsepower;
        this.rpm = rpm;
        this.status = status;
    }
}
