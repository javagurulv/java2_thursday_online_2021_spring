package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya
@DIComponent
public class GetWishlistService {

    @DIDependency
    private Database database;

    public GetWishlistResponse execute(GetWishlistRequest request) {
        List<OrderItem> selectedItems = database.getWishlistByClientID(request.getClientID());
        return new GetWishlistResponse(selectedItems);

    }

}
