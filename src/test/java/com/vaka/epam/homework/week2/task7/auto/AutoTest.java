package com.vaka.epam.homework.week2.task7.auto;

import org.apache.commons.math3.util.Precision;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iaroslav on 11/12/2016.
 */
public class AutoTest {
    @Test
    public void testPrintName() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        auto.printFullName();
        System.out.flush();
        System.setOut(old);

        Assert.assertEquals("Bugatty Veyron 16.4\n", baos.toString());
    }

    @Test(expected = DrivingException.class)
    public void testChangeWheel() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Wheel newWheel = new Wheel("Bugatti tire", "Some rim", Status.OK);
        Wheel old = auto.getWheels().get(WheelPosition.BL);
        Assert.assertEquals(old, auto.changeWheel(newWheel, WheelPosition.BL));

        newWheel = new Wheel("Bugatti tire", "Some rim", Status.OK);
        old = auto.getWheels().get(WheelPosition.FR);
        Assert.assertEquals(old, auto.changeWheel(newWheel, WheelPosition.FR));
        Assert.assertEquals(newWheel, auto.getWheels().get(WheelPosition.FR));

        auto.refuelFull();
        auto.drive();
        //expecting DrivingException
        auto.changeWheel(old, WheelPosition.BL);
    }

    @Test
    public void testCheckWheels() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Assert.assertTrue(auto.checkWheels());
        Wheel broken = new Wheel("Old Tire", "Old rim", Status.BROKEN);
        auto.changeWheel(broken, WheelPosition.BL);
        Assert.assertFalse(auto.checkWheels());
    }

    @Test
    public void testReadyToDrive() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Assert.assertFalse(auto.readyToDrive());
        auto.refuelFull();
        Assert.assertTrue(auto.readyToDrive());

        auto.getEngine().setStatus(Status.BROKEN);
        Assert.assertFalse(auto.readyToDrive());
        auto.getEngine().setStatus(Status.OK);
        Assert.assertTrue(auto.readyToDrive());

        auto.getWheels().remove(WheelPosition.BL);
        Assert.assertFalse(auto.readyToDrive());
        Wheel newWheel = new Wheel("Bugatti tire", "Some rim", Status.OK);
        auto.getWheels().put(WheelPosition.BL, newWheel);
        Assert.assertTrue(auto.readyToDrive());

        Wheel broken = new Wheel("Old Tire", "Old rim", Status.BROKEN);
        auto.changeWheel(broken, WheelPosition.BL);
        Assert.assertFalse(auto.readyToDrive());
    }

    @Rule
    public ExpectedException negativeRefuelExc = ExpectedException.none();

    @Test
    public void testRefuel() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        double currentFuel = auto.getFuel();
        auto.refuel(10.4d);
        Assert.assertEquals(auto.getFuel(), Precision.round(currentFuel + 10.4d, 2), 0d);

        negativeRefuelExc.expect(RefuelException.class);
        negativeRefuelExc.expectMessage("Fuel amount cannot be lower or equal 0, your: -42.21");
        auto.refuel(-42.21d);

        try {
            auto.refuelFull();
            auto.refuel(0.01);
            Assert.fail("there must be over fuel exception to be thrown");
        } catch (RefuelException expected) {

        }

    }

    @Test
    public void testRefuelFull() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Assert.assertNotEquals(auto.getFuel(), auto.getFuelCapacity());
        auto.refuelFull();
        Assert.assertEquals(auto.getFuel(), auto.getFuelCapacity(), 0d);
    }

    @Test
    public void testDrive() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Assert.assertFalse(auto.isDriving());
        auto.refuelFull();
        auto.drive();

        Assert.assertTrue(auto.isDriving());
    }

    @Test
    public void testStop() throws Exception {
        Auto auto = buildBugattiVeyron16point4();
        Assert.assertFalse(auto.isDriving());
        auto.refuelFull();
        auto.drive();
        Assert.assertTrue(auto.isDriving());
        auto.stop();

        Assert.assertFalse(auto.isDriving());
    }

    public static Auto buildBugattiVeyron16point4() {
        Engine engine = new Engine(1001, 6500, Status.OK);
        Map<WheelPosition, Wheel> wheels = new HashMap<>();
        String tireName = "Veyron Tire";
        String rimName = "Veyron Rim";
        wheels.put(WheelPosition.BL, new Wheel(tireName, rimName, Status.OK));
        wheels.put(WheelPosition.BR, new Wheel(tireName, rimName, Status.OK));
        wheels.put(WheelPosition.FL, new Wheel(tireName, rimName, Status.OK));
        wheels.put(WheelPosition.FR, new Wheel(tireName, rimName, Status.OK));
        return Auto.createCar(engine, wheels, "Bugatty", "Veyron 16.4", 100d);
    }
}
