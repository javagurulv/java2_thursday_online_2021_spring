package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Dish;

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
