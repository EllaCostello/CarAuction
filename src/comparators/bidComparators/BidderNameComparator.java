package comparators.bidComparators;

import models.Bid;

import java.util.Comparator;

public class BidderNameComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid o1, Bid o2) {
        return o1.getBidder().compareTo(o2.getBidder());
    }
}
