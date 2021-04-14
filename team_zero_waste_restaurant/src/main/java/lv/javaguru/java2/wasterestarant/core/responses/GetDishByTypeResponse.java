package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
// AndrejsB
public class GetDishByTypeResponse extends CoreResponse{

    private List<Dish> dishes;

    public GetDishByTypeResponse(List<Dish> dishes) {
        this.dishes = dishes;
    }


    public List<Dish> getDishesType() {
        return dishes;
    }
}
