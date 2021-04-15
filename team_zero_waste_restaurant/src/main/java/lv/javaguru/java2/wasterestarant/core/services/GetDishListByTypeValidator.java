package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.GetDishByTypeRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.domain.DishTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetDishListByTypeValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(GetDishByTypeRequest request) {
        validateTypeToFilter(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateTypeToFilter(GetDishByTypeRequest request) {
        return (request.getDishType() == null || request.getDishType().isEmpty())
                ? Optional.of(new CoreError("Dish type ", "Enter a valid dish type"))
                : Optional.empty();
    }

}
