package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;

public class AddEmployeeResponse extends CoreResponse {

    private Employee newEmployee;

    public AddEmployeeResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddEmployeeResponse(Employee newEmployee) {
        this.newEmployee = newEmployee;
    }

    public Employee getNewEmployee() {
        return newEmployee;
    }
}
