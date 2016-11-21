package com.vaka.epam.homework.week4.task20FactoryMethod;

/**
 * Created by Iaroslav on 11/19/2016.
 */
public class Z extends Figure {
    @Override
    public Figure getEmptyInstance() {
        return new Z();
    }

    @Override
    public void getSuperInstance() {
        
    }
}
