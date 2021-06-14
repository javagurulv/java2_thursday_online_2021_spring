package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.GetAllEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllEmployeesUIAction implements UIAction {

    @Autowired
    private GetAllEmployeesService getAllEmployeesService;


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
