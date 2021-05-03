package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeesService;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;

@DIComponent
public class GetAllEmployeesUIAction implements UIAction {

    @DIDependency
    private GetAllEmployeesService getAllEmployeesService;

   /* public GetAllEmployeesUIAction(GetAllEmployeesService getAllEmployeesService) {
        this.getAllEmployeesService = getAllEmployeesService;
    }*/

    @Override
    public void execute() {
        System.out.println("\n" + "Employees list:");
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        GetAllEmployeesResponse response = getAllEmployeesService.execute(request);
        if (response.hasEmployees()) {
            response.getEmployees().forEach(System.out::println);
            System.out.println("---end of employees list---" + "\n");
        }
        else {
            System.out.println("No employees added yet");
        }
    }

    @Override
    public String toString() {
        return "Show all employees";
    }
}
