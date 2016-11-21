package com.vaka.epam.homework.week4.task21;

import lombok.Getter;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@Getter
public abstract class Character {

    private Coordinates location;

    private MoveBehaviour moveBehaviour;

    public Character(MoveBehaviour moveBehaviour) {
        this.moveBehaviour = moveBehaviour;
    }

    public void move(Coordinates coordinates) {
        moveBehaviour.move(coordinates);
    }

    public void flyByMagic(/*Coordinates coordinates*/) {
//        MoveBehaviour oldBehaviour = moveBehaviour;
        moveBehaviour = new FlyingBehaviour();
//        move(coordinates);
//        moveBehaviour = oldBehaviour;
    }


}
