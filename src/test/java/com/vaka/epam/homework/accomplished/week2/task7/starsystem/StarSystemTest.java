package com.vaka.epam.homework.accomplished.week2.task7.starsystem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Iaroslav on 11/9/2016.
 */
public class StarSystemTest {
    @Test
    public void testPlanetsCount() throws Exception {
        StarSystem solarSystem = createSystem();
        Assert.assertEquals(2, solarSystem.planetsCount());

        solarSystem.getPlanets().add(new Planet("Venus", new ArrayList<>()));
        Assert.assertEquals(3, solarSystem.planetsCount());

    }

    @Test
    public void testAddPlanet() throws Exception {
        StarSystem solarSystem = createSystem();

        Assert.assertEquals(2, solarSystem.planetsCount());
        solarSystem.getPlanets().add(new Planet("Venus", new ArrayList<>()));
        Assert.assertEquals(3, solarSystem.planetsCount());
    }

    @Test
    public void testNameOfStars() throws Exception {
        StarSystem system = new StarSystem("Solar System", new Star("Sun"));
        Assert.assertEquals("Sun", system.nameOfStars());

        Star[] stars = {new Star("Alpha Centauri A"),
                new Star("Alpha Centauri B"),
                new Star("Proxima Centauri")};
        StarSystem centauri = new StarSystem("Alpha Centauri", stars, new ArrayList<>());
        Assert.assertEquals(centauri.nameOfStars(),
                "Alpha Centauri A, Alpha Centauri B, Proxima Centauri");
    }

    public StarSystem createSystem() {
        StarSystem solarSystem = new StarSystem("Solar System", new Star("Sun"));
        solarSystem.getPlanets().add(new Planet("Mercury", new ArrayList<Satellite>()));

        Planet earth = new Planet("Earth", new ArrayList<>());
        earth.getSatellites().add(new Satellite("Moon"));
        solarSystem.getPlanets().add(earth);
        return solarSystem;
    }
}
