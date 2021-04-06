package services;

import database.Database;

public class RemoveDishService {

    private Database database;

    public RemoveDishService(Database database) {
        this.database = database;
    }

    public void execute(String dishName) {
        database.deleteByName(dishName);
    }


}
