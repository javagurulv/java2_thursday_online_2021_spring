package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Nataliya - in process
@Component
public class AddDishToWishlistService {

    @Autowired
    private Database database;
    @Autowired
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