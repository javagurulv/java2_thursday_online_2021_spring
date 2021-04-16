package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;

public class RegistrationService {
    private Database database;

    public RegistrationService(Database database) {
        this.database = database;
    }
}
