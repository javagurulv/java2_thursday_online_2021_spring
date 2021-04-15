package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.OrderItem;

//Nataliya

public class AddDishToWishlistResponse extends CoreResponse {

    private OrderItem newOrderItem;

    public AddDishToWishlistResponse(OrderItem newOrderItem) {
        this.newOrderItem = newOrderItem;
    }

    public OrderItem getNewOrderItem() {
        return newOrderItem;
    }

}
