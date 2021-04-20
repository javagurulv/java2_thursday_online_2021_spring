package lv.javaguru.java2.wasterestarant.core.requests;
//Elena
public class SearchDishesRequest {
    private String name;
    private String type;
    private Double price;

    public SearchDishesRequest(String name, String type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
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

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }
    public boolean isTypeProvided() {
        return this.type != null && !this.type.isEmpty();
    }
    public boolean isPriceProvided() { return this.price != null && !this.price.isNaN() && this.price > 0;}
}
