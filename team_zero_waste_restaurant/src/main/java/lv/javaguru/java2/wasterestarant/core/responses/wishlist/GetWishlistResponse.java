package lv.javaguru.java2.wasterestarant.core.responses.wishlist;

import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;

import java.util.List;

//Nataliya

public class GetWishlistResponse extends CoreResponse {

    private List<OrderItem> selectedItems;

    public GetWishlistResponse(List<OrderItem> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<OrderItem> getWishlist() {
        return selectedItems;
    }

}
