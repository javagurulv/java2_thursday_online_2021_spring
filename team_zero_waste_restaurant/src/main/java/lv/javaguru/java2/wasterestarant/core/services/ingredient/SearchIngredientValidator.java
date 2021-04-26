package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchIngredientValidator {

    public List<CoreError> validate(SearchIngredientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchIngredientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getIngredientName())) {
            errors.add(new CoreError("Ingredient Name", "Must not be empty"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }



}
