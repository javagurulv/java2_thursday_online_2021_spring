package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.RegisterUserValidator;
import lv.javaguru.java2.hrsystem.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserService {

   @Autowired private Database database;
   @Autowired private RegisterUserValidator validator;

   public RegisterUserResponse execute (RegisterUserRequest registrationRequest){
       List<CoreError> errors = validator.validate(registrationRequest);

       if (!errors.isEmpty()) {
           return new RegisterUserResponse(errors);
       }

       User user = new User(registrationRequest.getUserRole(),
               registrationRequest.getFirstName(),
               registrationRequest.getSecondName(),
               registrationRequest.getEmail(),
               registrationRequest.getPassword());

       database.registerUser(user);

       return new RegisterUserResponse(user);

   }
}
