package lv.javaguru.java2.wasterestarant.core.services.order.validators;

import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateNewOrderValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(CreateNewOrderRequest request) {
        validateClientID(request).ifPresent(errors::add);
        validateDate(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientID(CreateNewOrderRequest request) {
        return (request.getClientID() == null)
                ? Optional.of(new CoreError("Client ID", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateDate(CreateNewOrderRequest request) {
        return (request.getOrderDate() == null)
                ? Optional.of(new CoreError("Date", "Must not be empty"))
                : Optional.empty();
    }

}
