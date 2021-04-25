package lv.javaguru.java2.wasterestarant.core.services.Dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.Dish.RemoveDishResponse;

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
