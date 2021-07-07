package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeWithTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddEmployeeWithTitleController {

    @Autowired
    private AddEmployeeWithTitleService addEmployeeWithTitleService;

    @GetMapping(value = "/AddEmployeeWithTitle")
    public String showAddEmployeeWithTitlePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddEmployeeWithTitleRequest());
        return "AddEmployeeWithTitle";
    }

    @PostMapping("/AddEmployeeWithTitle")
    public String processAddEmployeeWithTitleRequest(@ModelAttribute(value = "request") AddEmployeeWithTitleRequest request, ModelMap modelMap) {
        AddEmployeeWithTitleResponse response = addEmployeeWithTitleService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "AddEmployeeWithTitle";
        } else {
            return "adminPage";
        }
    }
}