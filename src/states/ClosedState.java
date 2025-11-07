package states;

import main.Car;
import main.ParkingGate;

public class ClosedState implements GateState{
    private final ParkingGate parkingGate;

    public ClosedState(ParkingGate parkingGate) {
        this.parkingGate = parkingGate;
    }

    @Override
    public boolean canEnter(Car car, ParkingGate gate) {
        return false;
    }

    @Override
    public boolean canExit(Car car, ParkingGate gate) {
        return false;
    }
}
