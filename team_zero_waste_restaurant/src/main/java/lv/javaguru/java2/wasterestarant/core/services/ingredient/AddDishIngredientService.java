package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddDishIngredientService {
    @Autowired
    private Database database;
    @Autowired
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
