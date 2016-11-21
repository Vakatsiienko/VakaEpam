package com.vaka.epam.homework.week4.task21Strategy;

/**
 * Created by Iaroslav on 11/19/2016.
 */
public abstract class WalkingCharacter extends Character {
    public WalkingCharacter() {
        super(new WalkingBehaviour());
    }
}
