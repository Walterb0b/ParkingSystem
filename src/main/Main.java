import main.Car;
import main.ParkingGate;
import states.EntryOnlyState;
import states.ExitOnlyState;
import util.ParkingGateException;

void main() {

    ParkingGate gate = new ParkingGate();

    Car car1 = new Car("AB12345");
    Car car2 = new Car("CD67890");

    // Start in CLOSED
    System.out.println(gate.getState());

    // Change states so cars can get in
    gate.setState(new EntryOnlyState(gate));

    try {
        System.out.println("Registering entry for car1...");
        gate.registerEntry(car1);
        System.out.println("car1 entered!");
    } catch (ParkingGateException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Try to enter the same car -> expected error
    try {
        System.out.println("Trying entry again for car1...");
        gate.registerEntry(car1);
    } catch (ParkingGateException e) {
        System.out.println("Expected error: " + e.getMessage());
    }

    // Cars has to get out -> change state to ExitOnly
    gate.setState(new ExitOnlyState(gate));

    try {
        System.out.println("Car1 exiting...");
        gate.registerExit(car1);
        System.out.println("car1 exited!");
    } catch (ParkingGateException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Try to send out car that's not in the parking space
    try {
        System.out.println("Trying exit for car2...");
        gate.registerExit(car2);
    } catch (ParkingGateException e) {
        System.out.println("Expected error: " + e.getMessage());
    }

    System.out.println("Parking simulation finished ✅");
}
