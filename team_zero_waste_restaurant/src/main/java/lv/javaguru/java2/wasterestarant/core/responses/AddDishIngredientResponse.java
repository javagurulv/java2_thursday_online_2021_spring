package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Ingredient;

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
