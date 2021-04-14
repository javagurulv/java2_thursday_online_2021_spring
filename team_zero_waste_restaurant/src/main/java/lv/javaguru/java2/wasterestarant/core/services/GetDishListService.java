package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetDishListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetDishListResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

public class GetDishListService {

    private Database database;

    public GetDishListService(Database database) {
        this.database = database;
    }

    public GetDishListResponse execute(GetDishListRequest request) {
        List<Dish> dishes = database.getAllDishes();
        return new GetDishListResponse(dishes);
    }

}
