package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllEmployeeSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GetAllEmployeeSkillsController {

    @Autowired
    private GetAllEmployeeSkillsService service;

    @GetMapping(value = "/GetAllEmployeeSkill")
    public String showGetAllEmployeeSkillsPage(ModelMap modelMap) {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse response = service.execute(request);
        modelMap.addAttribute("employeeSetMap", response.getEmployeeSetMap());
        return "GetAllEmployeeSkill";
    }
}