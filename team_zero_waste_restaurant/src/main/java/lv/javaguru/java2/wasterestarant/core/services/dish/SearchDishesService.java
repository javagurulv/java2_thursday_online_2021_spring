package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Elena
public class SearchDishesService {
    private Database database;
    private SearchDishesRequestValidator validator;

    public SearchDishesService(Database database, SearchDishesRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchDishesResponse execute(SearchDishesRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchDishesResponse(null, errors);
        }
        List<Dish> dishes = search(request);
        dishes = order(dishes, request.getOrdering());
        dishes = paging(dishes, request.getPaging());
        return new SearchDishesResponse(dishes, null);
    }

    private List<Dish> order(List<Dish> dishes, Ordering ordering) {
        if (ordering != null) {
            if ((ordering.getOrderBy().equals("name")) && (ordering.getOrderDirection().equals("ASCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getName))
                        .collect(Collectors.toList());
            }
            if ((ordering.getOrderBy().equals("name")) && (ordering.getOrderDirection().equals("DESCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getName).reversed())
                        .collect(Collectors.toList());
            }
            if ((ordering.getOrderBy().equals("type")) && (ordering.getOrderDirection().equals("ASCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getType))
                        .collect(Collectors.toList());
            }
            if ((ordering.getOrderBy().equals("type")) && (ordering.getOrderDirection().equals("DESCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getType).reversed())
                        .collect(Collectors.toList());
            }
            if ((ordering.getOrderBy().equals("price")) && (ordering.getOrderDirection().equals("ASCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getPrice))
                        .collect(Collectors.toList());
            }
            if ((ordering.getOrderBy().equals("price")) && (ordering.getOrderDirection().equals("DESCENDING"))) {
                return dishes.stream().sorted(Comparator.comparing(Dish::getPrice).reversed())
                        .collect(Collectors.toList());
            }
        }
        return dishes;
    }

    private List<Dish> search(SearchDishesRequest request) {
        List<Dish> dishes = new ArrayList<>();
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
        return dishes;
    }

    private List<Dish> paging(List<Dish> books, Paging paging) {
        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return books.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return books;
        }
    }
}