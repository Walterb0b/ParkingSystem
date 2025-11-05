package states;

import main.Car;
import main.ParkingGate;

public interface GateState {
    boolean canEnter(Car car);
    boolean canExit(Car car);
}
