package lv.javaguru.java2.hrsystem.web_ui.controllers;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllTitlesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllTitlesResponse;
import lv.javaguru.java2.hrsystem.core.services.title.GetAllTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllTitlesController {

    @Autowired
    private GetAllTitlesService getAllTitlesService;

    @GetMapping(value = "/GetAllTitles")
    public String showGetAllTitlesPage(ModelMap modelMap) {
        GetAllTitlesRequest request = new GetAllTitlesRequest();
        GetAllTitlesResponse response = getAllTitlesService.execute(request);
        modelMap.addAttribute("employeeTitles", response.getEmployeeTitles());
        return "GetAllTitles";
    }
}