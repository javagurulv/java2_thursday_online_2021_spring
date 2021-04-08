package domain;

import java.util.List;
import java.util.Objects;

public class Dish{
    private String name;
    private String description;
    private String type;
    private double weight;
    private double price;
    private List<Product> productList;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String description, String type, double weight, double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
    }

    public Dish(String name, String description, String type,
                double weight, double price, List<Product> productList) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.getWeight(), getWeight()) == 0 && Double.compare(dish.getPrice(), getPrice()) == 0 && getName().equals(dish.getName()) && getDescription().equals(dish.getDescription()) && getType().equals(dish.getType()) && Objects.equals(getProductList(), dish.getProductList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getType(), getProductList(), getWeight(), getPrice());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", productList=" + productList +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
