package lv.javaguru.java2.wasterestarant.core.services.ingredient.validators;


import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchDishIngredientsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchDishIngredientValidator {

    public List<CoreError> validate(SearchDishIngredientsRequest request) {
        return new ArrayList<>(validateSearchFields(request));
    }

    private List<CoreError> validateSearchFields(SearchDishIngredientsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getDishIngredientID() == null || request.getDishIngredientID() <= 0) {
            errors.add(new CoreError("search field", "must not be empty"));
        }
        return errors;
    }


}
