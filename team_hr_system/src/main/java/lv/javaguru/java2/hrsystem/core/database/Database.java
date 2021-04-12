package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.bean.EmployeeTitle;

import java.util.List;

public interface Database {

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List <Employee> getAllEmployees();

    List<Employee> getEmployeesByTitle(EmployeeTitle title);

}