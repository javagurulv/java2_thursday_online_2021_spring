package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;

public class SearchEmployeesResponse extends CoreResponse {
    private List<Employee> employees;

    public SearchEmployeesResponse(List<CoreError> errors, List<Employee> employees) {
        super(errors);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}