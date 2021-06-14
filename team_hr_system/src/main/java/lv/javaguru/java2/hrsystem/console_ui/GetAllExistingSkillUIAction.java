package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllExistingSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllExistingSkillUIAction implements UIAction{

    @Autowired
    private GetAllExistingSkillsService service;

    @Override
    public void execute() {
        System.out.println("Currently added unique skills:");
        GetAllExistingSkillsRequest request = new GetAllExistingSkillsRequest();
        GetAllExistingSkillsResponse response = service.execute(request);
        if (response.hasSkills()) {
            response.getSkills().forEach(System.out::println);
        }
        else {
            System.out.println("No skills added yet");
        }
    }

    @Override
    public String toString() {
        return  "Show all unique skills added so far";
    }
}