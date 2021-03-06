package com.vaka.epam.homework.accomplished.week2.task7.starsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iaroslav on 11/9/2016.
 */
// Создать объект класса  Звездная система, используя классы Планета, Звезда, Луна.
// Методы: вывести  количество планет в звездной системе,
// название звезды, добавление планеты в систему.
@Getter
@AllArgsConstructor
public class StarSystem {
    private final String uid;
    private Star[] stars;
    private List<Planet> planets;

    public StarSystem(String uid, Star star) {
        this.uid = uid;
        stars = new Star[1];
        stars[0] = star;
        planets = new ArrayList();
    }

    public int planetsCount() {
        return planets.size();
    }

    /**
     * @return name of all stars in this StarSystem separated by ", "
     */
    public String nameOfStars() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(stars).forEach(star -> builder.append(star.getUid()).append(", "));
        builder.setLength(builder.length() - 2);
        return builder.toString();
    }

}
