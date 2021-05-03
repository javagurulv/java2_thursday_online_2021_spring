package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;

import java.util.List;

@DIComponent
public class AddDishIngredientService {
    @DIDependency
    private Database database;
    @DIDependency
    private AddDishIngredientValidator validator;

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
