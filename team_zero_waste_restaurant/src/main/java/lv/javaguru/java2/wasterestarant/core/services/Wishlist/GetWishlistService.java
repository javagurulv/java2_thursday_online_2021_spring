package lv.javaguru.java2.wasterestarant.core.services.Wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.Wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya

public class GetWishlistService {

    private Database database;

    public GetWishlistService(Database database) {
        this.database = database;
    }

    public GetWishlistResponse execute(GetWishlistRequest request){
        List<OrderItem> selectedItems = database.getWishlistByClientID(request.getClientID());
        return new GetWishlistResponse(selectedItems);

    }

}
