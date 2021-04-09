package lv.javaguru.java2.wasterestarant.services;

import lv.javaguru.java2.wasterestarant.database.Database;

public class GetAllDishesService {

    private Database database;


    public GetAllDishesService(Database database) {
        this.database = database;
    }

    public void execute() {
        database.getAllDishes();
    }

}
