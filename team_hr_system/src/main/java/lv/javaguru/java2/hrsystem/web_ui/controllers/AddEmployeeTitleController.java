package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.title.AddEmployeeTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
    public String processAddEmployeeRequest(@ModelAttribute(value = "request") AddEmployeeTitleRequest request,
                                            ModelMap modelMap,
                                            HttpSession session) {

        AddEmployeeTitleResponse response = addEmployeeTitleService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "AddEmployeeTitle";
        } else {

            if (session.getAttribute("userRole").equals(UserRole.ADMIN)) {
                return "adminPage";
            } else {
                return "hrManagerPage";
            }
        }
    }
}