package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddDishService {

    private Database database;
    private AddDishValidator validator;
    private Dish dish;

    public AddDishService(Database database, AddDishValidator validator ) {
        this.database = database;
        this.validator = validator;
    }

    public AddDishResponse execute(AddDishRequest request) {
        List<CoreError> errors = validator.validate(request);
            if (!errors.isEmpty()) {
                return new AddDishResponse(errors);
            }

        Dish dish = new Dish(request.getName(), request.getDescription(), request.getType(), request.getWeight(), request.getPrice() /*request.productList*/);
        database.save(dish);
        System.out.println("New dish was added to the list.");

        return new AddDishResponse(dish);
    }

}
