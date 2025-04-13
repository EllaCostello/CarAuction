package comparators.carComparators;

import models.Car;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o1.getBasePrice(), o2.getBasePrice());
    }
}
