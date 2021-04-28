package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.requests.lot.SearchLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchLotValidator {

    public List<CoreError> validate(SearchLotRequest request) {
        List<CoreError> errors = new ArrayList<>();
       validateName(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> validateName(SearchLotRequest request) {
        return (request.getName() == null||request.getName().isEmpty())
                ? Optional.of(new CoreError("Lot name", "Must not be null"))
                : Optional.empty();
    }
}
