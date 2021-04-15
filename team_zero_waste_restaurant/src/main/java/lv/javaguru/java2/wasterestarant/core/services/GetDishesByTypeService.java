package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetDishByTypeRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.GetDishByTypeResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.ArrayList;
import java.util.List;

// AndrejsB
public class GetDishesByTypeService {

    private Database database;
    private GetDishByTypeRequest request;
    private String dishType;
    private GetDishListByTypeValidator validator;

    public GetDishesByTypeService(Database database, GetDishListByTypeValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public GetDishByTypeResponse execute(GetDishByTypeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetDishByTypeResponse(errors, dishType);
        }
        dishType = request.getDishType();
        List<Dish> typeDishes = database.getDishByType(dishType);
        return new GetDishByTypeResponse(typeDishes);
    }
}

