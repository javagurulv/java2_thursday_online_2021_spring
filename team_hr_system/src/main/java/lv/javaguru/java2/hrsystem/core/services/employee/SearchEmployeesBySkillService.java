package lv.javaguru.java2.hrsystem.core.services.employee;

import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesBySkillRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Component
public class SearchEmployeesBySkillService {

    @Autowired
    // private EmployeeSkillsRepository employeeSkillsRepository;
    private ORMSkillRepository ormSkillRepository;

    @Autowired
    private SearchEmployeesBySkillRequestValidator validator;

    public SearchEmployeesBySkillResponse execute(SearchEmployeesBySkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchEmployeesBySkillResponse(errors, null);
        }
        Skill skill = ormSkillRepository.getSkillByName(request.getSkillName());
        Set<Employee> employees = skill.getEmployees();
        return new SearchEmployeesBySkillResponse(employees);
    }

    private List<Employee> mapToEmployees(List<EmployeeSkill> employeeSkills) {
        return employeeSkills.stream()
                .map(EmployeeSkill::getEmployee)
                .collect(toList());
    }
}