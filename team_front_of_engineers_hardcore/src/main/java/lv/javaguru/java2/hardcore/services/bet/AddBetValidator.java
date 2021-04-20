package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddBetValidator {

    public List<CoreError> validate(AddBetRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validatePrice(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddBetRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("Lot name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePrice(AddBetRequest request) {
        return (request.getBet() == null || request.getBet().equals(BigDecimal.ZERO))
                ? Optional.of(new CoreError("Lot price", "Must not be empty or equal to zero"))
                : Optional.empty();
    }
}
