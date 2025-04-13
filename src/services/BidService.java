package services;

import comparators.bidComparators.BidAmountComparator;
import exceptions.InvalidBidException;
import exceptions.NoCarsException;
import models.Bid;
import models.Car;
import repositories.BidRepository;
import repositories.CarRepository;

import java.util.List;

public class BidService {
    private final BidRepository bidRepository;
    private final CarRepository carRepository;


    public BidService( BidRepository bidRepository, CarRepository carRepository) {
        this.bidRepository = bidRepository;
        this.carRepository = carRepository;
    }

    public void createBid(String bidderName, double amount, String numberPlate) {
        List<Car> cars = carRepository.getCars();

        if (cars.isEmpty()) {
            throw new NoCarsException("No cars are available");
        }

        Car car = carRepository.getCarByNumberPlate(numberPlate);
        if (car == null) {
            throw new InvalidBidException("Car with numberplate: " + numberPlate + " cannot be found.");
        }

        if (amount <= 0 || amount < car.getBasePrice()) {
            throw new InvalidBidException("Bid must more than the baseprice");
        }

        Bid bid = new Bid(bidderName, amount, car);
        bidRepository.addBid(bid);
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
