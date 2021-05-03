package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya - in process
@DIComponent
public class AddDishToWishlistService {

    @DIDependency
    private Database database;
    @DIDependency
    private AddDishToWishlistValidator validator;

    public AddDishToWishlistResponse execute(AddDishToWishlistRequest request) {

        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddDishToWishlistResponse(errors);
        }

        OrderItem newSelectedItem = new OrderItem(request.getDishName(), request.getQuantity());
        database.addDishToWishlist(request.getClientID(), request.getDishName(), request.getQuantity());
        System.out.println("Dish added to wishlist");

        return new AddDishToWishlistResponse(newSelectedItem);
    }
}