package states;

import main.Car;
import main.ParkingGate;

public interface GateState {
    boolean canEnter(Car car, ParkingGate gate);
    boolean canExit(Car car, ParkingGate gate);
}
