package lv.javaguru.java2.wasterestarant.core.requests;

import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public class AddDishRequest {

    private long dishID;
    private String name;
    private String description;
    private String type;
    private double weight;
    private double price;


    public AddDishRequest(String name) {
        this.name = name;
    }


    public AddDishRequest(String name, String description, String type, double weight, double price) {
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

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
