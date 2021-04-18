package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

//Nataliya - in process

public class AddDishToWishlistService {

    private Database database;

    public AddDishToWishlistService(Database database) {
        this.database = database;
    }

    public AddDishToWishlistResponse execute(AddDishToWishlistRequest request) {

        return null; //TO DO

    }
}
