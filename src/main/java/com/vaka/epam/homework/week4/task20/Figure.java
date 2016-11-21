package com.vaka.epam.homework.week4.task20;

import lombok.Getter;

import java.util.*;

/**
 * Created by Iaroslav on 11/19/2016.
 */
public abstract class Figure {
    private static Random random = new Random();
    private static final List<Figure> figures;
    private static Map<Class, Coordinates[]> startCoordinates;

    static {
        List<Figure> list = new ArrayList<>();
        list.add(new I());
        list.add(new J());
        list.add(new L());
        list.add(new O());
        list.add(new S());
        list.add(new T());
        list.add(new Z());
        figures = Collections.unmodifiableList(list);
    }

    static {
        startCoordinates = new HashMap<>();
        Coordinates[] iCoordinates = {new Coordinates(5, 10), new Coordinates(6, 10),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinates.put(I.class, iCoordinates);
        Coordinates[] jCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(8, 10), new Coordinates(8, 9)};
        startCoordinates.put(J.class, jCoordinates);
        Coordinates[] lCoordinates = {new Coordinates(6, 9), new Coordinates(6, 10),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinates.put(L.class, lCoordinates);
        Coordinates[] oCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(6, 9), new Coordinates(7, 9)};
        startCoordinates.put(O.class, oCoordinates);
        Coordinates[] sCoordinates = {new Coordinates(6, 9), new Coordinates(7, 9),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinates.put(S.class, sCoordinates);
        Coordinates[] tCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(7, 9), new Coordinates(8, 10)};
        startCoordinates.put(T.class, tCoordinates);
        Coordinates[] zCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(7, 9), new Coordinates(8, 9)};
        startCoordinates.put(Z.class, zCoordinates);
        startCoordinates = Collections.unmodifiableMap(startCoordinates);
    }

    @Getter
    protected Rotation rotation;

    @Getter
    protected Coordinates[] coordinates;

    @Getter
    private boolean superb;

    public static Figure createRandomFigure() throws CloneNotSupportedException {
        Figure figure = figures.get(random.nextInt(7));
        figure = figure.getInstance();
        figure.rotation = Rotation.D0;
        figure.coordinates = startCoordinates.get(figure.getClass()).clone();
        return figure;
    }

    public abstract Figure getInstance();

    public abstract void getSuperInstance();
}
