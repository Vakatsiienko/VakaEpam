package com.vaka.epam.homework.week4.task20FactoryMethod;

import lombok.Getter;

import java.util.*;

/**
 * Created by Iaroslav on 11/19/2016.
 */
//20. Паттерн Factory Method. Фигуры игры «тетрис». Реализовать процесс слу-
//        чайного выбора фигуры из конечного набора фигур. Предусмотреть появ-
//        ление супер-фигур с большим числом клеток, чем обычные.
public abstract class Figure {
    private static Random random = new Random();
    private static final List<Figure> figures;
    private static Map<Class, Coordinates[]> startCoordinatesByFigure;
    private static Map<Class, Coordinates[]> superStartCoordinatesByFigure;

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
        startCoordinatesByFigure = new HashMap<>();
        Coordinates[] iCoordinates = {new Coordinates(5, 10), new Coordinates(6, 10),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinatesByFigure.put(I.class, iCoordinates);
        Coordinates[] jCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(8, 10), new Coordinates(8, 9)};
        startCoordinatesByFigure.put(J.class, jCoordinates);
        Coordinates[] lCoordinates = {new Coordinates(6, 9), new Coordinates(6, 10),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinatesByFigure.put(L.class, lCoordinates);
        Coordinates[] oCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(6, 9), new Coordinates(7, 9)};
        startCoordinatesByFigure.put(O.class, oCoordinates);
        Coordinates[] sCoordinates = {new Coordinates(6, 9), new Coordinates(7, 9),
                new Coordinates(7, 10), new Coordinates(8, 10)};
        startCoordinatesByFigure.put(S.class, sCoordinates);
        Coordinates[] tCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(7, 9), new Coordinates(8, 10)};
        startCoordinatesByFigure.put(T.class, tCoordinates);
        Coordinates[] zCoordinates = {new Coordinates(6, 10), new Coordinates(7, 10),
                new Coordinates(7, 9), new Coordinates(8, 9)};
        startCoordinatesByFigure.put(Z.class, zCoordinates);
        startCoordinatesByFigure = Collections.unmodifiableMap(startCoordinatesByFigure);
    }

    @Getter
    protected Rotation rotation;

    @Getter
    protected Coordinates[] coordinates;

    @Getter
    private boolean superFigure;

    public static Figure createRandomFigure() throws CloneNotSupportedException {
        Figure figure = figures.get(random.nextInt(7));
        figure = figure.getFullInstance();
        return figure;
    }

    public abstract Figure getEmptyInstance();

    public Figure getFullInstance() {
        Figure instance = getEmptyInstance();
        instance.rotation = Rotation.D0;
        instance.coordinates = startCoordinatesByFigure.get(instance.getClass()).clone();
        return instance;
    }

    public Figure getSuperInstance(){
        Figure instance = getFullInstance();
        instance.coordinates = superStartCoordinatesByFigure.get(instance.getClass()).clone();
        return instance;
    };
}
