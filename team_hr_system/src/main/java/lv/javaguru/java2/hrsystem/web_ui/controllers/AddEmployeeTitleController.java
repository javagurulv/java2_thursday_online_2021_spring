package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.title.AddEmployeeTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddEmployeeTitleController {

    @Autowired
    private AddEmployeeTitleService addEmployeeTitleService;

    @GetMapping(value = "/AddEmployeeTitle")
    public String showAddEmployeeTitlePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddEmployeeTitleRequest());
        return "AddEmployeeTitle";
    }

    @PostMapping("/AddEmployeeTitle")
    public String processAddEmployeeRequest(@ModelAttribute(value = "request") AddEmployeeTitleRequest request, ModelMap modelMap) {
        AddEmployeeTitleResponse response = addEmployeeTitleService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "AddEmployeeTitle";
        } else {
            return "adminPage";
        }
    }
}