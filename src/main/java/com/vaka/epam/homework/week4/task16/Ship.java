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
public class Ship {

    private Coordinate[] coordinates;

    private int decks;//make size of coordinates

    private boolean sunken;

    public Ship(int decks) {
        this.decks = decks;
    }


}
