package com.vaka.epam.homework.week2.task7.auto;

import lombok.Getter;
import org.apache.commons.math3.util.Precision;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Iaroslav on 11/9/2016.
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

    private double fuel;

    private double fuelCapacity;

    private boolean driving;

    private int wheelsCount;

    public Auto() {

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
        if (incoming <= 0)
            throw new RefuelException(String.format("Fuel amount cannot be lower or equal 0, your: %s", incoming));
        if (driving)
            throw new DrivingException("You need to stop for refuel");
        double totalFuel = Precision.round(this.fuel + incoming, 2);
        if (fuelCapacity >= totalFuel) {
            this.fuel = Precision.round(this.fuel + incoming, 2);
        } else
            throw new RefuelException(String.format("Incoming fuel is to much, fuel capacity: %s, current: %s, incoming: %s", fuelCapacity, fuel, incoming));
    }

    private boolean hasEngine() {
        return engine != null;
    }

    private boolean hasFuel() {
        return fuel != 0d;
    }

    private boolean isEngineOk() {
        return engine.getStatus() == Status.OK;
    }


    public boolean readyToDrive() {
        return hasEngine() && hasFuel() && isEngineOk() && checkWheels();
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
            Wheel old = wheels.get(pos);
            wheels.put(pos, wheel);
            return old;
        } else throw new DrivingException("For changing wheel you need to stop");
    }

    public static Auto createCar(Engine engine, Map<WheelPosition, Wheel> wheels, String brand, String model, double fuelCapacity) {
        Auto car = new Auto();
        car.brand = brand;
        car.model = model;
        car.engine = engine;
        car.wheels = wheels;
        car.fuelCapacity = fuelCapacity;
        car.wheelsCount = 4;
        return car;
    }

}
