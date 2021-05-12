package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateOfferValidator {

    public List<CoreError> validate(CreateOfferRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateOfferType(request).ifPresent(errors::add);
        validateOfferCategory(request).ifPresent(errors::add);
        validateDescription(request).ifPresent(errors::add);
        validatePrice(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateOfferType(CreateOfferRequest request) {
        return (request.getOfferType() == null || request.getOfferType().isEmpty())
                ? Optional.of(new CoreError("Offer Type", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateOfferCategory(CreateOfferRequest request) {
        return (request.getOfferCategory() == null || request.getOfferCategory().isEmpty())
                ? Optional.of(new CoreError("Offer Category", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateDescription(CreateOfferRequest request) {
        return (request.getDescription() == null || request.getDescription().isEmpty())
                ? Optional.of(new CoreError("Description", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePrice(CreateOfferRequest request) {
        return (request.getPrice() == null || request.getPrice() == 0.0)
                ? Optional.of(new CoreError("Price", "Must not be zero"))
                : Optional.empty();
    }
}
