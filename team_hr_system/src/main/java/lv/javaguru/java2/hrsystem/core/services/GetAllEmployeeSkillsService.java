package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.EmployeeSkill;

import java.util.List;

@DIComponent
public class GetAllEmployeeSkillsService {
    @DIDependency
    private Database database;

  /*  public GetAllEmployeeSkillsService(Database database) {
        this.database = database;
    }*/

    public GetAllEmployeeSkillsResponse execute(GetAllEmployeeSkillsRequest request) {
        List<EmployeeSkill> employeeSkills = database.getAllSkills();
        return new GetAllEmployeeSkillsResponse(employeeSkills);
    }
}