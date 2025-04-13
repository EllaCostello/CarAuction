import controllers.AuctionController;
import repositories.BidRepository;
import repositories.CarRepository;
import repositories.InMemoryBidRepository;
import repositories.InMemoryCarRepository;
import services.BidService;
import services.CarService;

public class CarBiddingApp {
    public static void main(String[] args) {
        CarRepository carRepository = new InMemoryCarRepository();
        BidRepository bidRepository = new InMemoryBidRepository();

        CarService carService = new CarService(carRepository);
        BidService bidService = new BidService(bidRepository, carRepository);

        AuctionController auctionController = new AuctionController(carService, bidService);
        auctionController.start();
    }
}
