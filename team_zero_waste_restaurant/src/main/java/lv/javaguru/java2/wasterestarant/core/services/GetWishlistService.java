package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetWishListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.responses.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya - in process

public class GetWishlistService {
    private Database database;

    public GetWishlistService(Database database) {
        this.database = database;
    }

    public GetWishlistResponse execute(GetWishListRequest request){
//        List<OrderItem> wishList = database.getOrder(); Need to implement List<Dish> wishList into database.
//        return new GetWishlistResponse(wishList);
        return null; // temporary
    }

}
