package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeSkillsRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllEmployeeSkillsService {

    @Autowired
    private EmployeeSkillsRepository employeeSkillsRepository;

    public GetAllEmployeeSkillsResponse execute(GetAllEmployeeSkillsRequest request) {
        List<EmployeeSkill> employeeSkills = employeeSkillsRepository.getAllEmplSkills();
        return new GetAllEmployeeSkillsResponse(employeeSkills);
    }
}