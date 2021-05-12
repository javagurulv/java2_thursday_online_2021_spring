package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesBySkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchEmployeesBySkillService {

    @Autowired private Database database;
    @Autowired private SearchEmployeesBySkillRequestValidator validator;

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