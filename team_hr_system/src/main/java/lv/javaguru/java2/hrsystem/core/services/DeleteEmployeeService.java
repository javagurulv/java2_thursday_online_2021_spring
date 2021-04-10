package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;

public class DeleteEmployeeService {

    private Database database;

    public DeleteEmployeeService(Database database) {

        this.database = database;

    }

    public void execute (Long id) {

        database.deleteEmployee(id);

    }
}
