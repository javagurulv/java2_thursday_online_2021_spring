package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

//Nataliya - in process

public class GetRestaurantMenuService {
    private Database database;

    public GetRestaurantMenuService(Database database) {
        this.database = database;
    }

    public GetRestaurantMenuResponse execute(GetRestaurantMenuRequest request){
//        List<Dish> restaurantMenu = database.getRestaurantMenu();
        List<Dish> restaurantMenu = database.getAllDishes(); // NB. Temporary route.
        // Need to implement List<Dish> restaurantMenu into database.
        return new GetRestaurantMenuResponse(restaurantMenu);
    }
}
