public class Dish {
    private String name;
    private String description;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + weight;
        return result;
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
    public String toString() {
        return "Dish{" +
                "name ='" + name + '\'' +
                ", description ='" + description + '\'' +
                ", weight =" + weight +
                '}';
    }
}
