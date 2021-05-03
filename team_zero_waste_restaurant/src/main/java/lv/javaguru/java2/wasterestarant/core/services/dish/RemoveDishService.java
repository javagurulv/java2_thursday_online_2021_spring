package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

import java.util.List;

// AndrejsB
@DIComponent
public class RemoveDishService {

    @DIDependency private Database database;
    @DIDependency
    private RemoveDishValidator validator;

    public RemoveDishResponse execute(RemoveDishRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new RemoveDishResponse(errors);
        }
        boolean isDishDeleted = database.deleteDishByName(request.getDishNameToRemove());
        return new RemoveDishResponse(isDishDeleted);
    }
}
