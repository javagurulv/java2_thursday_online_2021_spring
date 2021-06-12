package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;
import java.util.Set;

public class SearchEmployeesBySkillResponse extends CoreResponse{
    private List<Employee> employees;
    private Set<Employee> employeeSet;

    public SearchEmployeesBySkillResponse(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public SearchEmployeesBySkillResponse(List<CoreError> errors, List<Employee> employees) {
        super(errors);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }
}