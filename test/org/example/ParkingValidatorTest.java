package org.example;

import main.Car;
import main.ParkingGate;
import org.junit.jupiter.api.Test;
import util.ParkingGateException;
import util.ParkingValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingValidatorTest {
    List<Car> parkedCars = new ArrayList<>();
    ParkingGate parkingGate = new ParkingGate();
    int capacity = 50;
    @Test
    void validateExit() {
        Car c = new Car("AB12345");
        assertThrows(ParkingGateException.class,
                () -> ParkingValidator.validateExit(c, parkedCars)); // tom liste

        parkedCars.add(c);
        assertDoesNotThrow(() -> ParkingValidator.validateExit(c, parkedCars));
    }

    @Test
    void validateEntry() {
        Car c = new Car("AB12345");
        parkedCars.add(c);
        assertThrows(ParkingGateException.class,
                () -> ParkingValidator.validateEntry(c, parkedCars, capacity));

        // fyld op
        parkedCars.clear();
        for (int i = 0; i < 50; i++) parkedCars.add(new Car("X"+i));
        assertThrows(ParkingGateException.class,
                () -> ParkingValidator.validateEntry(new Car("NEW1"), parkedCars, capacity));
    }

    @Test
    void ensureNotParked() {
    }

    @Test
    void ensureIsParked() {
    }
}