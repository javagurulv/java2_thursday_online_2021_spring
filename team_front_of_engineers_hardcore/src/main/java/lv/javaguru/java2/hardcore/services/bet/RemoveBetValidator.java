package lv.javaguru.java2.hardcore.services.bet;


import lv.javaguru.java2.hardcore.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RemoveBetValidator {

    public List<CoreError> validate(RemoveBetRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> validateId(RemoveBetRequest request) {
        return (request.getBetIdToRemove() == null)
                ? Optional.of(new CoreError("Lot id", "Must not be null"))
                : Optional.empty();
    }
}
