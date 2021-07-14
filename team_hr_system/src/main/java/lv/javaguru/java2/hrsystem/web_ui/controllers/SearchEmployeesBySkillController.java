package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesBySkillService;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SearchEmployeesBySkillController {

    @Autowired
    private SearchEmployeesBySkillService service;

    @GetMapping(value = "/SearchEmployeesBySkill")
    public String showSearchEmployeesPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchEmployeesBySkillRequest());
        return "SearchEmployeesBySkill";
    }


    @PostMapping("/SearchEmployeesBySkill")
    public String processSearchEmployeesRequest(@ModelAttribute(value = "request") SearchEmployeesBySkillRequest request, ModelMap modelMap) {
        SearchEmployeesBySkillResponse response = service.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else{
            modelMap.addAttribute("employees", response.getEmployeeSet());
        }
        return "SearchEmployeesBySkill";
    }

}
