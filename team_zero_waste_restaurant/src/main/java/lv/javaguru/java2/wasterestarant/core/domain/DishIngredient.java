package lv.javaguru.java2.wasterestarant.core.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish_ingredients")
public class DishIngredient {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="restaurant_dish")
    private String name;

//    @ManyToOne
//    @JoinColumn(name="id", nullable = false)
//    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Ingredient ingredient;

    @Column(name="ingredient", nullable = false)
    private String ingredientName;

    @Column(name="quantity", nullable = false)
    private Double quantity;

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

    public DishIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
