package util;

import main.Car;

import java.util.List;

public class ParkingValidator {
    
    public static void validateEntry(Car car, List<Car> parkedCars, int capacity){
        requireNonNullCar(car);
        validateNumberplate(car.getNumberplate());
        validateCapacity(parkedCars, capacity);
        ensureNotParked(car, parkedCars);
    }

    public static void validateExit(Car car, List<Car> parkedCars){
        requireNonNullCar(car);
        validateNumberplate(car.getNumberplate());
        ensureIsParked(car, parkedCars);
    }

    public static void ensureNotParked(Car car, List<Car> parkedCars){
        if(parkedCars.contains(car))
            throw new ParkingGateException("Car is already parked!");
    }

    public static void ensureIsParked(Car car, List<Car> parkedCars){
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

    private static void requireNonNullCar(Car c){
        if(c == null) throw new ParkingGateException("Car cannot be null!");
    }
}
