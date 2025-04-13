package comparators.bidComparators;

import models.Bid;

import java.util.Comparator;

public class BidCarComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid o1, Bid o2) {
        int comparedByBrand =  o1.getCar().getBrand().compareTo(o2.getCar().getBrand());
        if (comparedByBrand != 0) {
            return comparedByBrand;
        }
        return o1.getCar().getModel().compareTo(o2.getCar().getModel());
    }

}
