package com.vaka.epam.homework.week4.task20FactoryMethod;

/**
 * Created by Iaroslav on 11/19/2016.
 */
public class T extends Figure {
    @Override
    public Figure getEmptyInstance() {
        return new T();
    }

    @Override
    public void getSuperInstance() {

    }
}
