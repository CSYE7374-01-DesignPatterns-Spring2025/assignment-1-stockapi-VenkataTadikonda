package edu.neu.csye7374;

public class HPStock extends Stock {

    public HPStock(String ID, String name, double price, String description) {
        super(ID, name,price, description);
    }

    @Override
    public int getMetric() {
        double averageBid = bids.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        int newMetric = (int) (100 - Math.abs(this.bids.get(bids.size()-1) - averageBid));
        setMetric(newMetric);
        return newMetric;
    }
    
}