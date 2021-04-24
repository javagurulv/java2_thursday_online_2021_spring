package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeeSkillsService;

public class GetAllEmployeeSkillUIAction implements UIAction {
    private GetAllEmployeeSkillsService service;

    public GetAllEmployeeSkillUIAction(GetAllEmployeeSkillsService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse response = service.execute(request);
        if (response.hasEmployeeSkills()) {
            response.getEmployeeSkills().forEach(eSkill -> System.out.println("Employee ID: "
                    + eSkill.getEmployee().getId() + "| skill: " + eSkill.getSkill().getSkillName()));
        } else {
            System.out.println("No skills added yet");
        }
    }

    @Override
    public String toString() {
        return "Show all employee skills";
    }
}