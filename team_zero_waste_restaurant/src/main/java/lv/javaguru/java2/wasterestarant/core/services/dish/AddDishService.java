package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import java.util.*;
@DIComponent
public class AddDishService {

    @DIDependency private Database database;
    @DIDependency
    private AddDishValidator validator;

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
