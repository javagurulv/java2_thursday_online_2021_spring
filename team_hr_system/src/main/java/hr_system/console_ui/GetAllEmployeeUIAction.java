package hr_system.console_ui;

import hr_system.database.Database;

public class GetAllEmployeeUIAction implements UIAction{

    private Database database;

    public GetAllEmployeeUIAction(Database database) {

        this.database = database;

    }

    @Override
    public void execute() {

        System.out.println("All employees list!" + "\n");
        database.getAllEmployees().forEach(System.out::println);
        System.out.println();

    }

    @Override
    public String toString() {
        return "Get All Employees";
    }
}
