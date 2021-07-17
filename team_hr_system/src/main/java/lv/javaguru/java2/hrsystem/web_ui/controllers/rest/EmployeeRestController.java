package lv.javaguru.java2.hrsystem.web_ui.controllers.rest;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeWithTitleService;
import lv.javaguru.java2.hrsystem.core.services.employee.DeleteEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.employee.GetAllEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private AddEmployeeWithTitleService addEmployeeWithTitleService;

    @Autowired
    private DeleteEmployeeService deleteEmployeeService;

    @Autowired
    private GetAllEmployeesService getAllEmployeesService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddEmployeeWithTitleResponse addEmployeeWithTitle(@RequestBody AddEmployeeWithTitleRequest request) {
        return addEmployeeWithTitleService.execute(request);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public DeleteEmployeeResponse deleteEmployee(@PathVariable Long id) {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(id);
        return deleteEmployeeService.execute(request);
    }

    @GetMapping(path = "/getAllEmployees", produces = "application/json")
    public GetAllEmployeesResponse getAllEmployees() {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        return getAllEmployeesService.execute(request);
    }
}