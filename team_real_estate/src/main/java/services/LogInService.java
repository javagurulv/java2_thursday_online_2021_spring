package services;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.User;

public class LogInService {

    Database database = new InMemoryDatabaseImpl();

    public void execute(String username, String password){
        database.logIn(new User(username,password));
    }
}
