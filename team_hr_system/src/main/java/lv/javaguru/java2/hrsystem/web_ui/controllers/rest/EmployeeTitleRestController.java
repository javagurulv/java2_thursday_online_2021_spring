package lv.javaguru.java2.hrsystem.web_ui.controllers.rest;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllTitlesRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllTitlesResponse;
import lv.javaguru.java2.hrsystem.core.services.title.AddEmployeeTitleService;
import lv.javaguru.java2.hrsystem.core.services.title.GetAllTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeTitle")
public class EmployeeTitleRestController {

    @Autowired
    private AddEmployeeTitleService addEmployeeTitleService;

    @Autowired
    private GetAllTitlesService getAllTitlesService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddEmployeeTitleResponse addEmployeeTitle(@RequestBody AddEmployeeTitleRequest request) {
        return addEmployeeTitleService.execute(request);
    }

    @GetMapping(path = "/getAllTitles", produces = "application/json")
    public GetAllTitlesResponse getAllEmployeeTitles() {
        GetAllTitlesRequest request = new GetAllTitlesRequest();
        return getAllTitlesService.execute(request);
    }
}