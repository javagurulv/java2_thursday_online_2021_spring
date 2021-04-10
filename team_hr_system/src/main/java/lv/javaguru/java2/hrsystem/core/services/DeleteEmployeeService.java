package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;

import java.util.ArrayList;
import java.util.List;

public class DeleteEmployeeService {

    private final Database database;

    public DeleteEmployeeService(Database database) {
        this.database = database;
    }

    public DeleteEmployeeResponse execute(DeleteEmployeeRequest deleteEmployeeRequest) {
        if (deleteEmployeeRequest.getId() == null) {
            CoreError error = new CoreError("id", "is empty");
            List<CoreError> errors = new ArrayList<>() {{
                add(error);
            }};
            return new DeleteEmployeeResponse(errors);
        }
        boolean deleted = database.deleteEmployee(deleteEmployeeRequest.getId());
        return new DeleteEmployeeResponse(deleted);
    }
}