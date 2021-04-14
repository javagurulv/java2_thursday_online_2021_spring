package lv.javaguru.java2.wasterestarant.core.requests;

public class AddDishRequest {

    private long dishID;
    private String name;
    private String description;
    private String type;
    private Double weight;
    private Double price;

    public AddDishRequest(String name) {
        this.name = name;
    }

    public AddDishRequest(String name, String description, String type, Double weight, Double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }
}
