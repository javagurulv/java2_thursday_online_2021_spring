package lv.javaguru.java2.wasterestarant.core.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish_ingredients")
public class DishIngredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="restaurant_dish")
    private String name;

    @Column(name="dish_id")
    private Long dish_id;

    @ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false, insertable = false, updatable = false)
    private Ingredient ingredients;

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }
//    @OneToMany
//    @JoinColumn(name = "dish_id", nullable = false, insertable = false, updatable = false)
//    private List<Ingredient> ingredients;
//
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }

    @Column(name="ingredient", nullable = false)
    private String ingredientName;

    @Column(name="quantity", nullable = false)
    private Double quantity;

    public Long getDish_id() {
        return dish_id;
    }

    public void setDish_id(Long dish_id) {
        this.dish_id = dish_id;
    }

    public DishIngredient(Long dish_id) {
        this.dish_id = dish_id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Dish getDish() {
//        return dish;
//    }
//
//    public void setDish(Dish dish) {
//        this.dish = dish;
//    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public DishIngredient() {
    }


    public void setId(Long id) {
        this.id = id;
    }

}
