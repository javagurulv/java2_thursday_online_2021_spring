package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// AndrejsB
@Component
public class RemoveDishService {

    @Autowired
    private DishRepository database;
    @Autowired
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
