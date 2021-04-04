package hr_system.services;

import hr_system.database.Database;

public class DeleteEmployeeService {

    private Database database;

    public DeleteEmployeeService(Database database) {

        this.database = database;

    }

    public void execute (Long id) {

        database.deleteEmployee(id);

    }
}
