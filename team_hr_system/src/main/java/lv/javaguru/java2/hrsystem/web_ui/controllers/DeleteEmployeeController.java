package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.DeleteEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteEmployeeController {


    @Autowired
    private DeleteEmployeeService deleteEmployeeService;

    @GetMapping(value = "/DeleteEmployee")
    public String deleteEmployeePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new DeleteEmployeeRequest());
        return "DeleteEmployee";
    }


    @PostMapping("/DeleteEmployee")
    public String processDeleteEmployeeRequest(@ModelAttribute(value = "request") DeleteEmployeeRequest request, ModelMap modelMap) {
        DeleteEmployeeResponse response = deleteEmployeeService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "DeleteEmployee";
        } else {
            return "adminPage";
        }
    }

}
