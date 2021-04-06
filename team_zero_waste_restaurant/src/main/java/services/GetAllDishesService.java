package services;

import database.Database;

public class GetAllDishesService {

    private Database database;


    public GetAllDishesService(Database database) {
        this.database = database;
    }

    public void execute() {
        database.getAllDishes();
    }

}
