package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchIngredientService {

    private Database database;
    private SearchIngredientValidator validator;

    public SearchIngredientService(Database database, SearchIngredientValidator validator) {
        this.database = database;
        this.validator = validator;
    }

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
        if (ordering != null) {
            Comparator<Ingredient> comparator = ordering.getOrderBy().equals("N")
                    ? Comparator.comparing(Ingredient::getIngredient)
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
        if (paging != null) {
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
            ingredients = database.findIngredientByName(request.getIngredientName());
        }
        return ingredients;
    }


}
