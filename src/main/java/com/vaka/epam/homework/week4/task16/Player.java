package com.vaka.epam.homework.week4.task16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Iaroslav on 11/20/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player {
    private String name;
    private Field playerField;
    private Field enemyField;

    public boolean turn(Coordinate coordinate) {
        return enemyField.shoot(takeCoordinates());
    }

    public abstract Coordinate takeCoordinates();
}
