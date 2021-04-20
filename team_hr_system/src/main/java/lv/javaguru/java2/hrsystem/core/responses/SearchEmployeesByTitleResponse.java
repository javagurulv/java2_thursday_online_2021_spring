package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.Employee;
import java.util.List;

public class SearchEmployeesByTitleResponse extends CoreResponse{
    private List<Employee> employees;

    public SearchEmployeesByTitleResponse(List<CoreError> errors, List<Employee> employees) {
        super(errors);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}