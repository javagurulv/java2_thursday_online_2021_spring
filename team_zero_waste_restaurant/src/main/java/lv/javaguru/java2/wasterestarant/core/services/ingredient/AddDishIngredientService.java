package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.database.ingredient.IngredientRepository;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.validators.AddDishIngredientValidator;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddDishIngredientService {
    @Autowired
    private IngredientRepository database;
    @Autowired
    private AddDishIngredientValidator validator;

    public AddDishIngredientResponse execute(AddDishIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddDishIngredientResponse(errors);
        }

        Ingredient ingredient = new Ingredient(request.getIngredient(), request.getQuantity(), request.getIngredientID());
        database.save(ingredient);
        System.out.println("New Ingredient was added to the ingredient list.");

        return new AddDishIngredientResponse(ingredient);
    }
}
