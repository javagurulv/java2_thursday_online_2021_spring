package lv.javaguru.java2.wasterestarant.services;

import lv.javaguru.java2.wasterestarant.database.Database;

public class RemoveDishService {

    private Database database;

    public RemoveDishService(Database database) {
        this.database = database;
    }

    public void execute(String dishName) {
        database.deleteByName(dishName);
    }


}
