package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.domain.Admin;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.List;
import java.util.Set;

public interface Database {

    void registrationAdm (Admin admin);

    boolean loginAdm(String email, String password);

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List <Employee> getAllEmployees();

    List<Employee> getEmployeesByTitle(EmployeeTitle title);

    Set<EmployeeTitle> getAllTitles();

}