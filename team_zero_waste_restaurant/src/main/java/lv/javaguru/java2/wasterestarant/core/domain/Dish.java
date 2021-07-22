package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dishID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "isInActiveMenu")
    private boolean isInActiveMenu;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private List <Ingredient> ingredientList;


    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String description, String type, double weight, double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.isInActiveMenu = true;
    }

    public Dish(String name, String description, String type, double weight, double price, boolean isInActiveMenu) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.isInActiveMenu = isInActiveMenu;
    }

    //    public Dish(String name, String description, String type,
//                double weight, double price, List<Ingredient> ingredientList) {
//        this.name = name;
//        this.description = description;
//        this.type = type;
//        this.weight = weight;
//        this.price = price;
//        this.ingredientList = ingredientList;
//    }

    public Dish() {
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

    public Long getDishID() {
        return dishID;
    }

    public void setDishID(Long dishID) {
        this.dishID = dishID;
    }

//    public List<Ingredient> getIngredientList() {
//        return ingredientList;
//    }
//
//    public void setIngredientList(List<Ingredient> ingredientList) {
//        this.ingredientList = ingredientList;
//    }

    public Dish(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Dish(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
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
        return Double.compare(dish.getWeight(), getWeight()) == 0 && Double.compare(dish.getPrice(), getPrice()) == 0 && getName().equals(dish.getName()) && getDescription().equals(dish.getDescription()) && getType().equals(dish.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getType(), getWeight(), getPrice());
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
                '}';
    }


    public void addToActiveMenu() {
        isInActiveMenu = true;
    }

    public void removeFromActiveMenu() {
        isInActiveMenu = false;
    }

}
