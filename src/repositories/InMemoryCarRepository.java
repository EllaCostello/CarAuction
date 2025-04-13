package repositories;

import models.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository {

    List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarByNumberPlate(String numberPlate) {
        for (Car car : cars) {
            if (car.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                return car;
            }
        }
        return null;
    }
}
