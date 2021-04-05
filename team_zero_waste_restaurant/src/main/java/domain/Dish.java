package domain;

import java.util.List;
import java.util.Objects;

public class Dish {
    private String name;
    private String description;
    private String type;
    private String dishComposition;
    private double weight;
    private double price;

    public Dish() {
    }

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String description, String type, String dishComposition,
                double weight, double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.dishComposition = dishComposition;
        this.weight = weight;
        this.price = price;
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

    public String getDishComposition() {
        return dishComposition;
    }

    public void setDishComposition(String dishComposition) {
        this.dishComposition = dishComposition;
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
        return Double.compare(dish.weight, weight) == 0 &&
                Double.compare(dish.price, price) == 0 &&
                name.equals(dish.name) &&
                description.equals(dish.description) &&
                type.equals(dish.type) &&
                dishComposition.equals(dish.dishComposition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, dishComposition, weight, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", dishComposition=" + dishComposition +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
