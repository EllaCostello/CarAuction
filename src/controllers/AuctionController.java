package controllers;

import exceptions.NoCarsException;
import models.Car;
import services.BidService;
import services.CarService;

import java.util.Scanner;

public class AuctionController {
    Scanner scanner = new Scanner(System.in);
    CarService carService;
    BidService bidService;

    public AuctionController(CarService carService, BidService bidService) {
        this.carService = carService;
        this.bidService = bidService;
    }

    public void start() {
        printMenu();
    }

    public void printMenu() {
        System.out.println("""
                Welcome to the Auction app!
                What would you like to do?
                
                1. View Cars
                2. Place a bid
                3. View current bids
                4. Put a car up for auction
                5. Exit
                
                Enter your choice here\s""");

        handleMenuInput(scanner);
    }

    public void handleMenuInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid choice: ");
            scanner.nextLine();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> carService.getCars();
            case 2 -> createCar(scanner);
        }
    }

    public void createCar(Scanner scanner) {
        System.out.println("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter car model: ");
        String model = scanner.nextLine();

        System.out.println("Enter car year: ");
        int year = handleIntInput(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter car base-price: ");
        double basePrice = handleDoubleInput(scanner.nextDouble());

        System.out.println("Enter car numberplate: ");
        String numberPlate = scanner.nextLine();

        carService.createCar(new Car(brand, model, year, basePrice, numberPlate));
    }

    public int handleIntInput(int input) {
        while (!scanner.hasNextInt() || input < 0) {
            System.out.println("Please enter number greater than 0: ");
            scanner.next();
        }
        return input;
    }

    public double handleDoubleInput(double input) {
        while (!scanner.hasNextDouble() || input < 0) {
            System.out.println("Please enter number greater than 0: ");
            scanner.nextLine();
        }
        return input;
    }
}
