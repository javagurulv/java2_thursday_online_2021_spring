package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllEmployeeSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class GetAllEmployeeSkillUIAction implements UIAction {

    @Autowired
    private GetAllEmployeeSkillsService service;

    @Override
    public void execute() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse response = service.execute(request);
        if (!response.getEmployeeSetMap().isEmpty()) {
            Map<Employee, Set<Skill>> employeeSkillsMap = response.getEmployeeSetMap();
            for (Map.Entry<Employee, Set<Skill>> entry : employeeSkillsMap.entrySet()) {
                System.out.println("Employee ID: " + entry.getKey().getId() + " | name: " + entry.getKey().getName() + " | last name: " + entry.getKey().getLastName());
                Set<Skill> skills = entry.getValue();
                if (!skills.isEmpty()) {
                    for (Skill skill : skills) {
                        System.out.println("Skill ID: " + skill.getSkillId() + " | " + skill.getSkillName());
                    }
                } else {
                    System.out.println("No skills added yet for this employee");
                }
                System.out.println("----------------------");
            }
        } else {
            System.out.println("No skills added yet");
        }
    }

    @Override
    public String toString() {
        return "Show all skills per employee";
    }
}