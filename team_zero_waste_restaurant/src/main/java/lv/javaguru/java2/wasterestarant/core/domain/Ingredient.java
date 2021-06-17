package lv.javaguru.java2.wasterestarant.core.domain;

import com.sun.xml.fastinfoset.algorithm.DoubleEncodingAlgorithm;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    //private Product product;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredientID;

    @Column(name = "name")
    private String ingredient;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "DishId", insertable = false, updatable = false)
    private Long dishIngredientID;

    @ManyToOne
    @JoinColumn(name = "DishId", nullable = false)
    private Dish dish;


    public Ingredient(long ingredientID, String ingredient, Double quantity, Long dishIngredientID) {
        this.ingredientID = ingredientID;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.dishIngredientID = dishIngredientID;
    }

    public Ingredient(String ingredient, Double quantity, Long dishIngredientID) {
        this.ingredient = ingredient;
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
    public Ingredient(String ingredient, Double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient() {

    }

    public Long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(long ingredientID) {
        this.ingredientID = ingredientID;
    }

//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getIngredient(){
        return ingredient;
    }

    public Double getQuantity(){
        return quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

}
