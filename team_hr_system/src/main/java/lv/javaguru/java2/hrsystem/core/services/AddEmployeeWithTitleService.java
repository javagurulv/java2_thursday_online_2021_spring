package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import lv.javaguru.java2.hrsystem.core.domain.*;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeWithTitleService {

   @Autowired private Database database;
   @Autowired private AddEmployeeWithTitleValidator validator;

   public AddEmployeeWithTitleResponse execute(AddEmployeeWithTitleRequest request) {
       List<CoreError> errors = validator.validate(request);
       if (!errors.isEmpty()) {
           return new AddEmployeeWithTitleResponse(errors);
       }

       Employee employee = new Employee(
               request.getName(), request.getLastName(), request.getAge(), EmployeeTitle.valueOf(request.getTitle()));
       database.saveEmployee(employee);
       return new AddEmployeeWithTitleResponse(employee);
   }
}