package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SearchEmployeesController {

    @Autowired
    private SearchEmployeesService service;

    @GetMapping(value = "/SearchEmployees")
    public String showSearchEmployeesPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchEmployeesRequest());
        return "SearchEmployees";
    }


    @PostMapping("/SearchEmployees")
    public String processSearchEmployeesRequest(@ModelAttribute(value = "request") SearchEmployeesRequest request, ModelMap modelMap) {
        SearchEmployeesResponse response = service.execute(request);

        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else{
            modelMap.addAttribute("employees", response.getEmployees());
        }
        return "SearchEmployees";
    }

}
