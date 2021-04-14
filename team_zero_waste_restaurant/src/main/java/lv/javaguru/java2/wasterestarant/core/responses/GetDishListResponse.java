package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
//Elena
public class GetDishListResponse extends CoreResponse{

    private List<Dish> dishes;

    public GetDishListResponse(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
