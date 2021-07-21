package lv.javaguru.java2.wasterestarant.core.services.ingredient;


import lv.javaguru.java2.wasterestarant.core.database.ingredient.IngredientRepository;
import lv.javaguru.java2.wasterestarant.core.domain.DishIngredient;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.validators.SearchDishIngredientValidator;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchDishIngredientsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchDishIngredientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class SearchDishIngredientsService {

    @Autowired
    private IngredientRepository database;
    @Autowired
    private SearchDishIngredientValidator validator;

    public SearchDishIngredientsResponse execute(SearchDishIngredientsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()) {
            return new SearchDishIngredientsResponse(null, errors);
        }
        List<DishIngredient> dishIngredients = search(request);

        return new SearchDishIngredientsResponse(dishIngredients, null);
    }

    private List<DishIngredient> search(SearchDishIngredientsRequest request) {
        List<DishIngredient> dishIngredients = new ArrayList<>();
        if (request.isDishIdProvided()) {
            dishIngredients = database.findIngredientByDishId(request.getDishIngredientID());
        }
        return dishIngredients;
    }
}
