package repositories;

import models.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getCars();
    Car getCarByNumberPlate(String numberPlate);
}
