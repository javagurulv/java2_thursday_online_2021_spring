package hr_system.console_ui;

import hr_system.services.GetAllEmployeeService;

public class GetAllEmployeeUIAction implements UIAction{

    private GetAllEmployeeService getAllEmployeeService;

    public GetAllEmployeeUIAction(GetAllEmployeeService getAllEmployeeService) {

        this.getAllEmployeeService = getAllEmployeeService;

    }

    @Override
    public void execute() {

        System.out.println("All employees list!" + "\n");

        getAllEmployeeService.execute().forEach(System.out::println);

        System.out.println();

    }

    @Override
    public String toString() {
        return "Get All Employees";
    }
}
