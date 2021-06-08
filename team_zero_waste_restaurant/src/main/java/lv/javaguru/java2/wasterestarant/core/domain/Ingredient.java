package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    private Product product;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientID;

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "quantity")
    private Double quantity;

    public Ingredient(String ingredient, Double quantity, Product product) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.product = product;
    }
    public Ingredient(String ingredient, Double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient() {

    }

    public long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(long ingredientID) {
        this.ingredientID = ingredientID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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
}
