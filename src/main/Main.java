import main.Car;
import main.ParkingGate;
import states.EntryOnlyState;
import states.ExitOnlyState;
import util.ParkingGateException;

void main() {

    ParkingGate gate = new ParkingGate();

    Car car1 = new Car("AB12345");
    Car car2 = new Car("CD67890");

    // Start i CLOSED
    System.out.println(gate.getState());

    // Skift state så biler kan komme ind
    gate.setState(new EntryOnlyState(gate));

    try {
        System.out.println("Registering entry for car1...");
        gate.registerEntry(car1);
        System.out.println("car1 entered!");
    } catch (ParkingGateException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Prøv at tage den samme bil ind igen → forventet fejl
    try {
        System.out.println("Trying entry again for car1...");
        gate.registerEntry(car1);
    } catch (ParkingGateException e) {
        System.out.println("Expected error: " + e.getMessage());
    }

    // Bil skal nu ud → skift til EXIT_ONLY
    gate.setState(new ExitOnlyState(gate));

    try {
        System.out.println("Car1 exiting...");
        gate.registerExit(car1);
        System.out.println("car1 exited!");
    } catch (ParkingGateException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Prøv at sende bil ud der ikke er inde
    try {
        System.out.println("Trying exit for car2...");
        gate.registerExit(car2);
    } catch (ParkingGateException e) {
        System.out.println("Expected error: " + e.getMessage());
    }

    System.out.println("Parking simulation finished ✅");
}
