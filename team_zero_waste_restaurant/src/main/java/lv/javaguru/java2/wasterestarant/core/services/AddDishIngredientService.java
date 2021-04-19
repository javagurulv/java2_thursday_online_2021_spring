package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;

import java.util.List;

public class AddDishIngredientService {
    private Database database;
    private AddDishIngredientValidator validator;

    public AddDishIngredientService(Database database, AddDishIngredientValidator validator ) {
        this.database = database;
        this.validator = validator;
    }

    public AddDishIngredientResponse execute(AddDishIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddDishIngredientResponse(errors);
        }

        Ingredient ingredient = new Ingredient(request.getIngredient(), request.getQuantity());
        database.save(ingredient);
        System.out.println("New Ingredient was added to the ingredient list.");

        return new AddDishIngredientResponse(ingredient);
    }
}
