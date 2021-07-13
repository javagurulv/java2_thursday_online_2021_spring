package lv.javaguru.java2.wasterestarant.core.responses.dish;

import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;

import java.util.List;
//Elena
public class GetAllDishesResponse extends CoreResponse {

    private List<Dish> dishes;

    public GetAllDishesResponse(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
