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

    public SearchEmployeesBySkillResponse(List<CoreError> errors, Set<Employee> employeeSet) {
        super(errors);
        this.employeeSet = employeeSet;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }
}