package lv.javaguru.java2.wasterestarant.core.requests;
//Elena
public class SearchDishesRequest {
    private String name;
    private String type;
    private Double price;

    private Ordering ordering;
    private Paging paging;

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

    public SearchDishesRequest(String name, String type, Double price, Paging paging) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.paging = paging;
    }

    public SearchDishesRequest(String name, String type, Double price, Ordering ordering, Paging paging) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.ordering = ordering;
        this.paging = paging;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isTypeProvided() {
        return this.type != null && !this.type.isEmpty();
    }

    public boolean isPriceProvided() {
        return this.price != null && this.price > 0.0;
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

    public Paging getPaging() {
        return paging;
    }
}