package main;

import states.ClosedState;
import states.GateState;
import util.ParkingValidator;

import java.util.ArrayList;
import java.util.List;

public class ParkingGate {
    private List<Car> parkedCars;
    private GateState state;
    int capacity;

    public ParkingGate(){
        this.parkedCars = new ArrayList<>();
        this.capacity = 50;
        this.state = new ClosedState(this);
    }


    public void addCar(Car c){
        ParkingValidator.validateCar(c, parkedCars, capacity);
        parkedCars.add(c);
    }

    public void removeCar(Car c){
        ParkingValidator.validateExit(c, parkedCars);
        parkedCars.remove(c);
    }

    public void removeAllCars(){
        parkedCars.removeAll(parkedCars);
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public String getState() {
        String state = this.state.getClass().getSimpleName();
        return "The parking gate state is: " + state;
    }
}
