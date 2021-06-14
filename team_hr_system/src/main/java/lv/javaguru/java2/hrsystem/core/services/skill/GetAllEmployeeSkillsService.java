package lv.javaguru.java2.hrsystem.core.services.skill;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class GetAllEmployeeSkillsService {

    @Autowired
    private ORMEmployeeRepository ormEmployeeRepository;
   // private EmployeeSkillsRepository employeeSkillsRepository;

    public GetAllEmployeeSkillsResponse execute(GetAllEmployeeSkillsRequest request) {
        List<Employee> employees = ormEmployeeRepository.getAllEmployees();
        Map<Employee, Set<Skill>> employeeSkillsMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeSkillsMap.put(employee, employee.getSkills());
        }
        return new GetAllEmployeeSkillsResponse(employeeSkillsMap);
    }
}