package lv.javaguru.java2.wasterestarant.core.responses.dish;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;

import java.util.List;

public class AddDishResponse extends CoreResponse {

    private Dish newDish;

    public AddDishResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddDishResponse(Dish newDish) {
        this.newDish = newDish;
    }

    public Dish getNewDish() {
        return newDish;
    }
}
