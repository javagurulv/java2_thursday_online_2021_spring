package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetDishByTypeRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetDishByTypeResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

public class GetDishesByTypeService {

    private Database database;
    private GetDishByTypeRequest request;
    private String dishType;

    public GetDishesByTypeService(Database database) {
        this.database = database;
    }


    public GetDishByTypeResponse execute(GetDishByTypeRequest request) {
        if (request.getDishType() != null) {
            dishType = request.getDishType();
        }
        List<Dish> typeDishes = database.dishByType(dishType);
        return new GetDishByTypeResponse(typeDishes);
    }
}
