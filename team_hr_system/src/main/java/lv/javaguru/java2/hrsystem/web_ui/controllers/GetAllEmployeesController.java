package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.GetAllEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllEmployeesController {

    @Autowired
    private GetAllEmployeesService getAllEmployeesService;

    @GetMapping(value = "/GetAllEmployees")
    public String showGetAllEmployees(ModelMap modelMap) {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        GetAllEmployeesResponse response = getAllEmployeesService.execute(request);
        modelMap.addAttribute("employees", response.getEmployees());
        return "GetAllEmployees";
    }
}