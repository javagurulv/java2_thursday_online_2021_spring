package lv.javaguru.java2.wasterestarant.domain;

public class Ingredient {
    private Product ingredient;
    private double quantity;

    public Ingredient(Product ingredient, double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }
}
