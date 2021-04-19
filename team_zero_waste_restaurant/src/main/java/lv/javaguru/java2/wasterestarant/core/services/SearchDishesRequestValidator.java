package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

//Elena
public class SearchDishesRequestValidator {
    public List<CoreError> validate(SearchDishesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));

        return errors;
    }

    private List<CoreError> validateSearchFields(SearchDishesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmptyString(request.getName()) &&
                isEmptyString(request.getType()) &&
                isEmptyDouble(request.getPrice())) {
            errors.add(new CoreError("name", "Must not be empty"));
            errors.add(new CoreError("type", "Must not be empty"));
            errors.add(new CoreError("price", "Must not be empty"));
        }
        return errors;
    }

    private boolean isEmptyString(String str){
        return str == null || str.isEmpty();
    }

    private boolean isEmptyDouble(Double dbl){
        return dbl == null || dbl == 0.0 || dbl < 0 || dbl.isNaN();
    }
}
