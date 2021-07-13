package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddEmployeeController {

    @Autowired
    private AddEmployeeService addEmployeeService;

    @GetMapping(value = "/AddEmployee")
    public String showAddEmployeePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddEmployeeRequest());
        return "AddEmployee";
    }

    @PostMapping("/AddEmployee")
    public String processAddEmployeeRequest(@ModelAttribute(value = "request")
                                                        AddEmployeeRequest request, ModelMap modelMap, HttpSession session) {
        AddEmployeeResponse response = addEmployeeService.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "AddEmployee";
        } else {

            if(session.getAttribute("userRole").equals(UserRole.ADMIN)){
                return "adminPage";
            } else {
                return "hrManagerPage";
            }

        }
    }
}