package com.vaka.epam.homework.week2.task7.starsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * Created by Iaroslav on 11/13/2016.
 */
@Getter
@AllArgsConstructor
public class Planet {
    private final String uid;
    private Optional<Map<String, Satellite>> satellites;

    public void addSatellite(Satellite satellite) {
        if (!satellites.isPresent())
            satellites = Optional.of(new HashMap<>());
        satellites.get().put(satellite.getUid(), satellite);
    }

}
