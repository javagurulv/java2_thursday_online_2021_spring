package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;

import java.util.List;

public class SearchIngredientService {

    private Database database;
    private SearchIngredientValidator validator;

    public SearchIngredientService(Database database, SearchIngredientValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchIngredientResponse execute(SearchIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()) {
            return new SearchIngredientResponse(null, errors);
        }

        List<Ingredient> ingredients = null;
        if(request.isIngredientNameProvided()) {
            ingredients = database.findIngredientByName(request.getIngredientName());
        }

        return new SearchIngredientResponse(ingredients, null);
    }

}
