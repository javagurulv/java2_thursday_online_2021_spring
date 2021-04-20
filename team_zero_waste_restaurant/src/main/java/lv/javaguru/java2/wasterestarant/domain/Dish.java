package lv.javaguru.java2.wasterestarant.domain;

import java.util.List;
import java.util.Objects;

public class Dish {
    private long dishID;
    private String name;
    private String description;
    private String type;
    private double weight;
    private double price;
    private List<Ingredient> ingredientList;
    private boolean isInActiveMenu;

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
                double weight, double price, List<Ingredient> ingredientList) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.ingredientList = ingredientList;
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

    public long getDishID() {
        return dishID;
    }

    public void setDishID(long dishID) {
        this.dishID = dishID;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public boolean isInActiveMenu() {
        return isInActiveMenu;
    }

    public void setInActiveMenu(boolean inActiveMenu) {
        isInActiveMenu = inActiveMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.getWeight(), getWeight()) == 0 && Double.compare(dish.getPrice(), getPrice()) == 0 && getName().equals(dish.getName()) && getDescription().equals(dish.getDescription()) && getType().equals(dish.getType()) && getIngredientList().equals(dish.getIngredientList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getType(), getWeight(), getPrice(), getIngredientList());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishID=" + dishID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", ingredientList=" + ingredientList +
                '}';
    }

    public void addToActiveMenu() {
        isInActiveMenu = true;
    }

    public void removeFromActiveMenu() {
        isInActiveMenu = false;
    }

}
