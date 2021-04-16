package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;

public class LoginService {
    private Database database;

    public LoginService(Database database) {
        this.database = database;
    }
}
