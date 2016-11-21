package com.vaka.epam.homework.week4.task16;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Iaroslav on 11/20/2016.
 */

@Getter
@Setter
@NoArgsConstructor
public class Coordinate {

    private int x;

    private int y;

    private boolean shooted;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
