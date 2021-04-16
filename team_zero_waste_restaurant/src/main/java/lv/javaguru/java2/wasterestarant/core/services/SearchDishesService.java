package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

public class SearchDishesService {
    private Database database;
    private SearchDishesRequestValidator validator;

    public SearchDishesService(Database database, SearchDishesRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchDishesResponse execute(SearchDishesRequest request){
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchDishesResponse(null, errors);
        }
        List<Dish> dishes = null;
        if (request.isNameProvided() && !request.isTypeProvided() && !request.isPriceProvided()) {
            dishes = database.findDishByName(request.getName());
        }
        if (request.isTypeProvided() && !request.isNameProvided() && !request.isPriceProvided()) {
            dishes = database.findDishByType(request.getType());
        }
        if (request.isPriceProvided() && !request.isNameProvided() && !request.isTypeProvided()) {
            dishes = database.findDishByPrice(request.getPrice());
        }
        if (request.isNameProvided() && request.isTypeProvided() && !request.isPriceProvided()) {
            dishes = database.findDishByNameAndType(request.getName(), request.getType());
        }
        if (request.isNameProvided() && request.isPriceProvided() && !request.isTypeProvided()) {
            dishes = database.findDishByNameAndPrice(request.getName(), request.getPrice());
        }
        if (request.isTypeProvided() && request.isPriceProvided() && !request.isNameProvided()) {
            dishes = database.findDishByTypeAndPrice(request.getType(), request.getPrice());
        }
        if (request.isNameProvided() && request.isTypeProvided() && request.isPriceProvided()) {
            dishes = database.findDishByNameAndTypeAndPrice(request.getName(), request.getType(), request.getPrice());
        }
        return new SearchDishesResponse(dishes, null);
    }
}
