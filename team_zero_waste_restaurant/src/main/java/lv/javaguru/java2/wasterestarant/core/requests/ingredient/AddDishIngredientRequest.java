package lv.javaguru.java2.wasterestarant.core.requests.ingredient;

public class AddDishIngredientRequest {
    private String ingredient;
    private Double quantity;
    private Long ingredientID;
    public AddDishIngredientRequest(String ingredient, Double quantity, Long ingredientID) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.ingredientID = ingredientID;
    }

    public String getIngredient() {
    return ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Long getIngredientID() {
        return ingredientID;
    }
}
