package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.services.dish.validators.AddDishValidator;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AddDishService {

    @Autowired
    private DishRepository database;
    @Autowired
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
