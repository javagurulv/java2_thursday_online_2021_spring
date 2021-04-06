package hr_system.database;

import hr_system.bean.Employee;

import java.util.List;

public interface Database {

    void saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    List <Employee> getAllEmployees() ;

}