package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//AndrejsB
public class RemoveProductValidator {
    List<CoreError> errors = new ArrayList<>();


    public List<CoreError> validate(RemoveProductRequest request){
        validateNameToRemove(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateNameToRemove(RemoveProductRequest request) {
        return (request.getProductNameToRemove() == null|| request.getProductNameToRemove().isEmpty())
                ? Optional.of(new CoreError("nameToRemove", "must not be empty"))
                : Optional.empty();
    }

}
