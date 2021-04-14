package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//AndrejsB
public class RemoveDishValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RemoveDishRequest request) {
        validateNameToRemove(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateNameToRemove(RemoveDishRequest request){
        return (request.getDishNameToRemove() == null || request.getDishNameToRemove().isEmpty())
                ? Optional.of(new CoreError("nameToRemove", "Must not be empty"))
                : Optional.empty();
    }
}
