package repositories;

import models.Bid;

import java.util.List;

public interface BidRepository {
    List<Bid> getBids();
    void addBid(Bid bid);
}
