package states;

import main.Car;
import main.ParkingGate;

public class EntryOnlyState implements GateState{
    private final ParkingGate parkingGate;

    public EntryOnlyState(ParkingGate parkingGate){
        this.parkingGate = parkingGate;
    }
    @Override
    public boolean canEnter(Car car) {
        return true;
    }

    @Override
    public boolean canExit(Car car) {
        return false;
    }
}
