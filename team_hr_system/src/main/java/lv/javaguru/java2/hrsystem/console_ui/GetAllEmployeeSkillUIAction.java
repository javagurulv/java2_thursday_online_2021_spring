package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeeSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllEmployeeSkillUIAction implements UIAction {

    @Autowired
    private GetAllEmployeeSkillsService service;

    @Override
    public void execute() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse response = service.execute(request);
        if (response.hasEmployeeSkills()) {
            response.getEmployeeSkills().forEach(eSkill -> System.out.println("Employee ID: "
                    + eSkill.getEmployee().getId() + " name: " + eSkill.getEmployee().getName() + " last name: " + eSkill.getEmployee().getLastName()
                    + " skill: " + eSkill.getSkill().getSkillName()));
        } else {
            System.out.println("No skills added yet");
        }
    }

    @Override
    public String toString() {
        return "Show all skills per employee";
    }
}