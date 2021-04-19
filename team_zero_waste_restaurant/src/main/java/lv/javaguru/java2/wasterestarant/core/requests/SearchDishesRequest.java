package lv.javaguru.java2.wasterestarant.core.requests;
//Elena
public class SearchDishesRequest {
    private String name;
    private String type;
    private Double price;
    private Ordering ordering;

    public SearchDishesRequest(String name, String type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public SearchDishesRequest(String name, String type, Double price, Ordering ordering) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.ordering = ordering;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }
    public boolean isTypeProvided() {
        return this.type != null && !this.type.isEmpty();
    }
    public boolean isPriceProvided() { return this.price != null && !this.price.isNaN() && this.price < 0 && this.price == 0.0;}
}
