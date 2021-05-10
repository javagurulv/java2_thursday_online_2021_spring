package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.dish.GetAllDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetAllDishesResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
//Elena
@Component
public class GetAllDishesService {

    @Autowired
    private Database database;

    public GetAllDishesResponse execute(GetAllDishesRequest request) {
        List<Dish> dishes = database.getAllDishes();
        return new GetAllDishesResponse(dishes);
    }

}
