package lv.javaguru.java2.hardcore.core.services.lot.validators;


import lv.javaguru.java2.hardcore.core.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AddLotValidator {

    public List<CoreError> validate(AddLotRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validatePrice(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddLotRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Lot name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePrice(AddLotRequest request) {
        return (request.getPrice() == null || request.getPrice().equals(BigDecimal.ZERO))
                ? Optional.of(new CoreError("Lot price", "Must not be empty or equal to zero"))
                : Optional.empty();
    }
}
