package lv.javaguru.java2.wasterestarant.core.responses.wishlist;

//Nataliya

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;

import java.util.List;

public class AddDishToWishlistResponse extends CoreResponse {

    private OrderItem newSelectedItem;

    public AddDishToWishlistResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddDishToWishlistResponse(OrderItem newSelectedItem) {
        this.newSelectedItem = newSelectedItem;
    }

    public OrderItem getNewSelectedItem() {
        return newSelectedItem;
    }


}
