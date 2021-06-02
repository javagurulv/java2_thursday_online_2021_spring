package lv.javaguru.java2.wasterestarant.core.domain;

public class Ingredient {
    private Product product;
    private String ingredient;
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
