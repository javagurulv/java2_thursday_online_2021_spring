package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;

public class GetDishesByTypeService {

    private Database database;

    public GetDishesByTypeService(Database database) {
        this.database = database;
    }

    public void execute(String dishType) {
        database.getDishByType(dishType);
    }
}
