package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchDishesRequestValidator {
    public List<CoreError> validate(SearchDishesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchDishesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getName().isEmpty() || request.getName() == null){
            errors.add(new CoreError("name", "Must not be empty!"));
        }if(request.getType().isEmpty() || request.getType() == null){
            errors.add(new CoreError("type", "Must not be empty!"));
        }if (request.getPrice().isNaN()){
            errors.add(new CoreError("price", "Field price must be a number!"));
        }if (request.getPrice() < 0) {
            errors.add(new CoreError("price", "Price must be higher 0!"));
        }
        return errors;
    }
}
