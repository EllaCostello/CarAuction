package services;

import comparators.carComparators.CarBrandComparator;
import comparators.carComparators.CarPriceComparator;
import exceptions.NoCarsException;
import models.Car;
import repositories.CarRepository;

import java.util.List;
import java.util.Scanner;

public class CarService {
    List<Car> cars;

    public CarService(CarRepository carRepository) {
        cars = carRepository.getCars();
    }

    public void createCar(Car car) {
        cars.add(new Car(car.getBrand(), car.getModel(), car.getYear(), car.getBasePrice(), car.getNumberPlate()));
    }

    public void getCars() {
        if (cars.isEmpty()) {
            throw new NoCarsException("No cars found");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public void sortCarsByBrand() {
        cars.sort(new CarBrandComparator());
    }

    public void sortCarsByPrice() {
        cars.sort(new CarPriceComparator());
    }
}
