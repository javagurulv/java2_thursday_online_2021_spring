package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Nataliya
@Component
public class GetWishlistService {

    @Autowired
    private Database database;

    public GetWishlistResponse execute(GetWishlistRequest request) {
        List<OrderItem> selectedItems = database.getWishlistByClientID(request.getClientID());
        return new GetWishlistResponse(selectedItems);

    }

}
