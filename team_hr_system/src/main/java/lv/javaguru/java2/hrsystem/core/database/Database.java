package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.domain.Admin;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.List;

public interface Database {

    void registrationAdm (Admin admin);

    boolean loginAdm(String email, String password);

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List <Employee> getAllEmployees();

    List<Employee> getEmployeesByTitle(EmployeeTitle title);

    List<EmployeeTitle> getAllTitles();

}