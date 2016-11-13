package com.vaka.epam.homework.week2.task7.starsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * Created by Iaroslav on 11/13/2016.
 */
// Создать объект класса  Звездная система, используя классы Планета, Звезда, Луна.
// Методы: вывести  количество планет в звездной системе,
// название звезды, добавление планеты в систему.
@Getter
@AllArgsConstructor
public class StarSystem {
    private final String uid;
    private Star[] stars;
    private Optional<Map<String, Planet>> planets;

    public StarSystem(String uid, Star star) {
        this.uid = uid;
        stars = new Star[1];
        stars[0] = star;
        planets = Optional.empty();
    }

    public int planetsCount() {
        if (planets.isPresent())
            return planets.get().size();
        else return 0;
    }

    public void addPlanet(Planet planet) {
        if (!planets.isPresent())
            planets = Optional.of(new HashMap<>());
        planets.get().put(planet.getUid(), planet);
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
