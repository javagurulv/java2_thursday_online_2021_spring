package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;

import java.util.List;

//Nataliya

public class GetRestaurantMenuResponse extends CoreResponse {

    private List<Dish> restaurantMenu;

    public GetRestaurantMenuResponse(List<Dish> restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public List<Dish> getRestaurantMenu() {
        return restaurantMenu;
    }

}
