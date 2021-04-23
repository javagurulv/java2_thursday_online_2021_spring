package lv.javaguru.java2.wasterestarant.core.requests.Ingredient;

public class SearchIngredientRequest {

    private String ingredientName;

    public SearchIngredientRequest(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public boolean isIngredientNameProvided(){
        return this.ingredientName != null && !this.ingredientName.isEmpty();
    }

}
