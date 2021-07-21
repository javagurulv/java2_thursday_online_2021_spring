package lv.javaguru.java2.wasterestarant.core;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetRestaurantMenuService {
    @Autowired
    private DishRepository repository;

    public GetRestaurantMenuResponse execute(GetRestaurantMenuRequest request) {
        List<Dish> restaurantMenu = repository.getAllDishesInActiveMenu(request.isInActiveMenu());
        return new GetRestaurantMenuResponse(restaurantMenu);
    }
}
