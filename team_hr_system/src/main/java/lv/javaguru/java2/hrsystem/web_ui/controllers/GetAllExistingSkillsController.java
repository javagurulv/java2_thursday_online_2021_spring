package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllExistingSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllExistingSkillsController {

    @Autowired
    private GetAllExistingSkillsService getAllExistingSkillsService;

    @GetMapping(value = "/GetAllExistingSkills")
    public String showGetAllTExistingSkillsPage(ModelMap modelMap) {
        GetAllExistingSkillsRequest request = new GetAllExistingSkillsRequest();
        GetAllExistingSkillsResponse response = getAllExistingSkillsService.execute(request);
        modelMap.addAttribute("allExistingSkills", response.getSkills());
        return "GetAllExistingSkills";
    }
}