package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya

public class GetWishlistResponse {

    private List<OrderItem> wishList;

    public GetWishlistResponse(List<OrderItem> wishList) {
        this.wishList = wishList;
    }

    public List<OrderItem> getWishList() {
        return wishList;
    }

}
