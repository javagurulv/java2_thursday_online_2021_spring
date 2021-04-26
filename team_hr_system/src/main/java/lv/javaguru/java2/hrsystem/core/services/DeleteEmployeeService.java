package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.DeleteEmployeeRequestValidator;

import java.util.List;

public class DeleteEmployeeService {

    private final Database database;
    private DeleteEmployeeRequestValidator validator = new DeleteEmployeeRequestValidator();

    public DeleteEmployeeService(Database database) {
        this.database = database;
    }

    public DeleteEmployeeResponse execute(DeleteEmployeeRequest deleteEmployeeRequest) {
        List<CoreError> errors = validator.validate(deleteEmployeeRequest);
        if (!errors.isEmpty()) {
            return new DeleteEmployeeResponse(errors);
        }
        boolean deleted = database.deleteEmployee(deleteEmployeeRequest.getId());
        return new DeleteEmployeeResponse(deleted);
    }
}