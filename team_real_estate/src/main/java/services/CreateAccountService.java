package services;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.User;

public class CreateAccountService {
    Database database = new InMemoryDatabaseImpl();

    public void execute(String username, String password){
        database.createAccount(new User(username,password));
    }
}
