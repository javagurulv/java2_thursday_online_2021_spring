package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllEmployeeSkillsService {

    @Autowired private Database database;

    public GetAllEmployeeSkillsResponse execute(GetAllEmployeeSkillsRequest request) {

        List<EmployeeSkill> employeeSkills = database.getAllSkills();
        return new GetAllEmployeeSkillsResponse(employeeSkills);
    }
}