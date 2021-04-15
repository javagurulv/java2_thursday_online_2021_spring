package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.domain.Admin;

public class RegistrationService {

   public Database database;

    public RegistrationService(Database database) {

        this.database = database;

    }

    public void execute (String firstName, String secondName, String email, String password){

        database.registrationAdm(new Admin(firstName, secondName, email, password));

    }
}
