package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.dish.GetAllDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetAllDishesResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
//Elena
public class GetAllDishesService {

    private Database database;

    public GetAllDishesService(Database database) {
        this.database = database;
    }

    public GetAllDishesResponse execute(GetAllDishesRequest request) {
        List<Dish> dishes = database.getAllDishes();
        return new GetAllDishesResponse(dishes);
    }

}
