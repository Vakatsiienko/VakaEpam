package com.vaka.epam.homework.week4.task16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Iaroslav on 11/20/2016.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Field {

    private List<Ship> ships;
    private List<Coordinate> intactCoordinates;
    private List<Coordinate> shootedCoordinates;    //TODO remove

    {
        intactCoordinates = new ArrayList<>(100);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                intactCoordinates.add(new Coordinate(i, j));
            }
        }
        shootedCoordinates = new ArrayList<>(100);
    }

    public List<Coordinate> getShipsCoordinates(){
        List<Coordinate> coordinates = new ArrayList<>(22);
        for (Ship ship : ships) {
            Collections.addAll(coordinates, ship.getCoordinates());
        }
        return coordinates;
    }

    public boolean checkCoordinate(Coordinate coordinate) {
        if (shootedCoordinates.contains(coordinate))
            return false;
        if (intactCoordinates.contains(coordinate))
            return true;
        return false;
    }

    public boolean shoot(Coordinate coordinate) {
        if (checkCoordinate(coordinate)) {
            intactCoordinates.remove(coordinate);
            shootedCoordinates.add(coordinate);
            for (Ship ship : ships) {
                for (Coordinate c : ship.getCoordinates()) {
                    if (c.equals(coordinate)) {
                        c.setShooted(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
