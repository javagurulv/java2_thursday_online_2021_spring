package lv.javaguru.java2.hardcore.core.services.lot.validators;


import lv.javaguru.java2.hardcore.core.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Transactional
public class RemoveLotValidator {


    public List<CoreError> validate(RemoveLotRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> validateId(RemoveLotRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("Lot id", "Must not be null"))
                : Optional.empty();
    }
}
