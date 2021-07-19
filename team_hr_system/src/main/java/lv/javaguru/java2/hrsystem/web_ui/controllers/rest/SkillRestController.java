package lv.javaguru.java2.hrsystem.web_ui.controllers.rest;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.AddSkillService;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllEmployeeSkillsService;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllExistingSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeSkill")
public class SkillRestController {

    @Autowired
    private AddSkillService addSkillService;

    @Autowired
    private GetAllEmployeeSkillsService getAllEmployeeSkillsService;

    @Autowired
    private GetAllExistingSkillsService getAllExistingSkillsService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddSkillResponse addEmployeeSkill(@RequestBody AddSkillRequest request) {
        return addSkillService.execute(request);
    }

    @GetMapping(path = "/getAllEmployeeSkills", produces = "application/json")
    public GetAllEmployeeSkillsResponse getAllEmployeeSkills() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        return getAllEmployeeSkillsService.execute(request);
    }

    @GetMapping(path = "/getAllExistingSkills", produces = "application/json")
    public GetAllExistingSkillsResponse getAllExistingSkills() {
        GetAllExistingSkillsRequest request = new GetAllExistingSkillsRequest();
        return getAllExistingSkillsService.execute(request);
    }
}