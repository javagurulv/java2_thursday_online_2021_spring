package lv.javaguru.java2.wasterestarant.core.services.wishlist;
import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

//Nataliya - in process

public class AddDishToWishlistService {

    private Database database;
    private Long clientID;
    private String dishName;
    private int quantity;
    private OrderItem selectedOrderItem;

    public AddDishToWishlistService(Database database) {
        this.database = database;
    }

    public AddDishToWishlistResponse execute(AddDishToWishlistRequest request) {
        database.addDishToWishlist(clientID, dishName, quantity);
        System.out.println(quantity + " x " + dishName + " added to wishlist");

        return new AddDishToWishlistResponse(selectedOrderItem);
    }


}