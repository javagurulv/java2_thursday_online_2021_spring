package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;

public class GetAllDishesService {

    private Database database;

    public GetAllDishesService(Database database) {
        this.database = database;
    }

    public void execute() {
        database.getAllDishes();
    }

}
