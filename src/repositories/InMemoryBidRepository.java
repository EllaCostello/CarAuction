package repositories;

import models.Bid;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBidRepository implements BidRepository {
    List<Bid> bids = new ArrayList<>();
    @Override
    public List<Bid> getBids() {
        return bids;
    }

    @Override
    public void addBid(Bid bid) {
        bids.add(bid);
    }
}
