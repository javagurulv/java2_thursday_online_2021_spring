package lv.javaguru.java2.wasterestarant.core.responses.dish;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;

import java.util.List;

public class SearchDishesResponse extends CoreResponse {
    List<Dish> dishes;

    public SearchDishesResponse(List<Dish> dishes, List<CoreError> errors) {
        super(errors);
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
