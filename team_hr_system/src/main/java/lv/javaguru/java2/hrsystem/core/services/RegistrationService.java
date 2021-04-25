package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.RegistrationResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.RegistrationValidator;
import lv.javaguru.java2.hrsystem.domain.Admin;

import java.util.List;

public class RegistrationService {

   private Database database;
   private RegistrationValidator validator;

    public RegistrationService(Database database, RegistrationValidator validator) {

        this.database = database;
        this.validator = validator;

    }

    public RegistrationResponse execute (RegistrationRequest registrationRequest){
        List<CoreError> errors = validator.validate(registrationRequest);

        if (!errors.isEmpty()) {
            return new RegistrationResponse(errors);
        }

        Admin admin = new Admin(registrationRequest.getFirstName(), registrationRequest.getSecondName(),
                registrationRequest.getEmail(), registrationRequest.getPassword());
        database.registrationAdm(admin);

        return new RegistrationResponse(admin);

    }
}
