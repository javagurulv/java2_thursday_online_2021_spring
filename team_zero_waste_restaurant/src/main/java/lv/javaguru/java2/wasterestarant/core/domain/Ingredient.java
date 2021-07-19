package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    //private Product product;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientID;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "dish_id")
    private long dishIngredientID;


    public Ingredient(long ingredientID, String name, Double quantity, Long dishIngredientID) {
        this.ingredientID = ingredientID;
        this.name = name;
        this.quantity = quantity;
        this.dishIngredientID = dishIngredientID;
    }

    public Ingredient(String name, Double quantity, Long dishIngredientID) {
        this.name = name;
        this.quantity = quantity;
        this.dishIngredientID = dishIngredientID;
    }

    public Long getDishIngredientID() {
        return dishIngredientID;
    }

    public void setDishIngredientID(Long dishIngredientID) {
        this.dishIngredientID = dishIngredientID;
    }

    //    public Ingredient(String ingredient, Double quantity, Product product) {
//        this.ingredient = ingredient;
//        this.quantity = quantity;
//        this.product = product;
//    }
    public Ingredient(String name, Double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient() {

    }

    public Long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Long ingredientID) {
        this.ingredientID = ingredientID;
    }

//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getQuantity() {
        return quantity;
    }


}
