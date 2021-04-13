package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeesService;

public class GetAllEmployeesUIAction implements UIAction {

    private GetAllEmployeesService getAllEmployeesService;

    public GetAllEmployeesUIAction(GetAllEmployeesService getAllEmployeesService) {
        this.getAllEmployeesService = getAllEmployeesService;
    }

    @Override
    public void execute() {
        System.out.println("\n" + "Employees list:");
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        GetAllEmployeesResponse response = getAllEmployeesService.execute(request);
        response.getEmployees().forEach(System.out::println);
        System.out.println("---end of employees list---" + "\n");
    }

    @Override
    public String toString() {
        return "Show all employees";
    }
}
