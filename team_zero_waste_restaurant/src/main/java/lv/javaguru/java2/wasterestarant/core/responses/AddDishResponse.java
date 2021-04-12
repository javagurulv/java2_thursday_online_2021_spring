package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

public class AddDishResponse extends CoreResponse{

    private Dish newDish;

    public AddDishResponse(Dish newDish) {
        this.newDish = newDish;
    }


    public Dish getNewDish() {
        return newDish;
    }
}
