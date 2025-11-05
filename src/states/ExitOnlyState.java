package states;

import main.Car;
import main.ParkingGate;

public class ExitOnlyState implements GateState{
    private final ParkingGate parkingGate;

    public ExitOnlyState(ParkingGate parkingGate){
        this.parkingGate = parkingGate;
    }

    @Override
    public boolean canEnter(Car car) {
        return false;
    }

    @Override
    public boolean canExit(Car car) {
        return true;
    }
}
