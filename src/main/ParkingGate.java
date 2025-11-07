package main;

import states.ClosedState;
import states.EntryOnlyState;
import states.GateState;
import util.ParkingGateException;
import util.ParkingValidator;

import java.util.ArrayList;
import java.util.List;

public class ParkingGate {
    private final List<Car> parkedCars;
    private GateState state;
    int capacity;

    public ParkingGate(){
        this.parkedCars = new ArrayList<>();
        this.capacity = 50;
        this.state = new ClosedState(this);
    }


    public void registerEntry(Car c){
        if(!state.canEnter(c, this)){
            throw new ParkingGateException("Gate is closed for entry right now!");
        }
        ParkingValidator.validateEntry(c, parkedCars, capacity);
        parkedCars.add(c);
    }

    public void registerExit(Car c){
        if(!state.canExit(c, this)){
            throw new ParkingGateException("Gate is closed for exiting right now!");
        }
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

    public void setState(GateState entryOnlyState) {
        this.state = entryOnlyState;
    }
}
