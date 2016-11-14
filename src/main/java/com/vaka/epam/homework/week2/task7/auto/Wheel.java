package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;

import java.util.UUID;

/**
 * Created by Iaroslav on 11/9/2016.
 */
@Getter
public class Wheel {

    private String serialUID = UUID.randomUUID().toString();

    private String tires;

    private String rims;

    private Status status;

    public Wheel(String tires, String rims, Status status) {
        this.tires = tires;
        this.rims = rims;
        this.status = status;
    }
}
