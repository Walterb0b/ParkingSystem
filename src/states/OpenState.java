package states;

import main.Car;
import main.ParkingGate;

public class OpenState implements GateState {
    private final ParkingGate parkingGate;

    public OpenState(ParkingGate parkingGate){
        this.parkingGate = parkingGate;
    }

    @Override
    public boolean canEnter(Car car) {
        return true;
    }

    @Override
    public boolean canExit(Car car) {
        return true;
    }
}
