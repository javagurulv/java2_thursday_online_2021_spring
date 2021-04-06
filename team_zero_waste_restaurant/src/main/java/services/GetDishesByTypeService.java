package services;

import database.Database;


public class GetDishesByTypeService {

    private Database database;

    public GetDishesByTypeService(Database database) {
        this.database = database;
    }

    public void execute(String dishType) {
        database.getDishByType(dishType);
    }
}
