package hr_system.services_JK;

import hr_system.database.Database;

public class RemoveEmployeeService_JK {
    private final Database database;

    public RemoveEmployeeService_JK(Database database) {
        this.database = database;
    }

    public void remove(Long id) {
        database.deleteEmployee(id);
    }
}