package lv.javaguru.java2.wasterestarant.core.requests.ingredient;

public class AddDishIngredientRequest {
    private String ingredient;
    private Double quantity;

    public AddDishIngredientRequest(String ingredient, Double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public String getIngredient() {
    return ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }
}
