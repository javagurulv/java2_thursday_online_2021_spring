package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.bean.Employee;

import java.util.List;

public interface Database {

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List <Employee> getAllEmployees();

}