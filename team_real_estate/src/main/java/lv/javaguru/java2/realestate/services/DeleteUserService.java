package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.User;

public class DeleteUserService {
    Database database;

    public DeleteUserService(Database database) {
        this.database = database;
    }

    public void execute(String username, String password){
        database.deleteUser(new User(username,password));
    }
}
