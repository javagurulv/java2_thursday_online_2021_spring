package lv.javaguru.java2.hrsystem.services_JK;

import lv.javaguru.java2.hrsystem.database.Database;

public class RemoveEmployeeService_JK {
    private final Database database;

    public RemoveEmployeeService_JK(Database database) {
        this.database = database;
    }

    public void remove(Long id) {
        database.deleteEmployee(id);
    }
}