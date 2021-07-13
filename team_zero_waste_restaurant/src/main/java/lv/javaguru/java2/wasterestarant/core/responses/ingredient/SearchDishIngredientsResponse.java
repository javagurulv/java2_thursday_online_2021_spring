package lv.javaguru.java2.wasterestarant.core.responses.ingredient;

import lv.javaguru.java2.wasterestarant.core.domain.DishIngredient;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;

import java.util.List;

public class SearchDishIngredientsResponse extends CoreResponse {

    private List<DishIngredient> ingredients;

    public SearchDishIngredientsResponse(List<DishIngredient> dishIngredients, List<CoreError> errors){
        super(errors);
        this.ingredients = dishIngredients;
    }

    public List<DishIngredient> getIngredients() {
        return ingredients;
    }


}
