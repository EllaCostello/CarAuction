package models;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {
    private static final List<Car> allCars = new ArrayList<>();
    private final String brand;
    private final String model;
    private final int year;
    private final double basePrice;
    private final String numberPlate;

    public Car(String brand, String model, int year, double basePrice, String numberPlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
        if (isNumberPlateTaken(numberPlate)) {
            throw new IllegalArgumentException("Number plate " + numberPlate + " is not available.");
        }
        this.numberPlate = numberPlate;
        allCars.add(this);
    }

    public static boolean isNumberPlateTaken(String numberPlate) {
        for (Car car : allCars) {
            if (car.numberPlate.equals(numberPlate)) {
                return true;
            }
        }
        return false;
    }

    public String getBrand() {
        return brand;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public String toString() {
        return """
                Brand:              %s
                Model:              %s
                Year:               %d
                Starting price:     %.0f
                License plate:      %S
                """.formatted(brand, model, year, basePrice, numberPlate);
    }


    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.getYear());
    }
}
