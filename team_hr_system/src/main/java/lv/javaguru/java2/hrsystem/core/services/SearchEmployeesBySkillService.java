package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesBySkillRequestValidator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.*;

import java.util.ArrayList;
import java.util.List;

@DIComponent
public class SearchEmployeesBySkillService {

    @DIDependency private Database database;
    @DIDependency private SearchEmployeesBySkillRequestValidator validator;

    public SearchEmployeesBySkillResponse execute(SearchEmployeesBySkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchEmployeesBySkillResponse(errors, null);
        }
        List<Employee> employeesWithSkill = database.getEmployeesBySkill(new Skill(request.getSkillName()));
        List<Employee> result = getEmployeesWithSkillWithNames(employeesWithSkill);
        return new SearchEmployeesBySkillResponse(null, result);
    }

    private List<Employee> getEmployeesWithSkillWithNames(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        List<Employee> allEmployees = database.getAllEmployees();
        allEmployees.forEach(employee -> {
            for (Employee e : employees) {
                if (employee.getId().equals(e.getId())) {
                    result.add(employee);
                }
            }
        });
        return result;
    }
}