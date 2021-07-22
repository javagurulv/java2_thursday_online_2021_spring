package lv.javaguru.java2.wasterestarant.core.services.dish.validators;

import lv.javaguru.java2.wasterestarant.core.requests.dish.GetDishByIdRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetDishByIdValidator {
    public List<CoreError> validate(GetDishByIdRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetDishByIdRequest request){
        return (request.getId() == null)
                ? Optional.of(new CoreError("id", "Must not be empty!"))
                : Optional.empty();
    }
}
