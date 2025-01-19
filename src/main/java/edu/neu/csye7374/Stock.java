package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class Stock extends StockAPI implements Tradable {
    protected List<Double> bids = new ArrayList<>();
    protected int metric = 0;

    public Stock() {
        super();
    }

    public void setMetric(int metric) {
        this.metric = metric;
    }

    public Stock(String Id, String stockName, double stockPrice, String description) {
        super(Id, stockName, stockPrice, description);
    }

    @Override
    public void setBid(String bidString) {
        try {
            double bid = Double.parseDouble(bidString);
            bids.add(bid);
            double averagePrice = bids.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            setPrice(averagePrice);
            StockMarket.getInstance().updatePrice(this, averagePrice);
        } catch (NumberFormatException e) {
            System.err.println("Invalid bid: " + bidString);
        }
    }

    private static void initializeStock(Stock stock, String[] bids) {
        StockMarket.getInstance().addStock(stock);
        for (String bid : bids) {
            stock.setBid(bid);
            stock.getMetric();
            System.out.println(stock.toString());

        }
    }

    public static void demo() {
        Stock googleStock = new GoogleStock("G-0123", "Google", 131.15, "Google Common Stock");
        Stock hpStock = new HPStock("HP-001", "Hewlett-Packard", 145.23, "HP stock");

        String[] bidsGoogle = { "132.00", "131.50", "135.00", "120.50", "118.00", "140.00" };
        String[] bidsHP = { "146.00", "147.50", "149.00", "150.50", "152.00", "154.00" };

        System.out.println("======================Initializing stocks======================");
        initializeStock(googleStock, bidsGoogle);
        System.out.println("================================================================");
        initializeStock(hpStock, bidsHP);

        System.out.println("======================Displaying all stocks======================");
        StockMarket.getInstance().displayAllStocks();

    }

    @Override
    public String toString() {
        return super.toString() +
                ", bids=" + bids +
                ", metric=" + metric;
    }
}