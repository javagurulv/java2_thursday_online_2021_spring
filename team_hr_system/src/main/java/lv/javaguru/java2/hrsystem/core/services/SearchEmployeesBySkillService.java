package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.jdbcrepos.EmployeeSkillsRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesBySkillRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class SearchEmployeesBySkillService {

    @Autowired
    private EmployeeSkillsRepository employeeSkillsRepository;

    @Autowired
    private SearchEmployeesBySkillRequestValidator validator;


    public SearchEmployeesBySkillResponse execute(SearchEmployeesBySkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchEmployeesBySkillResponse(errors, null);
        }
        Skill skillToSearch = new Skill(request.getSkillName());
        List<EmployeeSkill> employeesWithSkill = employeeSkillsRepository.getEmplSkillsBySkillName(skillToSearch);
        List<Employee> result = mapToEmployees(employeesWithSkill);
        return new SearchEmployeesBySkillResponse(null, result);
    }

    private List<Employee> mapToEmployees(List<EmployeeSkill> employeeSkills) {
        return employeeSkills.stream()
                .map(EmployeeSkill::getEmployee)
                .collect(toList());
    }
}