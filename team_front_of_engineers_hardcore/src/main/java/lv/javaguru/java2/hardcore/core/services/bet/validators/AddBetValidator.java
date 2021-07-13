package lv.javaguru.java2.hardcore.core.services.bet.validators;


import lv.javaguru.java2.hardcore.core.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AddBetValidator {

    public List<CoreError> validate(AddBetRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validatePrice(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddBetRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("Lot ID", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePrice(AddBetRequest request) {
        return (request.getBet() == null || request.getBet().equals(BigDecimal.ZERO))
                ? Optional.of(new CoreError("Bet", "Must not be empty or equal to zero"))
                : Optional.empty();
    }
}
