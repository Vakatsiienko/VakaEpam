package com.vaka.epam.homework.week4.task21;

/**
 * Created by Iaroslav on 11/21/2016.
 */
public abstract class FlyingOrWalkingCharacter extends Character {
    public FlyingOrWalkingCharacter() {
        super(new FlyingOrWalkingBehaviour());
    }
}
