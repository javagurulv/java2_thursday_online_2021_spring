package lv.javaguru.java2.wasterestarant.core.responses.dish;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class GetDishByIdResponse extends CoreResponse {

    private Dish dish;

    public GetDishByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetDishByIdResponse(List<CoreError> errors, Dish dish) {
        super(errors);
        this.dish = dish;
    }

    public GetDishByIdResponse(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }
}
