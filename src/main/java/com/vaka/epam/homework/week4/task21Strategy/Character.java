package com.vaka.epam.homework.week4.task21Strategy;

import lombok.Getter;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@Getter
public abstract class Character {

    private MoveBehaviour moveBehaviour;

    private MoveBehaviour originalMoveBehaviour;

    public Character(MoveBehaviour moveBehaviour) {
        originalMoveBehaviour = moveBehaviour;
        this.moveBehaviour = moveBehaviour;
    }

    public void move() {
        moveBehaviour.move();
    }

    public void setMoveBehaviourByMagic(MoveBehaviour moveBehaviour) {
        this.moveBehaviour = moveBehaviour;
    }

    public void removeMoveBehaviourByMagic() {
        moveBehaviour = originalMoveBehaviour;
    }




}
