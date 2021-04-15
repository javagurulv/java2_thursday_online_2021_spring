package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.RegistrationResponse;
import lv.javaguru.java2.hrsystem.domain.Admin;

public class RegistrationService {

   public Database database;

    public RegistrationService(Database database) {

        this.database = database;

    }

    public RegistrationResponse execute (RegistrationRequest registrationRequest){

        Admin admin = new Admin(registrationRequest.getFirstName(), registrationRequest.getSecondName(),
                registrationRequest.getEmail(), registrationRequest.getPassword());
        database.registrationAdm(admin);

        return new RegistrationResponse(admin);

    }
}
