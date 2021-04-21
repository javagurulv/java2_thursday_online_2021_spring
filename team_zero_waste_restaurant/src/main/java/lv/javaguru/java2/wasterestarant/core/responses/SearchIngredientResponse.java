package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Ingredient;

import java.util.List;

public class SearchIngredientResponse extends CoreResponse {

    private List<Ingredient> ingredients;

    public SearchIngredientResponse(List<Ingredient> ingredients, List<CoreError> errors){
        super(errors);
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


}
