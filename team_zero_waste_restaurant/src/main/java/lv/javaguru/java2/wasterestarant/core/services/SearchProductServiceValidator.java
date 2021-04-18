package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchProductServiceValidator {

    public List<CoreError> validate(SearchProductRequest request){
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchProductRequest request){
        List<CoreError> errors = new ArrayList<>();
        if(isEmpty(request.getNameToSearch())) {
            errors.add(new CoreError("name to search", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String name){
        return name == null || name.isEmpty();
    }
}
