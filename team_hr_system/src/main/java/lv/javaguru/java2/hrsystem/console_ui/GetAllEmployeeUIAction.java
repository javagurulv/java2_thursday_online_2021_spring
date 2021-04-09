package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.services.GetAllEmployeeService;

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
