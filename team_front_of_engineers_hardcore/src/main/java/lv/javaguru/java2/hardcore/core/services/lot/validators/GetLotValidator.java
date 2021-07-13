package lv.javaguru.java2.hardcore.core.services.lot.validators;

import lv.javaguru.java2.hardcore.core.requests.lot.GetLotRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetLotValidator {

    public List<CoreError> validate (GetLotRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetLotRequest request){
        return (request.getId() == null)
                ? Optional.of(new CoreError("id" , "Must not be empty!"))
                : Optional.empty();
    }
}
