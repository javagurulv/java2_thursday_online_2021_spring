package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.User;

public class LogInService {

    Database database;

    public LogInService(Database database) {
        this.database = database;
    }

    public void execute(String username, String password){
        database.logIn(new User(username,password));
    }
}
