package services;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.User;

public class DeleteAccountService {
    Database database = new InMemoryDatabaseImpl();

    public void execute(String username, String password){
        database.deleteAccount(new User(username,password));
    }
}
