package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.domain.EmployeeSkill;

import java.util.List;

public class GetAllEmployeeSkillsService {
    private Database database;

    public GetAllEmployeeSkillsService(Database database) {
        this.database = database;
    }

    public GetAllEmployeeSkillsResponse execute(GetAllEmployeeSkillsRequest request) {
        List<EmployeeSkill> employeeSkills = database.getAllSkills();
        return new GetAllEmployeeSkillsResponse(employeeSkills);
    }
}