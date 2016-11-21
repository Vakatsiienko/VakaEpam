package com.vaka.epam.homework.accomplished.week2.task7.auto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by Iaroslav on 11/9/2016.
 */
@Getter
public class Engine {

    private String serialUID = UUID.randomUUID().toString();

    private int horsepower;

    private int rpm;

    @Setter
    private Status status;

    public Engine(int horsepower, int rpm, Status status) {
        this.horsepower = horsepower;
        this.rpm = rpm;
        this.status = status;
    }
}
