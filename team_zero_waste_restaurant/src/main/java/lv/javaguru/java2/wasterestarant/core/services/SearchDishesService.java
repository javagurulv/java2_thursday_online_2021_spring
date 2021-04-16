package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;

public class SearchDishesService {
    private Database database;
    private SearchDishesRequestValidator validator;

    public SearchDishesService(Database database, SearchDishesRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }
}
