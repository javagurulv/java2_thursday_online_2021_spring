package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.AddSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddSkillController {

    @Autowired
    private AddSkillService service;

    @GetMapping(value = "/AddSkill")
    public String showAddSkillPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddSkillRequest());
        return "AddSkill";
    }

    @PostMapping("/AddSkill")
    public String processAddSkillRequest(@ModelAttribute(value = "request") AddSkillRequest request, ModelMap modelMap) {
        AddSkillResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "AddSkill";
        } else {
            return "adminPage";
        }
    }
}