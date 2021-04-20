package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.SearchDishesResponse;
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

    public SearchDishesResponse execute(SearchDishesRequest request){
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchDishesResponse(null, errors);
        }
//        List<Dish> dishes = search(request);
//        dishes = order(dishes, request.getOrdering());
//        return new SearchDishesResponse(dishes, null);
        return null;
    }

    private List<Dish> order(List<Dish> dishes, Ordering ordering) {
        if (ordering != null) {
            Comparator<Dish> comparator = null;
            if(ordering.getOrderBy().equals("name")) {
                Comparator.comparing(Dish::getName);
            }else if(ordering.getOrderBy().equals("type")){
                Comparator.comparing(Dish::getType);
            }else{
                Comparator.comparing(Dish::getPrice);
            }
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return dishes.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return dishes;
        }
    }

//    private List<Dish> search(SearchDishesRequest request) {
//        List<Dish> books = new ArrayList<>();
//        if (request.isTitleProvided() && !request.isAuthorProvided()) {
//            books = database.findByTitle(request.getTitle());
//        }
//        if (!request.isTitleProvided() && request.isAuthorProvided()) {
//            books = database.findByAuthor(request.getAuthor());
//        }
//        if (request.isTitleProvided() && request.isAuthorProvided()) {
//            books = database.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
//        }
//        return books;
//    }

}
