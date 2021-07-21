package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.database.ingredient.IngredientRepository;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.validators.SearchIngredientValidator;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Transactional
public class SearchIngredientService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;
    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private IngredientRepository database;
    @Autowired
    private SearchIngredientValidator validator;

    public SearchIngredientResponse execute(SearchIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()) {
            return new SearchIngredientResponse(null, errors);
        }

        List<Ingredient> ingredients = search(request);
        ingredients = order(ingredients, request.getOrdering());
        ingredients = paging(ingredients, request.getPaging());

        return new SearchIngredientResponse(ingredients, null);
    }

    private List<Ingredient> order(List<Ingredient> ingredients, Ordering ordering) {
        if (orderingEnabled && (ordering != null)) {
            Comparator<Ingredient> comparator = ordering.getOrderBy().equals("N")
                    ? Comparator.comparing(Ingredient::getName)
                    : Comparator.comparing(Ingredient::getQuantity);
            if (ordering.getOrderDirection().equals("D")) {
                comparator = comparator.reversed();
            }
            return ingredients.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return ingredients;
        }

    }

    private List<Ingredient> paging(List<Ingredient> ingredients, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return ingredients.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return ingredients;
        }
    }

    private List<Ingredient> search(SearchIngredientRequest request) {
        List<Ingredient> ingredients = new ArrayList<>();
        if (request.isIngredientNameProvided()) {
            ingredients = database.findIngredientByName(request.getName());
        }
        return ingredients;
    }


}
