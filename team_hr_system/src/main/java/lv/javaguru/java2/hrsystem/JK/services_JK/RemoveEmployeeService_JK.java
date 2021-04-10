package lv.javaguru.java2.hrsystem.JK.services_JK;

import lv.javaguru.java2.hrsystem.core.database.Database;

public class RemoveEmployeeService_JK {
    private final Database database;

    public RemoveEmployeeService_JK(Database database) {
        this.database = database;
    }

    public void remove(Long id) {
        database.deleteEmployee(id);
    }
}