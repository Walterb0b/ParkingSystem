package org.example;

import main.Car;
import main.ParkingGate;
import org.junit.jupiter.api.Test;
import states.EntryOnlyState;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntryOnlyStateTest {
    Car car;
    ParkingGate parkingGate = new ParkingGate();
    EntryOnlyState entryOnlyState = new EntryOnlyState(parkingGate);

    @Test
    void canEnter() {
        car = new Car("YX12345");
        parkingGate.registerEntry(car);
        assertTrue(entryOnlyState.canEnter(car, parkingGate));

    }


    @Test
    void canExit() {
        car = new Car("YX12345");
        parkingGate.registerEntry(car);
        assertFalse(entryOnlyState.canExit(car, parkingGate));
    }
}