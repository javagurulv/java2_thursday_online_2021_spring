package lv.javaguru.java2.wasterestarant.core.requests.ingredient;

public class SearchDishIngredientsRequest {

    private String name;
    private Long dishIngredientID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDishIngredientID() {
        return dishIngredientID;
    }

    public void setDishIngredientID(Long dishIngredientID) {
        this.dishIngredientID = dishIngredientID;
    }

    public SearchDishIngredientsRequest() {
    }

    public SearchDishIngredientsRequest(String name) {
        this.name = name;
    }

    public SearchDishIngredientsRequest(Long dishIngredientID) {
        this.dishIngredientID = dishIngredientID;
    }

    public boolean isDishIdProvided(){
        return this.dishIngredientID != null;
    }
}
