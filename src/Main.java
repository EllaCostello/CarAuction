import comparators.bidComparators.BidAmountComparator;
import comparators.carComparators.CarBrandComparator;
import comparators.carComparators.CarPriceComparator;
import models.Bid;
import models.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Car toyotaCamry = new Car("Toyota", "Camry", 2012, 20_000, "XE 92 654");
        Car bmwI5 = new Car("BMW", "i5", 2024, 560_000, "XE 93 654");
        Car skodaEnyaq = new Car("Skode", "Enyaq", 2025, 450_000, "YR 10 874");
        Car bmwI4 = new Car("BMW", "i4", 2023, 420_000, "WQ 96 858");

        cars.add(toyotaCamry);
        cars.add(bmwI5);
        cars.add(skodaEnyaq);
        cars.add(bmwI4);

        List<Bid> bids = new ArrayList<>();
        Bid bid1 = new Bid("Ella", 30_000, toyotaCamry);
        Bid bid2 = new Bid("Casper", 35_000, toyotaCamry);
        Bid bid3 = new Bid("Niklas", 600_000, bmwI5);
        Bid bid4 = new Bid("Megan", 450_000, skodaEnyaq);
        Bid bid5 = new Bid("Osman", 460_000, skodaEnyaq);

        bids.add(bid1);
        bids.add(bid2);
        bids.add(bid3);
        bids.add(bid4);
        bids.add(bid5);

        System.out.println("ORIGINAL CAR LIST (sorted by year):");
        printCarList(cars);

        System.out.println("Sorted by Brand:");
        cars.sort(new CarBrandComparator());
        printCarList(cars);

        System.out.println("Sorted by price:");
        cars.sort(new CarPriceComparator());
        printCarList(cars);

        printHighestBids(bids, cars);


    }

    public static void printCarList(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void printBidList(List<Bid> bids) {
        for (Bid bid : bids) {
            System.out.println(bid);
        }
    }

    public static void printHighestBids(List<Bid> bids, List<Car> cars) {
        bids.sort(new BidAmountComparator());

        for (Car car : cars) {
            for (Bid bid : bids) {
                if (bid.getCar().getNumberPlate().equals(car.getNumberPlate())) {
                    System.out.println("Highest bid for car with numberplate " + car.getNumberPlate() + " is " + bid.getAmount());
                    break;
                }
            }
        }
    }
}
