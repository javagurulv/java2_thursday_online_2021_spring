package lv.javaguru.java2.wasterestarant.core.services.ingredient.validators;

import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddDishIngredientValidator {
    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(AddDishIngredientRequest request) {
        validateIngredient(request).ifPresent(errors::add);
        validateQuantity(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateIngredient(AddDishIngredientRequest request) {
        return (request.getIngredient() == null || request.getIngredient().isEmpty())
                ? Optional.of(new CoreError("Ingredient", "Must be a valid Product"))
                : Optional.empty();
    }

    private Optional<CoreError> validateQuantity(AddDishIngredientRequest request) {
        return (request.getQuantity() == null)
                ? Optional.of(new CoreError("Quantity", "Must be a valid double value"))
                : Optional.empty();
    }

}

