package comparators.carComparators;

import models.Car;

import java.util.Comparator;

public class CarBrandComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
