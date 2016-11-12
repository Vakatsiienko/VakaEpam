package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;
import org.apache.commons.math3.util.Precision;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Iaroslav on 11/11/2016.
 */
// Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
// Методы: ехать, заправляться, менять колесо, вывести на консоль марку
// автомобиля.

@Getter
public class Auto {

    private String serialUID = UUID.randomUUID().toString();

    private String brand;

    private String model;

    private Engine engine;

    private Map<WheelPosition, Wheel> wheels;

    private Drive drive;

    private double fuel;

    private double fuelCapacity;

    private boolean driving;

    private boolean refueling;

    private boolean changingWheel;

    private int wheelsCount;

    private Auto() {

    }

    public boolean drive() {
        return readyToDrive() && (driving = true);
    }

    public boolean stop() {
        return !(driving = false);
    }

    public void refuelFull() {
        double incoming = Precision.round(fuelCapacity - this.fuel, 2);
        refuel(incoming);
    }

    public void refuel(double incoming) {
        try {
            refueling = true;
            if (incoming <= 0)
                throw new RefuelException(String.format("Fuel amount cannot be lower or equal 0, your: %s", incoming));
            if (driving)
                throw new DrivingException("You need to stop for refuel");
            double totalFuel = Precision.round(this.fuel + incoming, 2);
            if (fuelCapacity >= totalFuel) {
                this.fuel = Precision.round(this.fuel + incoming, 2);
            } else
                throw new RefuelException(String.format("Incoming fuel is to much, fuel capacity: %s, current: %s, incoming: %s", fuelCapacity, fuel, incoming));
        } finally {
            refueling = false;
        }
    }

    public boolean readyToDrive() {
        if (fuel != 0.0d)
            if (engine.getStatus() == Status.OK)
                if (checkWheels())
                    return true;
        return false;
    }

    public boolean checkWheels() {
        return wheels.values().stream().filter(wheel ->
                wheel.getStatus() == Status.OK)
                .count() == wheelsCount;
    }

    public void printFullName() {
        System.out.println(String.join(" ", brand, model));
    }

    public Wheel changeWheel(Wheel wheel, WheelPosition pos) {
        if (!driving) {
            changingWheel = true;
            Wheel old = wheels.get(pos);
            wheels.put(pos, wheel);
            changingWheel = false;
            return old;
        } else throw new DrivingException("For changing wheel you need to stop");
    }

    public static Auto buildBugattiVeyron16point4() {
        Engine engine = new Engine(1001, 6500, Status.OK);
        Map<WheelPosition, Wheel> wheels = new HashMap<>();
        wheels.put(WheelPosition.BL, new Wheel("Some Tires", "Some Rims", Status.OK));
        wheels.put(WheelPosition.BR, new Wheel("Some Tires", "Some Rims", Status.OK));
        wheels.put(WheelPosition.FL, new Wheel("Some Tires", "Some Rims", Status.OK));
        wheels.put(WheelPosition.FR, new Wheel("Some Tires", "Some Rims", Status.OK));
        Auto veyron = new Auto();
        veyron.brand = "Bugatty";
        veyron.model = "Veyron 16.4";
        veyron.engine = engine;
        veyron.wheels = wheels;
        veyron.fuelCapacity = 100.0d;
        veyron.drive = Drive.AWD;
        veyron.wheelsCount = 4;
        return veyron;
    }

    public static void main(String[] args) throws Exception {
        try {
            throw new Exception();
        } finally {
            System.out.println("HERE");
        }
    }
}
