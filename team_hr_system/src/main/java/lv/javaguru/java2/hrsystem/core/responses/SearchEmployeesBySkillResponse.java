package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;

public class SearchEmployeesBySkillResponse extends CoreResponse{
    private List<Employee> employees;

    public SearchEmployeesBySkillResponse(List<CoreError> errors, List<Employee> employees) {
        super(errors);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}