package lv.javaguru.java2.hrsystem.services;

import lv.javaguru.java2.hrsystem.database.Database;

public class DeleteEmployeeService {

    private Database database;

    public DeleteEmployeeService(Database database) {

        this.database = database;

    }

    public void execute (Long id) {

        database.deleteEmployee(id);

    }
}
