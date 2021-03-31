import java.util.Objects;

public class Dish {
    private String name;
    private String description;
    private double weight;
    private double price;

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
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (weight != dish.weight) return false;
        if (!name.equals(dish.name)) return false;
        return description.equals(dish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, weight, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name ='" + name + '\'' +
                ", description ='" + description + '\'' +
                ", weight =" + weight +
                '}';
    }
}
