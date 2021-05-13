package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;

public class AddEmployeeWithTitleResponse extends CoreResponse{
    private Employee employee;

    public AddEmployeeWithTitleResponse(Employee employee) {
        this.employee = employee;
    }

    public AddEmployeeWithTitleResponse(List<CoreError> errors) {
        super(errors);
    }

    public Employee getEmployee() {
        return employee;
    }
}