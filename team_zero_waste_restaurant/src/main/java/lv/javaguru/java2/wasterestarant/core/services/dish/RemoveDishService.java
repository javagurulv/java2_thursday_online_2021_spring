package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;

import java.util.List;

// AndrejsB

public class RemoveDishService {

    private Database database;
    private RemoveDishValidator validator;

    public RemoveDishService(Database database, RemoveDishValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveDishResponse execute(RemoveDishRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new RemoveDishResponse(errors);
        }
        boolean isDishDeleted = database.deleteDishByName(request.getDishNameToRemove());
        return new RemoveDishResponse(isDishDeleted);
    }
}
