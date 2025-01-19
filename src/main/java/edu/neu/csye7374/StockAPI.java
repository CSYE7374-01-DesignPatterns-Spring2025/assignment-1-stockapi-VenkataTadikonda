package edu.neu.csye7374;

public class StockAPI {
    String ID;
    Double price;
    String name;
    String description;

    public StockAPI(String ID, String name, Double price, String description) {
        super();
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public StockAPI() {
        super();
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "StockAPI{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
