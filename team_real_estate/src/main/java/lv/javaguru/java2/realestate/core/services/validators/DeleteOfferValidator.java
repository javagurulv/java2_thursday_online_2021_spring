package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteOfferValidator {

    public List<CoreError> validate(DeleteOfferRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateID(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateID(DeleteOfferRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("ID", "Must not be empty"))
                : Optional.empty();
    }
}
