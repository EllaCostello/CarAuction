package comparators.bidComparators;

import models.Bid;

import java.util.Comparator;

public class BidAmountComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid o1, Bid o2) {
        return Double.compare(o2.getAmount(), o1.getAmount());
    }
}
