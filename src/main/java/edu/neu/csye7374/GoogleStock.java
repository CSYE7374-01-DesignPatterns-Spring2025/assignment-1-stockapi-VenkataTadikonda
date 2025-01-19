package edu.neu.csye7374;

public class GoogleStock extends Stock {

    public GoogleStock(String ID, String name, double price, String description) {
        super(ID, name, price, description);
    }


    @Override
    public int getMetric() {
        int trendMetric = 0;
        if (bids.size() >= 2) {
            double latestBid = bids.get(bids.size() - 1);
            double previousBid = bids.get(bids.size() - 2);
    
            trendMetric = Double.compare(latestBid, previousBid);
            setMetric(trendMetric);
        }
        return trendMetric;
    }


}