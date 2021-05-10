package lv.javaguru.java2.wasterestarant.core.responses.ingredient;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;

import java.util.List;

public class AddDishIngredientResponse extends CoreResponse {

    private Ingredient newIngredient;

    public AddDishIngredientResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddDishIngredientResponse(Ingredient newIngredient){
        this.newIngredient = newIngredient;
    }

    public Ingredient getNewIngredient() {
        return newIngredient;
    }


}
