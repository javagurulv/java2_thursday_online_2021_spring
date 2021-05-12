package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.DeleteEmployeeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteEmployeeService {

    @Autowired private Database database;
    @Autowired private DeleteEmployeeRequestValidator validator;

    public DeleteEmployeeResponse execute(DeleteEmployeeRequest deleteEmployeeRequest) {

        List<CoreError> errors = validator.validate(deleteEmployeeRequest);

        if (!errors.isEmpty()) {
            return new DeleteEmployeeResponse(errors);
        }

        boolean deleted = database.deleteEmployee(deleteEmployeeRequest.getId());

        return new DeleteEmployeeResponse(deleted);
    }
}