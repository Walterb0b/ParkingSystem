package util;

import main.Car;

import java.util.List;

public class ParkingValidator {
    
    public static void validateCar(Car car, List<Car> parkedCars, int capacity){
        validateNumberplate(car.getNumberplate());
        validateCapacity(parkedCars, capacity);
        validateNotParkedAlready(car, parkedCars);
    }

    public static void validateExit(Car car, List<Car> parkedCars){
        validateNumberplate(car.getNumberplate());
        validateExitCarRegistered(car, parkedCars);
    }

    public static void validateNotParkedAlready(Car car, List<Car> parkedCars){
        if(parkedCars.contains(car))
            throw new ParkingGateException("Car is already parked!");
    }

    public static void validateExitCarRegistered(Car car, List<Car> parkedCars){
        if(!parkedCars.contains(car))
            throw new ParkingGateException("Car is not in the parking area!");

    }

    private static void validateCapacity(List<Car> parkedCars, int capacity) {
        if(parkedCars.size() >= capacity)
            throw new ParkingGateException("No more space in the parking area!");
    }

    private static void validateNumberplate(String numberplate) {
        if(numberplate == null || numberplate.isBlank())
            throw new ParkingGateException("Car numberplate can't be empty!");
    }
}
