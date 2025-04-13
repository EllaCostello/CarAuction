package models;

public class Bid {
    private final String bidder;
    private final double amount;
    private final Car car;

    public Bid(String bidder, double amount, Car car) {
        this.bidder = bidder;
        this.amount = amount;
        this.car = car;
    }

    public String getBidder() { return bidder; }

    public double getAmount() { return amount; }

    public Car getCar() { return car; }
}
