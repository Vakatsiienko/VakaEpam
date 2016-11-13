package com.vaka.epam.homework.week2.task7.starsystem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by Iaroslav on 11/13/2016.
 */
public class StarSystemTest {
    @Test
    public void testPlanetsCount() throws Exception {
        StarSystem solarSystem = createSystem();
        Assert.assertEquals(2, solarSystem.planetsCount());

        solarSystem.addPlanet(new Planet("Venus", Optional.empty()));
        Assert.assertEquals(3, solarSystem.planetsCount());

    }

    @Test
    public void testAddPlanet() throws Exception {
        StarSystem solarSystem = createSystem();

        Assert.assertEquals(2, solarSystem.planetsCount());
        solarSystem.addPlanet(new Planet("Venus", Optional.empty()));
        Assert.assertEquals(3, solarSystem.planetsCount());
    }

    @Test
    public void testNameOfStars() throws Exception {
        StarSystem system = new StarSystem("Solar System", new Star("Sun"));
        Assert.assertEquals("Sun", system.nameOfStars());

        Star[] stars = {new Star("Alpha Centauri A"),
                new Star("Alpha Centauri B"),
                new Star("Proxima Centauri")};
        StarSystem centauri = new StarSystem("Alpha Centauri", stars, Optional.empty());
        Assert.assertEquals(centauri.nameOfStars(),
                "Alpha Centauri A, Alpha Centauri B, Proxima Centauri");
    }

    public StarSystem createSystem(){
        StarSystem solarSystem = new StarSystem("Solar System", new Star("Sun"));
        solarSystem.addPlanet(new Planet("Mercury", Optional.empty()));

        Planet earth = new Planet("Earth", Optional.empty());
        earth.addSatellite(new Satellite("Moon"));
        solarSystem.addPlanet(earth);
        return solarSystem;
    }
}
