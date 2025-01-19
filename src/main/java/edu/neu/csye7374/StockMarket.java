package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;

    private List<Stock> stocks = new ArrayList<>();

    private StockMarket() {

    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stockItem) {
        stocks.add(stockItem);
    }

    public void removeStock(Stock stock) {
        if (stocks.contains(stock)) {
            stocks.remove(stock);
        } else {
            System.out.println("Stock not found");
        }
    }

    public void updatePrice(Stock stock, double newPrice) {
        if (stocks.contains(stock)) {
            stock.setPrice(newPrice);
        }
    }

    public void displayAllStocks() {
        stocks.forEach(stock -> System.out.println(stock.toString()));
    }

}